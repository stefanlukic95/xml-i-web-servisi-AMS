using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using XML_Agent.Models;
using XML_Agent.IServices;
using XML_Agent.Services;
namespace XML_Agent.Controllers
{
    public class SmestajController : ApiController
    {
        private readonly ISmestajService smestajService;
        public SmestajController()
        {
            smestajService = new SmestajServices();
        }
        // GET api/student/id  
        public HttpResponseMessage Get(string id)
        {
            var smestaj = smestajService.Get(id);
            if (smestaj != null) return Request.CreateResponse(HttpStatusCode.OK, smestaj);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "Student not found for provided id.");
        }
        public HttpResponseMessage GetAll()
        {
            var smestaj = smestajService.GetAll();
            if (smestaj.Any()) return Request.CreateResponse(HttpStatusCode.OK, smestaj);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No students found.");
        }
        public void Post([FromBody] Smestaj smestaj)
        {
            smestajService.Insert(smestaj);
        }
        public void Delete(string id)
        {
            smestajService.Delete(id);
        }
        public void Put([FromBody] Smestaj smestaj)
        {
            smestajService.Update(smestaj);

        }
    }
}

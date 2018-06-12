using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using XML_Agent.IServices;
using XML_Agent.Services;
using XML_Agent.Models;

namespace XML_Agent.Controllers
{
    public class DodatnaUslugaController : ApiController
    {
        private readonly IDodatnaUslugaService dodatnaUslugaService;

        public DodatnaUslugaController()
        {
            dodatnaUslugaService = new DodatnaUslugaService();
        }
        // GET api/student/id  
        public HttpResponseMessage Get(string id)
        {
            var usluga = dodatnaUslugaService.Get(id);
            if (usluga != null) return Request.CreateResponse(HttpStatusCode.OK, usluga);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "Dodatna usluga not found for provided id.");
        }
        public HttpResponseMessage GetAll()
        {
            var usluga = dodatnaUslugaService.GetAll();
            if (usluga.Any()) return Request.CreateResponse(HttpStatusCode.OK, usluga);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No dodatna usluga found.");
        }
        public void Post([FromBody] DodatnaUsluga usluga)
        {
            dodatnaUslugaService.Insert(usluga);
        }
        public void Delete(string id)
        {
            dodatnaUslugaService.Delete(id);
        }
        public void Put([FromBody] DodatnaUsluga usluga)
        {
            dodatnaUslugaService.Update(usluga);

        }
    }
}

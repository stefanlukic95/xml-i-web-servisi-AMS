using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using XML_Agent.IServices;
using XML_Agent.Models;
using XML_Agent.Services;


namespace XML_Agent.Controllers
{
    public class TerminController : ApiController
    {
        private readonly ITerminService terminService;
        public TerminController()
        {
            terminService = new TerminService();
        }
        
        public HttpResponseMessage Get(string id)
        {
            var termin = terminService.Get(id);
            if (termin != null) return Request.CreateResponse(HttpStatusCode.OK, termin);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "Termin not found for provided id.");
        }
        public HttpResponseMessage GetAll()
        {
            var termin = terminService.GetAll();
            if (termin.Any()) return Request.CreateResponse(HttpStatusCode.OK, termin);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No termin found.");
        }
        public void Post([FromBody] Termin termin)
        {
            terminService.Insert(termin);
        }
        public void Delete(string id)
        {
            terminService.Delete(id);
        }
        public void Put([FromBody] Termin termin)
        {
            terminService.Update(termin);

        }
    }
}

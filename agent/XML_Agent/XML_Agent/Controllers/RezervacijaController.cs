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
    public class RezervacijaController : ApiController
    {
        private readonly IRezervacijaService rezervacijaService;

        public RezervacijaController()
        {
            rezervacijaService = new RezervacijaService();
        }
        // GET api/student/id  
        public HttpResponseMessage Get(string id)
        {
            var rezervacija = rezervacijaService.Get(id);
            if (rezervacija != null) return Request.CreateResponse(HttpStatusCode.OK, rezervacija);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "Rezervacija not found for provided id.");
        }
        public HttpResponseMessage GetAll()
        {
            var rezervacija = rezervacijaService.GetAll();
            if (rezervacija.Any()) return Request.CreateResponse(HttpStatusCode.OK, rezervacija);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No rezervacija found.");
        }
        public void Post([FromBody] Rezervacija rezervacija)
        {
            rezervacijaService.Insert(rezervacija);
        }
        public void Delete(string id)
        {
            rezervacijaService.Delete(id);
        }
        public void Put([FromBody] Rezervacija rezervacija)
        {
            rezervacijaService.Update(rezervacija);

        }
    }
}

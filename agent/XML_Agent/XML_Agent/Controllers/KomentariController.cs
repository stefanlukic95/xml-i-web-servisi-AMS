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
    public class KomentariController : ApiController
    {
        private readonly IkometariService komentariService;

        public KomentariController()
        {
            komentariService = new KomentariService();
        }
        // GET api/student/id  
        public HttpResponseMessage Get(string id)
        {
            var komentar = komentariService.Get(id);
            if (komentar != null) return Request.CreateResponse(HttpStatusCode.OK, komentar);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "Komentar not found for provided id.");
        }
        public HttpResponseMessage GetAll()
        {
            var komentar = komentariService.GetAll();
            if (komentar.Any()) return Request.CreateResponse(HttpStatusCode.OK, komentar);
            return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No komentar found.");
        }
        public void Post([FromBody] Komentari  komentar)
        {
            komentariService.Insert(komentar);
        }
        public void Delete(string id)
        {
            komentariService.Delete(id);
        }
        public void Put([FromBody] Komentari komentar)
        {
            komentariService.Update(komentar);

        }
    }
}

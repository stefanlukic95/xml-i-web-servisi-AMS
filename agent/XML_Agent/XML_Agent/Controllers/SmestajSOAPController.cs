using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.ServiceModel;
using System.Web.Http;
using XML_Agent.SmestajSOAP;

namespace XML_Agent.Controllers
{
    public class SmestajSOAPController : ApiController
    {
        private static SmestajSOAP ss;
        private getTipoviRequest gtr;

        BasicHttpBinding basic = new BasicHttpBinding();
        InstanceContext ic = new InstanceContext(new SmestajSOAP());
        SmestajServicePortClient p = new SmestajServicePortClient(new InstanceContext(new SmestajSOAP()), "SmestajServicePortSoap11", "SmestajServicePortSoap11");



        public SmestajSOAPController()
        {
            ss = new SmestajSOAP();
            gtr = new getTipoviRequest();
            gtr.name = "aaa";



        }

        [OperationContract]
        public HttpResponseMessage GetAll()
        {
            var smestaj = p.getTipovi(gtr);

            return Request.CreateResponse(HttpStatusCode.OK, smestaj);

        }
    }
}

package xmlProjectSpringbootstarter.smestaj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SmestajEndpoint {



 /*  private static final String NAMESPACE_URI = "smestaj";

    private SmestajRepSOAP smestajRepSOAP;


    @Autowired
    public SmestajEndpoint(SmestajRepSOAP smestajRepSOAP){
        this.smestajRepSOAP = smestajRepSOAP;
    }*/

   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SmestajRequest")
    @ResponsePayload
    public SmestajResponse getStudent(@RequestPayload SmestajRequest request) {
        SmestajResponse response = new SmestajResponse();
        response.setSmestaj(SmestajRepSOAP.findStudent(request.getNaziv()));

        return response;
    }*/


}

package xmlProjectSpringbootstarter.smestaj;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SmestajEndPoint {
    private static final String NAMESPACE_URI = "http://xmlProjectSpringbootstarter/";

    private SmestajService smestajService;

    /*@PayloadRoot(namespace = "", localPart = "SmestajResponse")
    @ResponsePayload
    public SmestajResponse insertSmestaj(@RequestPayload Smestaj request) {

    }*/
}

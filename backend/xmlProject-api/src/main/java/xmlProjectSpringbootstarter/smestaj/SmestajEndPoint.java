package xmlProjectSpringbootstarter.smestaj;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import smestaj.AddSmestajResponse;

@Endpoint
public class SmestajEndPoint {
    private static final String NAMESPACE_URI = "http://xmlProjectSpringbootstarter/";

    private SmestajService smestajService;

    /*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddSmestajResponse")
    @ResponsePayload
    public AddSmestajResponse insertSmestaj(@RequestPayload Smestaj response) {
        AddSmestajResponse responsee = new AddSmestajResponse();

    }*/
}

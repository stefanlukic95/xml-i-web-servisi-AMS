package xmlProjectSpringbootstarter.smestaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import smestaj.GetCoountryRequest;
import smestaj.GetCountryResponse;
import xmlProjectSpringbootstarter.drzava.Drzava;
import xmlProjectSpringbootstarter.drzava.DrzavaDAO;
import xmlProjectSpringbootstarter.drzava.DrzavaSOAPService;
import xmlProjectSpringbootstarter.drzava.DrzavaService;
//import smestaj.AddSmestajResponse;

@Endpoint
public class SmestajEndPoint {
    private static final String NAMESPACE_URI = "smestaj";

    private SmestajService smestajService;

/*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload Smestaj response) {
        AddSmestajResponse responsee = new AddSmestajResponse();

    }*/


    @Autowired
    private DrzavaSOAPService drzavaSOAPService;

    @Autowired
    private  DrzavaService drzavaService;




    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCoountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCoountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
       // response.setDrzava(drzavaSOAPService.findOne(request.getId()));

        Drzava drz = drzavaService.findOne(request.getId());

        smestaj.Drzava drz2 = new smestaj.Drzava();

        drz2.setId(drz.getId());
        drz2.setNaziv(drz.getNaziv());
        drz2.setSifra(drz.getSifra());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(drz2.getNaziv());
        response.setDrzava(drz2);

        return response;
    }


}

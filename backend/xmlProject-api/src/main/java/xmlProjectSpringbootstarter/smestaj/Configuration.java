package xmlProjectSpringbootstarter.smestaj;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private Bus bus; // bus upravlja svim endpoint-ima
    // anotiran je sa Autowired kako bi sam Spring vodio računa o njegovom instanciranju

    @Autowired
    SmestajSOAPService smestajSOAPService;  // instanciranje objekta klase AccomodationSoapServiceImpl se ne može 'ručno' vršiti (pomoću ključne reči: new) već se mora prepustiti Spring-u
    // na ovaj način se briga o instanciranju objekata prepušta Springu, pa će tako i @Autowired anotacija unutar klase AccomodationSoapService (koja se odnosi na DAO objekat) 'dobiti' odgovarajuću referencu, a ne null vrednost

   @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, smestajSOAPService);  // umesto Endpoint.publish(), instanciran objekat accomodationSoapService pridruzujemo na bus
       endpoint.publish("/smestajSOAPService");  // endpoint dobija svoj path tako da će celokupan url biti:  putanja_do_spring_boot_aplikacije + putanja_do_cxf_servleta + endpoint_path
        return endpoint;                               // pri tome je putanja_do_cxf_servleta definisana u application.properties
    }
}

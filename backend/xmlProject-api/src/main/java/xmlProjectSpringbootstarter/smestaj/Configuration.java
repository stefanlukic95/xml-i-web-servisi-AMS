package xmlProjectSpringbootstarter.smestaj;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUslugaSOAPService;
import xmlProjectSpringbootstarter.kategorija.KategorijaSOAPService;
import xmlProjectSpringbootstarter.poruka.PorukeSOAPService;
import xmlProjectSpringbootstarter.rezervacija.RezervacijaSOAPService;
import xmlProjectSpringbootstarter.termin.TerminSOAPService;
import xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaSOAPService;


@org.springframework.context.annotation.Configuration
public class Configuration {


    //SMESTAJ
    @Autowired
    private Bus buss;


    @Autowired
    SmestajSOAPService smestajSOAPService;

   @Bean
    public Endpoint endpoints() {
        EndpointImpl endpoints = new EndpointImpl(buss, smestajSOAPService);
       endpoints.publish("/smestajSOAPService");
        return endpoints;
    }

    //ZAUZETOST
    @Autowired
    private Bus busz;


    @Autowired
    ZauzetostSOAPService zauzetostSOAPService;

    @Bean
    public Endpoint endpointz() {
        EndpointImpl endpointz = new EndpointImpl(busz, zauzetostSOAPService);
        endpointz.publish("/zauzetostSOAPService");
        return endpointz;
    }


    //DODATNE USLUGE
    @Autowired
    private Bus busd;


    @Autowired
    DodatnaUslugaSOAPService dodatnaUslugaSOAPService;

    @Bean
    public Endpoint endpointd() {
        EndpointImpl endpointd = new EndpointImpl(busd, dodatnaUslugaSOAPService);
        endpointd.publish("/dodatnaUslugaSOAPService");
        return endpointd;
    }


    //TIP SMESTAJA
    @Autowired
    private Bus bust;


    @Autowired
    TipsmestajaSOAPService tipsmestajaSOAPService;

    @Bean
    public Endpoint endpointt() {
        EndpointImpl endpointt = new EndpointImpl(bust, tipsmestajaSOAPService);
        endpointt.publish("/tipsmestajaSOAPService");
        return endpointt;
    }


    //KATEGORIJA
    @Autowired
    private Bus busk;


    @Autowired
    KategorijaSOAPService kategorijaSOAPService;

    @Bean
    public Endpoint endpointk() {
        EndpointImpl endpointk = new EndpointImpl(bust, kategorijaSOAPService);
        endpointk.publish("/kategorijaSOAPService");
        return endpointk;
    }

    //REZERVACIJA
    @Autowired
    private Bus busr;


    @Autowired
    RezervacijaSOAPService rezervacijaSOAPService;

    @Bean
    public Endpoint endpointr() {
        EndpointImpl endpointr = new EndpointImpl(busr, rezervacijaSOAPService);
        endpointr.publish("/rezervacijaSOAPService");
        return endpointr;
    }



    //PORUKA
    @Autowired
    private Bus busp;


    @Autowired
    PorukeSOAPService porukeSOAPService;

    @Bean
    public Endpoint endpointp() {
        EndpointImpl endpointp = new EndpointImpl(busp, porukeSOAPService);
        endpointp.publish("/porukeSOAPService");
        return endpointp;
    }

    //TERMINI
    @Autowired
    private Bus bustermin;


    @Autowired
    TerminSOAPService terminSOAPService;

    @Bean
    public Endpoint endpointtermin() {
        EndpointImpl endpointtermin = new EndpointImpl(bustermin, terminSOAPService);
        endpointtermin.publish("/terminSOAPService");
        return endpointtermin;
    }

}

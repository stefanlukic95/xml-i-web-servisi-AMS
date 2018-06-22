package xmlProjectSpringbootstarter.smestaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import smestaj.*;
import smestaj.Zauzetost;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUsluga;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUslugaService;
import xmlProjectSpringbootstarter.drzava.Drzava;
import xmlProjectSpringbootstarter.drzava.DrzavaSOAPService;
import xmlProjectSpringbootstarter.drzava.DrzavaService;
import xmlProjectSpringbootstarter.kategorija.Kategorija;
import xmlProjectSpringbootstarter.kategorija.KategorijaService;
import xmlProjectSpringbootstarter.komentari.Komentari;
import xmlProjectSpringbootstarter.komentari.KomentariService;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.korisnik.KorisnikService;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;
import xmlProjectSpringbootstarter.rezervacija.RezervacijaService;
import xmlProjectSpringbootstarter.termin.Termin;
import xmlProjectSpringbootstarter.termin.TerminService;
import xmlProjectSpringbootstarter.tipsmestaja.Tipsmestaja;
import xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaSOAPService;
import xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

    @Autowired
    private TipsmestajaService tipsmestajaService;

    @Autowired
    private TipsmestajaSOAPService tipsmestajaSOAPService;

    @Autowired
    private KategorijaService kategorijaService;

    @Autowired
    private DodatnaUslugaService dodatnaUslugaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private KomentariService komentariService;

    @Autowired
    private TerminService terminService;



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
        response.setDrzava(drz2);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTipoviRequest")
    @ResponsePayload
    public GetTipoviResponse getTipovi(@RequestPayload GetTipoviRequest request){

        GetTipoviResponse response = new GetTipoviResponse();

        List<Tipsmestaja> tipsmestaja = tipsmestajaService.findAll();



        for(Tipsmestaja t: tipsmestaja){
            smestaj.TipSmestaja tip = new smestaj.TipSmestaja();
            tip.setId(t.getId());
            tip.setNaziv(t.getNaziv());
            response.getTip().add(tip);
        }


        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getKategorijeRequest")
    @ResponsePayload
    public GetKategorijeResponse getTipovi(@RequestPayload GetKategorijeRequest request){

        GetKategorijeResponse response = new GetKategorijeResponse();

        List<Kategorija> kategorija = kategorijaService.findAll();


        for(Kategorija k: kategorija){
            smestaj.Kategorija kat = new smestaj.Kategorija();
            kat.setId(k.getId());
            kat.setNaziv(k.getNaziv());
            response.getKategorija().add(kat);
        }

        return response;

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDodatneUslugeRequest")
    @ResponsePayload
    public GetDodatneUslugeResponse getDodatneUsluge(@RequestPayload GetDodatneUslugeRequest request){

        GetDodatneUslugeResponse response = new GetDodatneUslugeResponse();

        List<DodatnaUsluga> dusluga = dodatnaUslugaService.findAll();


        for(DodatnaUsluga d: dusluga){
            smestaj.DodatnaUsluga dus = new smestaj.DodatnaUsluga();
            dus.setId(d.getId());
            dus.setNaziv(d.getNaziv());
            response.getDodatnaUsluga().add(dus);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAgentRequest")
    @ResponsePayload
    public GetAgentResponse getAgeent(@RequestPayload GetAgentRequest request) {
        GetAgentResponse response = new GetAgentResponse();
        Korisnik agent = korisnikService.findByEmail(request.getEmail());
        Radnik radnik = new Radnik();
        radnik.setPmb(agent.getPmb());
        radnik.setAdresa(agent.getAdresa());
        radnik.setEmail(agent.getEmail());
        radnik.setId(agent.getId());
        radnik.setIme(agent.getIme());
        radnik.setPassword(agent.getPassword());
        radnik.setPrezime(agent.getPrezime());

        response.setAgent(radnik);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {

        AddSmestajResponse response = new AddSmestajResponse();

        Smestaj smestaj = new Smestaj();
        smestaj.setNaziv(request.getSmestaj().getNaziv());
        smestaj.setKapacitet(request.getSmestaj().getKapacitet());
        smestaj.setNaseljeno_mesto(request.getSmestaj().getNaseljenoMesto().getId());
        smestaj.setOpis(request.getSmestaj().getOpis());
        smestaj.setSlike(request.getSmestaj().getSlike());
        List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        List<smestaj.Rezervacija> rezervacijeSm = request.getSmestaj().getRezervacije();

        for(smestaj.Rezervacija r : rezervacijeSm) {
            Rezervacija r1 = new Rezervacija();
            r1.setDatumDolaska(r.getDatumDolaska().toGregorianCalendar().getTime());
            r1.setDatumOdlaska(r.getDatumOdlaska().toGregorianCalendar().getTime());
            r1.setSmestajNaziv(r.getNazivSmestaja());
            r1.setSmestajId(r.getIdSmestaja());
            r1.setKorisnikId(r.getIdKorisnika());
            r1.setAgent(korisnikService.findOne(r.getAgent().getId()));
            r1.setIzvrsena(r.isIzvrseno());
            r1.setCena(r.getCena());
            rezervacijaService.create(r1);
            rezervacije.add(r1);
        }

        smestaj.setRezervacije(rezervacije);

        List<Zauzetost> zauzetostSm = request.getSmestaj().getZauzeto();
        List<xmlProjectSpringbootstarter.smestaj.Zauzetost> zauzetost = new ArrayList<xmlProjectSpringbootstarter.smestaj.Zauzetost>();

        for(Zauzetost z : zauzetostSm) {
            xmlProjectSpringbootstarter.smestaj.Zauzetost z1 = new xmlProjectSpringbootstarter.smestaj.Zauzetost();
            z1.setDat_kraj(z.getDatumKraja().toGregorianCalendar().getTime());
            z1.setDat_pocetak(z.getDatumPocetka().toGregorianCalendar().getTime());
            zauzetost.add(z1);
        }

        smestaj.setZauzeto(zauzetost);

        List<Komentari> komentari = new ArrayList<Komentari>();
        List<Komentar> komentariSm = request.getSmestaj().getKomentari();

        for(Komentar k : komentariSm) {
            Komentari k1 = new Komentari();
            k1.setSadrzaj(k.getSadrzaj());
            k1.setIme(k.getIme());
            k1.setSmestajId(k.getIdSmestaja());
            k1.setOdobren(k.isOdobren());
            komentariService.create(k1);
            komentari.add(k1);

        }

        smestaj.setKomentari(komentari);

        smestaj.setAgent(request.getSmestaj().getAgent().getId());
        smestaj.setTipSmestaja(request.getSmestaj().getTipSmestaja().getId());
        smestaj.setKategorijaSmestaja(request.getSmestaj().getKategorijaSmestaja().getId());

        List<Termin> termini = new ArrayList<Termin>();
        List<smestaj.Termin> terminiSm = request.getSmestaj().getTermini();

        for(smestaj.Termin t : terminiSm) {
            Termin t1 = new Termin();
            t1.setCena(t.getCena());
            t1.setMesec(t.getMesec());
            terminService.create(t1);
            termini.add(t1);

        }

        smestaj.setTermini(termini);

        List<DodatnaUsluga> dodatne = new ArrayList<DodatnaUsluga>();
        List<smestaj.DodatnaUsluga> dodatneSm = request.getSmestaj().getDodtaneUsluge();

        for(smestaj.DodatnaUsluga d : dodatneSm) {
            dodatne.add(dodatnaUslugaService.findOne(d.getId()));
        }

        smestaj.setDodatne_usluge(dodatne);

        Smestaj noviSmestaj = smestajService.create(smestaj);

        response.setName("Ubacen novi smestaj: " + noviSmestaj.getNaziv());

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addZauzetostRequest")
    @ResponsePayload
    public AddZauzetostResponse addSmestaj(@RequestPayload AddZauzetostRequest request) {

        AddZauzetostResponse response = new AddZauzetostResponse();

        Smestaj smestaj = smestajService.findOne(request.getZauzetost().getIdSmestaja());
        xmlProjectSpringbootstarter.smestaj.Zauzetost zauzetost = new xmlProjectSpringbootstarter.smestaj.Zauzetost();
        zauzetost.setDat_pocetak(request.getZauzetost().getDatumPocetka().toGregorianCalendar().getTime());
        zauzetost.setDat_kraj(request.getZauzetost().getDatumKraja().toGregorianCalendar().getTime());
        smestaj.getZauzeto().add(zauzetost);
        smestajService.update(smestaj);

        response.setMessage("Ubacena zauzetost");

        return response;

    }



}

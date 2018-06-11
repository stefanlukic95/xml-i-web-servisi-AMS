package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.korisnik.KorisnikService;
import xmlProjectSpringbootstarter.smestaj.Smestaj;
import xmlProjectSpringbootstarter.smestaj.SmestajService;
import xmlProjectSpringbootstarter.smestaj.Zauzetost;

import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private SmestajService smestajService;

    public RezervacijaController(RezervacijaService rezervacijaService){
        this.rezervacijaService = rezervacijaService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/rezervacija",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Rezervacija>> getAll() {
        List<Rezervacija> rezervacija = rezervacijaService.findAll();
        return new ResponseEntity<List<Rezervacija>>(rezervacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/rezervacija/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rezervacija> getRezervazija(@PathVariable("id") String id) {
        Rezervacija rezervacija = this.rezervacijaService.findOne(id);
        if(rezervacija == null){
            return new ResponseEntity<Rezervacija>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Rezervacija>(rezervacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/rezervacija",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rezervacija> insertRezervacija(@RequestParam(value = "smestaj", required = true) String idSmestaj, @RequestParam(value = "korisnik", required = true) String idKorisnik, @RequestBody Rezervacija rezervacija) throws Exception{

        rezervacija.setIzvrsena(false);
        Smestaj smestaj = smestajService.findOne(idSmestaj);
        rezervacija.setSmestajNaziv(smestaj.getNaziv());
        rezervacija.setSmestajId(idSmestaj);
        rezervacija.setKorisnikId(idKorisnik);
        rezervacija.setAgent(korisnikService.findOne(smestaj.getAgent()));
        Korisnik korisnik = korisnikService.findOne(idKorisnik);
        Rezervacija createdRezervacija  = this.rezervacijaService.create(rezervacija);
        smestaj.getRezervacije().add(createdRezervacija);
        Zauzetost zauz = new Zauzetost(createdRezervacija.getDatumDolaska(), createdRezervacija.getDatumOdlaska());
        smestaj.getZauzeto().add(zauz);
        korisnik.getRezervacije().add(createdRezervacija);
        korisnikService.update(korisnik);
        smestajService.update(smestaj);

        return new ResponseEntity<Rezervacija>(createdRezervacija, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/rezervacija/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rezervacija> updateRezervacija(@PathVariable("id") String id, @RequestBody Rezervacija rezervacija) throws Exception{
        Rezervacija rezervacije = this.rezervacijaService.findOne(id);

        if(rezervacije == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Rezervacija updateRezervacija = this.rezervacijaService.update(rezervacija);
        if (updateRezervacija == null) {
            return new ResponseEntity<Rezervacija>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateRezervacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/rezervacija/{id}"
    )
    public ResponseEntity<Rezervacija> deleteRezervacija(@PathVariable("id") String id){
        Rezervacija rezervacija = rezervacijaService.findOne(id);
        Smestaj smestaj = smestajService.findOne(rezervacija.getSmestajId());
        Korisnik korisnik = korisnikService.findOne(rezervacija.getKorisnikId());
        Rezervacija rezBrisanjeS = null;
        Rezervacija rezBrisanjeK = null;
        Zauzetost zauBrisanje = null;


        for(Rezervacija rez : smestaj.getRezervacije()) {
            if(rez.getId().equals(rezervacija.getId())) {
                System.out.println("BRISE REZERVACIJU IZ SMESTAJAA");
                rezBrisanjeS = rez;
            }
        }

        for(Zauzetost zau : smestaj.getZauzeto()) {
            System.out.println("DATUMIIIIIIIIII");
            System.out.println("pocetak");
            System.out.println(zau.getDat_pocetak());
            System.out.println(rezervacija.getDatumDolaska());
            System.out.println("kraj");
            System.out.println(zau.getDat_kraj());
            System.out.println(rezervacija.getDatumOdlaska());
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(zau.getDat_pocetak());
            cal2.setTime(rezervacija.getDatumDolaska());
            if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
                System.out.println("DOBRO POREDIIIIIIIIIIIIIIIII");
                zauBrisanje = zau;
            }
        }

        for(Rezervacija rez: korisnik.getRezervacije()) {
            if(rez.getId().equals(rezervacija.getId())) {
                System.out.println("BRISE REZERVACIJU IZ KORISNIKA");
                rezBrisanjeK = rez;
            }
        }

        smestaj.getRezervacije().remove(rezBrisanjeS);
        smestaj.getZauzeto().remove(zauBrisanje);
        korisnik.getRezervacije().remove(rezBrisanjeK);
        smestajService.update(smestaj);
        korisnikService.update(korisnik);

        this.rezervacijaService.delete(id);
        return new ResponseEntity<Rezervacija>(HttpStatus.OK);
    }
}

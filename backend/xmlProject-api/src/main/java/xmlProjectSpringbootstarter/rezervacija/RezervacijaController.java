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
            value = "/rezervacija/{smestajId}/{korisnikId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rezervacija> insertRezervacija(@PathVariable ("smestajId") String idSmestaj, @PathVariable ("korisnikId") String idKorisnik, @RequestBody Rezervacija rezervacija) throws Exception{
        Rezervacija createdRezervacija  = this.rezervacijaService.create(rezervacija);
        Smestaj smestaj = smestajService.findOne(idSmestaj);
        Korisnik korisnik = korisnikService.findOne(idKorisnik);
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
        this.rezervacijaService.delete(id);
        return new ResponseEntity<Rezervacija>(HttpStatus.NO_CONTENT);
    }
}

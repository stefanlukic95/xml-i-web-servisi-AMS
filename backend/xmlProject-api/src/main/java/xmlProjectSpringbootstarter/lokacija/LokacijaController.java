package xmlProjectSpringbootstarter.lokacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LokacijaController {

    @Autowired
    private LokacijaService lokacijaService;

    public LokacijaController(LokacijaService smestajService){
        this.lokacijaService = lokacijaService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/lokacija",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Lokacija>> getAll() {
        List<Lokacija> lokacija = lokacijaService.findAll();
        return new ResponseEntity<List<Lokacija>>(lokacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/lokacija/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Lokacija> getLokacija(@PathVariable("id") String id) {
        Lokacija lokacija = this.lokacijaService.findOne(id);
        if(lokacija == null){
            return new ResponseEntity<Lokacija>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Lokacija>(lokacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/lokacija",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Lokacija> insertLokacija(@RequestBody Lokacija lokacija) throws Exception{
        Lokacija createdLokacija  = this.lokacijaService.create(lokacija);
        return new ResponseEntity<Lokacija>(createdLokacija, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/loakcija/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Lokacija> updateLokacija(@PathVariable("id") String id, @RequestBody Lokacija lokacija) throws Exception{
        Lokacija lokacije = this.lokacijaService.findOne(id);

        if(lokacije == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Lokacija updateLokacija = this.lokacijaService.update(lokacija);
        if (updateLokacija == null) {
            return new ResponseEntity<Lokacija>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateLokacija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/lokacija/{id}"
    )
    public ResponseEntity<Lokacija> deleteLoacija(@PathVariable("id") String id){
        this.lokacijaService.delete(id);
        return new ResponseEntity<Lokacija>(HttpStatus.NO_CONTENT);
    }


}

package xmlProjectSpringbootstarter.termin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TerminController {

    @Autowired
    private TerminService terminService;

    public TerminController(TerminService terminService){
        this.terminService = terminService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/termin",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Termin>> getAll() {
        List<Termin> termin = terminService.findAll();
        return new ResponseEntity<List<Termin>>(termin, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/termin/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Termin> getTermin(@PathVariable("id") String id) {
        Termin termin = this.terminService.findOne(id);
        if(termin == null){
            return new ResponseEntity<Termin>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Termin>(termin, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/termin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Termin> insertTermin(@RequestBody Termin termin) throws Exception{
        Termin createdTermin  = this.terminService.create(termin);
        return new ResponseEntity<Termin>(createdTermin, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/termin/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Termin> updateTermin(@PathVariable("id") String id, @RequestBody Termin termin) throws Exception{
        Termin termini = this.terminService.findOne(id);

        if(termini == null){
            return new ResponseEntity<Termin>(HttpStatus.NOT_FOUND);
        }
        Termin updateTermin = this.terminService.update(termin);
        if (updateTermin == null) {
            return new ResponseEntity<Termin>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Termin>(updateTermin, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/termin/{id}"
    )
    public ResponseEntity<Termin> deleteTermin(@PathVariable("id") String id){
        this.terminService.delete(id);
        return new ResponseEntity<Termin>(HttpStatus.NO_CONTENT);
    }
}

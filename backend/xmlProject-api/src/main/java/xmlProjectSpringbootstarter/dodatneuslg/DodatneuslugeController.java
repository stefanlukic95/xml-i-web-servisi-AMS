package xmlProjectSpringbootstarter.dodatneuslg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DodatneuslugeController {

    @Autowired
    private DodatneuslugeService dodatneuslugeService;

    public DodatneuslugeController(DodatneuslugeService dodatneuslugeService){this.dodatneuslugeService=dodatneuslugeService;}

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/dodatneusluge",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Dodatneusluge>> getAll() {
        List<Dodatneusluge> smestaj = dodatneuslugeService.findAll();
        return new ResponseEntity<List<Dodatneusluge>>(smestaj, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/dodatneusluge/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Dodatneusluge> getUsluga(@PathVariable("id") String id) {
        Dodatneusluge dusluga = this.dodatneuslugeService.findOne(id);
        if(dusluga == null){
            return new ResponseEntity<Dodatneusluge>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Dodatneusluge>(dusluga, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/dodatneusluge",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Dodatneusluge> insertDusluga(@RequestBody Dodatneusluge dusluga) throws Exception{
        Dodatneusluge createdDusluga  = this.dodatneuslugeService.create(dusluga);
        return new ResponseEntity<Dodatneusluge>(createdDusluga, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/dodatneusluge/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Dodatneusluge> updateDusluge(@PathVariable("id") String id, @RequestBody Dodatneusluge dusluga) throws Exception{
        Dodatneusluge dusluge = this.dodatneuslugeService.findOne(id);

        if(dusluge == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Dodatneusluge updateDusluga = this.dodatneuslugeService.update(dusluga);
        if (updateDusluga == null) {
            return new ResponseEntity<Dodatneusluge>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateDusluga, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/dodatneusluge/{id}"
    )
    public ResponseEntity<Dodatneusluge> deleteDusluga(@PathVariable("id") String id){
        this.dodatneuslugeService.delete(id);
        return new ResponseEntity<Dodatneusluge>(HttpStatus.NO_CONTENT);
    }

}

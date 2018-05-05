package xmlProjectSpringbootstarter.smestaj;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SmestajController {

    @Autowired
    private SmestajService smestajService;

    public SmestajController(SmestajService smestajService){
        this.smestajService = smestajService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/smestaj",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Smestaj>> getAll() {
        List<Smestaj> smestaj = smestajService.findAll();
        return new ResponseEntity<List<Smestaj>>(smestaj, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/smestaj/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Smestaj> getSmestaj(@PathVariable("id") String id) {
        Smestaj smestaj = this.smestajService.findOne(id);
        if(smestaj == null){
            return new ResponseEntity<Smestaj>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Smestaj>(smestaj, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/smestaj",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Smestaj> insertSmestaj(@RequestBody Smestaj smestaj) throws Exception{
        Smestaj createdSmestaj  = this.smestajService.create(smestaj);
        return new ResponseEntity<Smestaj>(createdSmestaj, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/smestaj/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Smestaj> updateSmestaj(@PathVariable("id") String id, @RequestBody Smestaj smestaj) throws Exception{
        Smestaj smestaji = this.smestajService.findOne(id);

        if(smestaji == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Smestaj updateSmestaj = this.smestajService.update(smestaj);
        if (updateSmestaj == null) {
            return new ResponseEntity<Smestaj>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateSmestaj, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/smestaj/{id}"
    )
    public ResponseEntity<Smestaj> deleteSmestaj(@PathVariable("id") String id){
        this.smestajService.delete(id);
        return new ResponseEntity<Smestaj>(HttpStatus.NO_CONTENT);
    }

}

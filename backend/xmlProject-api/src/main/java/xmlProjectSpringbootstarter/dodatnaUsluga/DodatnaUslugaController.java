package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DodatnaUslugaController {

    @Autowired
    private DodatnaUslugaService dodatnaUslugaService;

    public DodatnaUslugaController(DodatnaUslugaService dodatnaUslugaService){
        this.dodatnaUslugaService = dodatnaUslugaService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/dodatneusluge",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<DodatnaUsluga>> getAll() {
        List<DodatnaUsluga> dusluga = dodatnaUslugaService.findAll();
        return new ResponseEntity<List<DodatnaUsluga>>(dusluga, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/dodatneusluge/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DodatnaUsluga> getDodatneUsluge(@PathVariable("id") String id) {
        DodatnaUsluga dusluga = this.dodatnaUslugaService.findOne(id);
        if(dusluga == null){
            return new ResponseEntity<DodatnaUsluga>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DodatnaUsluga>(dusluga, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/dodatneusluge",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DodatnaUsluga> insertDodatnaUsluga(@RequestBody DodatnaUsluga dusluga) throws Exception{
        DodatnaUsluga createdDusluga  = this.dodatnaUslugaService.create(dusluga);
        return new ResponseEntity<DodatnaUsluga>(createdDusluga, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/dodatneusluge/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DodatnaUsluga> updateDodatneUsluge(@PathVariable("id") String id, @RequestBody DodatnaUsluga dusluga) throws Exception{
        DodatnaUsluga dusluge = this.dodatnaUslugaService.findOne(id);

        if(dusluge == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DodatnaUsluga updateDodatnaUsluga = this.dodatnaUslugaService.update(dusluga);
        if (updateDodatnaUsluga == null) {
            return new ResponseEntity<DodatnaUsluga>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateDodatnaUsluga, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/dodatneusluge/{id}"
    )
    public ResponseEntity<DodatnaUsluga> deleteDodatnaUsluga(@PathVariable("id") String id){
        this.dodatnaUslugaService.delete(id);
        return new ResponseEntity<DodatnaUsluga>(HttpStatus.NO_CONTENT);
    }
}

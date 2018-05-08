package xmlProjectSpringbootstarter.tipsmestaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TipsmestajaController {

    @Autowired
    private TipsmestajaService tipsmestajaService;

    public TipsmestajaController(TipsmestajaService tipsmestajaService){
        this.tipsmestajaService = tipsmestajaService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/tipsmestaja",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Tipsmestaja>> getAll() {
        List<Tipsmestaja> tipsmestaja = tipsmestajaService.findAll();
        return new ResponseEntity<List<Tipsmestaja>>(tipsmestaja, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/tipsmestaja/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Tipsmestaja> getTipsmestaja(@PathVariable("id") String id) {
        Tipsmestaja tipsmestaja = this.tipsmestajaService.findOne(id);
        if(tipsmestaja == null){
            return new ResponseEntity<Tipsmestaja>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tipsmestaja>(tipsmestaja, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/tipsmestaja",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Tipsmestaja> insertTipsmestaja(@RequestBody Tipsmestaja tipsmestaja) throws Exception{
        Tipsmestaja createdTipsmestaja  = this.tipsmestajaService.create(tipsmestaja);
        return new ResponseEntity<Tipsmestaja>(createdTipsmestaja, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/tipsmestaja/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Tipsmestaja> updateTipsmestaja(@PathVariable("id") String id, @RequestBody Tipsmestaja tipsmestaja) throws Exception{
        Tipsmestaja tipovi = this.tipsmestajaService.findOne(id);

        if(tipovi == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tipsmestaja updateTipsmestaja = this.tipsmestajaService.update(tipsmestaja);
        if (updateTipsmestaja == null) {
            return new ResponseEntity<Tipsmestaja>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateTipsmestaja, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/tipsmestaja/{id}"
    )
    public ResponseEntity<Tipsmestaja> deleteTipsmestaja(@PathVariable("id") String id){
        this.tipsmestajaService.delete(id);
        return new ResponseEntity<Tipsmestaja>(HttpStatus.NO_CONTENT);
    }

}

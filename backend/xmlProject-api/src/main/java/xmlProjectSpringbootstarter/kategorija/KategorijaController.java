package xmlProjectSpringbootstarter.kategorija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class KategorijaController {

    @Autowired
    private KategorijaService kategorijaService;

    public KategorijaController(KategorijaService kategorijaService){
        this.kategorijaService = kategorijaService;
    }



    @RequestMapping(
            method = RequestMethod.GET,
            value ="/kategorija",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Kategorija>> getAll() {
        List<Kategorija> kategorija = kategorijaService.findAll();
        return new ResponseEntity<List<Kategorija>>(kategorija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/kategorija/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Kategorija> getKategorija(@PathVariable("id") String id) {
        Kategorija kategorija = this.kategorijaService.findOne(id);
        if(kategorija == null){
            return new ResponseEntity<Kategorija>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Kategorija>(kategorija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/kategorija",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Kategorija> insertKategorija(@RequestBody Kategorija kategorija) throws Exception{
        Kategorija createdKategorija  = this.kategorijaService.create(kategorija);
        return new ResponseEntity<Kategorija>(createdKategorija, HttpStatus.CREATED);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/kategorija/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Kategorija> updateKategorija(@PathVariable("id") String id, @RequestBody Kategorija kategorija) throws Exception{
        Kategorija kategorije = this.kategorijaService.findOne(id);

        if(kategorije == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Kategorija updateKategorija = this.kategorijaService.update(kategorija);
        if (updateKategorija == null) {
            return new ResponseEntity<Kategorija>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateKategorija, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/kategorija/{id}"
    )
    public ResponseEntity<Kategorija> deleteKategorija(@PathVariable("id") String id){
        this.kategorijaService.delete(id);
        return new ResponseEntity<Kategorija>(HttpStatus.NO_CONTENT);
    }
}

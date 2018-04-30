package xmlProjectSpringbootstarter.smestaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        List<Smestaj> bioskopi = this.smestajService.findAll();
        return new ResponseEntity<List<Smestaj>>(bioskopi, HttpStatus.OK);
    }
}

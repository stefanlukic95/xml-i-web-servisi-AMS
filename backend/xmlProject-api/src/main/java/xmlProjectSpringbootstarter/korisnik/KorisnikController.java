package xmlProjectSpringbootstarter.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user/{email}/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Korisnik> getKorisnik(@PathVariable("email") String email) {
        Korisnik korisnik = korisnikService.findByEmail(email);
        System.out.println(korisnik.getEmail());
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);

    }
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> registerKorisnik(@RequestBody Korisnik korisnik) {
        if (korisnikService.findByEmail(korisnik.getEmail()) == null) {
            List<String> uloge = new ArrayList<String>();
            uloge.add("ROLE_USER");
            korisnik.setUloge(uloge);
            Korisnik k = korisnikService.insert(korisnik);
            return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
        } else {
            return new ResponseEntity<Korisnik>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/korisnici",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Korisnik> insertKorisnik(@RequestBody Korisnik korisnik) throws Exception{
        Korisnik createdKorisnik  = this.korisnikService.create(korisnik);
        return new ResponseEntity<Korisnik>(createdKorisnik, HttpStatus.CREATED);
    }
}

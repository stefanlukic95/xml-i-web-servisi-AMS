package xmlProjectSpringbootstarter.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUsluga;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUslugaService;
import xmlProjectSpringbootstarter.drzava.Drzava;
import xmlProjectSpringbootstarter.drzava.DrzavaService;
import xmlProjectSpringbootstarter.kategorija.KategorijaService;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.korisnik.KorisnikService;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMesto;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMestoService;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;
import xmlProjectSpringbootstarter.rezervacija.RezervacijaService;
import xmlProjectSpringbootstarter.smestaj.Smestaj;
import xmlProjectSpringbootstarter.smestaj.SmestajService;
import xmlProjectSpringbootstarter.termin.Termin;
import xmlProjectSpringbootstarter.termin.TerminService;
import xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SmestajService smestajService;

    @Autowired
    private DrzavaService drzavaService;

    @Autowired
    private NaseljenoMestoService naseljenoMestoService;

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private TipsmestajaService tipsmestajaService;

    @Autowired
    private KategorijaService kategorijaService;

    @Autowired
    private DodatnaUslugaService dodatnaUslugaService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private TerminService terminService;

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(value = "/generate-token", method= RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );

        /*{
            List<Drzava> drzave = drzavaService.findAll();
            NaseljenoMesto nas = new NaseljenoMesto("Novi Sad","21000", drzave.get(0).getId());
            nas = naseljenoMestoService.insert(nas);
            NaseljenoMesto nas1 = new NaseljenoMesto("Beograd", "11000", drzave.get(0).getId());
            nas1 = naseljenoMestoService.insert(nas1);
            Rezervacija rez = new Rezervacija(LocalDate.of(2018,5,6), LocalDate.of(2018,5,26));
            rez = rezervacijaService.create(rez);
            List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
            rezervacije.add(rez);
            String agent = korisnikService.findByEmail("peric@gmail.com").getId();
            String tip_smestaja = tipsmestajaService.findOne("5b02e093b576a0187c8f25ce").getId();
            String kategorijaSmestaja = kategorijaService.findOne("5b02e46ab576a0187c8f25d1").getId();
            Termin termin = new Termin("Januar", 500);
            termin = terminService.create(termin);
            List<Termin> termini = new ArrayList<Termin>();
            termini.add(termin);
            DodatnaUsluga dod = new DodatnaUsluga("Klima");
            dod = dodatnaUslugaService.create(dod);
            List<DodatnaUsluga> dodatneUsluge = new ArrayList<DodatnaUsluga>();
            dodatneUsluge.add(dod);

            Smestaj smestaj = new Smestaj("Hotel Park", 4, nas.getId(),"Veoma lep hotel","", rezervacije, agent, tip_smestaja, kategorijaSmestaja, termini, dodatneUsluge);
            smestajService.create(smestaj);

        }*/

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final Korisnik user = korisnikService.findByEmail(loginUser.getUsername());
        if(user.isEnabled()) {
            final String token = jwtTokenUtil.generateToken(user);
            return ResponseEntity.ok(new AuthToken(token));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



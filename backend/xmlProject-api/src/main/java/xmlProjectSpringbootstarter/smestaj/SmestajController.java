package xmlProjectSpringbootstarter.smestaj;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xmlProjectSpringbootstarter.kategorija.Kategorija;
import xmlProjectSpringbootstarter.kategorija.KategorijaService;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.korisnik.KorisnikService;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMesto;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMestoOut;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMestoService;
import xmlProjectSpringbootstarter.tipsmestaja.Tipsmestaja;
import xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class SmestajController {

    @Autowired
    private SmestajService smestajService;

    @Autowired
    private NaseljenoMestoService naseljenoMestoService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private TipsmestajaService tipsmestajaService;

    @Autowired
    private KategorijaService kategorijaService;

    public SmestajController(SmestajService smestajService){
        this.smestajService = smestajService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/smestaj",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SmestajOut>> getAll() {
        List<Smestaj> smestaj = smestajService.findAll();
        List<SmestajOut> smestajOuts = new ArrayList<SmestajOut>();
        for(Smestaj s : smestaj) {
            NaseljenoMestoOut nas = naseljenoMestoService.findOne(s.getNaseljeno_mesto());
            Korisnik agent = korisnikService.findOne(s.getAgent());
            Tipsmestaja tip = tipsmestajaService.findOne(s.getTipSmestaja());
            Kategorija kategorija = kategorijaService.findOne(s.getKategorijaSmestaja());
            smestajOuts.add(
                    new SmestajOut(s.getId(),s.getNaziv(),s.getKapacitet(),nas,s.getOpis(),s.getSlika(),s.getRezervacije(),s.getZauzeto(),s.getKomentari(),agent,tip,kategorija,s.getTermini(),s.getDodatne_usluge())
            );
        }
        return new ResponseEntity<List<SmestajOut>>(smestajOuts, HttpStatus.OK);
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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/smestaj/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SmestajOut>> simpleSearch(@RequestParam Map<String, String> parameters) {
        String naziv = parameters.get("mesto");
        Integer kapacitet = Integer.parseInt(parameters.get("brOsoba"));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datumOd = null;
        Date datumDo = null;
        try {
            datumOd = format.parse(parameters.get("datumOd"));
            datumDo = format.parse(parameters.get("datumDo"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("DATUM OD::::" + datumOd);
        System.out.println("DATUM DO::::" + datumDo);

        List<SmestajOut> pronadjeniOut = new ArrayList<SmestajOut>();
        List<Smestaj> pronadjeni = new ArrayList<Smestaj>();
        List<NaseljenoMesto> mesta = naseljenoMestoService.search(naziv);

        for(NaseljenoMesto nas : mesta) {
            List<Smestaj> smestajMesto = smestajService.searchBynas(nas.getId());
            for(Smestaj s: smestajMesto) {
                if(s.getKapacitet() == kapacitet) {
                    boolean preklapanje = false;
                    for(Zauzetost z : s.getZauzeto()) {
                        if(z.getDat_pocetak().before(datumDo) && z.getDat_kraj().after(datumOd)) {
                            preklapanje = true;
                        }
                    }
                    if(!preklapanje) {
                        pronadjeni.add(s);
                    }
                }
            }
        }

        for(Smestaj s: pronadjeni) {
            NaseljenoMestoOut nas = naseljenoMestoService.findOne(s.getNaseljeno_mesto());
            Korisnik agent = korisnikService.findOne(s.getAgent());
            Tipsmestaja tip = tipsmestajaService.findOne(s.getTipSmestaja());
            Kategorija kategorija = kategorijaService.findOne(s.getKategorijaSmestaja());
            pronadjeniOut.add(
                    new SmestajOut(s.getId(),s.getNaziv(),s.getKapacitet(),nas,s.getOpis(),s.getSlika(),s.getRezervacije(),s.getZauzeto(),s.getKomentari(),agent,tip,kategorija,s.getTermini(),s.getDodatne_usluge())
            );
        }

        return new ResponseEntity<List<SmestajOut>>(pronadjeniOut,HttpStatus.OK);
    }

}

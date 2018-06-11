package xmlProjectSpringbootstarter.poruka;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.korisnik.KorisnikService;

import java.util.ArrayList;

@Service
public class PorukaServiceImpl implements PorukaService{

    @Autowired
    private PorukaRepository porukaRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public Poruka newPoruka(Poruka poruka) {

        Poruka por = porukaRepository.insert(poruka);
        Korisnik posaljilac = korisnikService.findOne(por.getPosaljilac());
        Korisnik primalac = korisnikService.findOne(por.getPrimalac());
        if(posaljilac.getPoruke()==null) {
            posaljilac.setPoruke(new ArrayList<Poruka>());
        }
        if(primalac.getPoruke()==null) {
            primalac.setPoruke(new ArrayList<Poruka>());
        }
        posaljilac.getPoruke().add(por);
        primalac.getPoruke().add(por);
        korisnikService.update(posaljilac);
        korisnikService.update(primalac);
        return por;
    }
}

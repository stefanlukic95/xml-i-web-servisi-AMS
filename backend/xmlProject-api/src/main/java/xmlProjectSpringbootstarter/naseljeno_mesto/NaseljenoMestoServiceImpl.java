package xmlProjectSpringbootstarter.naseljeno_mesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmlProjectSpringbootstarter.drzava.Drzava;
import xmlProjectSpringbootstarter.drzava.DrzavaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NaseljenoMestoServiceImpl implements NaseljenoMestoService {

    @Autowired
    private NaseljenoMestoRepository naseljenoMestoRepository;

    @Autowired
    private DrzavaService drzavaService;

    @Override
    public NaseljenoMestoOut findOne(String id) {
        NaseljenoMesto nas = naseljenoMestoRepository.findOne(id);
        Drzava drz = drzavaService.findOne(nas.getDrzava());
        NaseljenoMestoOut nasOut = new NaseljenoMestoOut(nas.getId(),nas.getNaziv(),nas.getPttBroj(),drz);
        return nasOut;
    }

    @Override
    public NaseljenoMesto insert(NaseljenoMesto nas) {
        return naseljenoMestoRepository.insert(nas);
    }

    @Override
    public List<NaseljenoMesto> search(String naziv) {
        List<NaseljenoMesto> mesta = naseljenoMestoRepository.findAll();
        List<NaseljenoMesto> pronadjeni = new ArrayList<NaseljenoMesto>();

        for(NaseljenoMesto nas : mesta) {
            if(nas.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
                pronadjeni.add(nas);
            }
        }

        return pronadjeni;
    }
}

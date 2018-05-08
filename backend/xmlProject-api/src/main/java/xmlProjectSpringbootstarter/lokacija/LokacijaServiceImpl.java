package xmlProjectSpringbootstarter.lokacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokacijaServiceImpl implements LokacijaService {

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Override
    public List<Lokacija> findAll(){
        List<Lokacija> lokacija = this.lokacijaRepository.findAll();
        return lokacija;
    }

    @Override
    public Lokacija findOne(String id){
        Lokacija lokacija = this.lokacijaRepository.findOne(id);
        return lokacija;
    }

    @Override
    public Lokacija create(Lokacija lokacija) throws Exception {
        Lokacija savedLokacija = this.lokacijaRepository.insert(lokacija);
        return savedLokacija;
    }

    @Override
    public Lokacija update(Lokacija lokacija) throws Exception {
        Lokacija lokacijaUpdt = this.lokacijaRepository.findOne(lokacija.getId());

        if(lokacijaUpdt == null){
            throw new Exception("Nije pronadjena lokacija.");
        }

        lokacijaUpdt.setAdresa(lokacija.getAdresa());
        lokacijaUpdt.setDrzava(lokacija.getDrzava());
        lokacijaUpdt.setGrad((lokacija.getGrad()));



        Lokacija updateLokacija = this.lokacijaRepository.save(lokacijaUpdt);
        return updateLokacija;
    }

    @Override
    public void delete(String id) {
        this.lokacijaRepository.delete(id);
    }
}

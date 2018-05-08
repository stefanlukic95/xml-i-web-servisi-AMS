package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {

    @Autowired
    private RezervacijaRepository rezervacijaRepository;


    @Override
    public List<Rezervacija> findAll(){
        List<Rezervacija> rezervacija = this.rezervacijaRepository.findAll();
        return rezervacija;
    }

    @Override
    public Rezervacija findOne(String id){
        Rezervacija rezervacija = this.rezervacijaRepository.findOne(id);
        return rezervacija;
    }

    @Override
    public Rezervacija create(Rezervacija rezervacija) throws Exception {
        Rezervacija savedRezervacija = this.rezervacijaRepository.insert(rezervacija);
        return savedRezervacija;
    }

    @Override
    public Rezervacija update(Rezervacija rezervacija) throws Exception {
        Rezervacija rezervacijaUpdt = this.rezervacijaRepository.findOne(rezervacija.getId());

        if(rezervacijaUpdt == null){
            throw new Exception("Nije pronadjena rezervacija.");
        }

        rezervacijaUpdt.setDatumDolaska(rezervacija.getDatumDolaska());
        rezervacijaUpdt.setDatumOdlaska(rezervacija.getDatumOdlaska());


        Rezervacija updateRezervacija = this.rezervacijaRepository.save(rezervacijaUpdt);
        return updateRezervacija;
    }

    @Override
    public void delete(String id) {
        this.rezervacijaRepository.delete(id);
    }
}

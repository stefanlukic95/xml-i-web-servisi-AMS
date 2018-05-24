package xmlProjectSpringbootstarter.smestaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmestajServiceImpl implements  SmestajService{

    @Autowired
    private SmestajRepository smestajRepository;


    @Override
    public List<Smestaj> findAll(){
        List<Smestaj> smestaj = this.smestajRepository.findAll();
        return smestaj;
    }

    @Override
    public Smestaj findOne(String id){
        Smestaj smestaj = this.smestajRepository.findOne(id);
        return smestaj;
    }

    @Override
    public Smestaj create(Smestaj smestaj) throws Exception {
        Smestaj savedSmestaj = this.smestajRepository.insert(smestaj);
        return savedSmestaj;
    }

    @Override
    public Smestaj update(Smestaj smestaj) throws Exception {
        Smestaj smestajUpdt = this.smestajRepository.findOne(smestaj.getId());

        if(smestajUpdt == null){
            throw new Exception("Nije pronadjen smestaj.");
        }

        smestajUpdt.setKapacitet(smestaj.getKapacitet());
        smestajUpdt.setOpis(smestaj.getOpis());
        smestajUpdt.setSlika((smestaj.getSlika()));

        Smestaj updateSmestaj = this.smestajRepository.save(smestajUpdt);
        return updateSmestaj;
    }

    @Override
    public void delete(String id) {
        this.smestajRepository.delete(id);
    }
}

package xmlProjectSpringbootstarter.termin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminServiceImpl implements TerminService{

    @Autowired
    private TerminRepository terminRepository;


    @Override
    public List<Termin> findAll(){
        List<Termin> termin = this.terminRepository.findAll();
        return termin;
    }

    @Override
    public Termin findOne(String id){
        Termin termin = this.terminRepository.findOne(id);
        return termin;
    }

    @Override
    public Termin create(Termin termin) throws Exception {
        Termin savedTermin = this.terminRepository.insert(termin);
        return savedTermin;
    }

    @Override
    public Termin update(Termin termin) throws Exception {
        Termin terminUpdt = this.terminRepository.findOne(termin.getId());

        if(terminUpdt == null){
            throw new Exception("Nije pronadjen termin.");
        }

        terminUpdt.setCena(termin.getCena());
        terminUpdt.setMesec(termin.getMesec());

        Termin updateTermin = this.terminRepository.save(terminUpdt);
        return updateTermin;
    }

    @Override
    public void delete(String id) {
        this.terminRepository.delete(id);
    }
}

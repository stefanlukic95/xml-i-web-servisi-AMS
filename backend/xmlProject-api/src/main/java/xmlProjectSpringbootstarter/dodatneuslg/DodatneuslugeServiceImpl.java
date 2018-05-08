package xmlProjectSpringbootstarter.dodatneuslg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DodatneuslugeServiceImpl implements DodatneuslugeService {

    @Autowired
    private DodatneuslugeRepository dodatneuslugeRepository;


    @Override
    public List<Dodatneusluge> findAll(){
        List<Dodatneusluge> dusluga = this.dodatneuslugeRepository.findAll();
        return dusluga;
    }

    @Override
    public Dodatneusluge findOne(String id){
        Dodatneusluge dusluga = this.dodatneuslugeRepository.findOne(id);
        return dusluga;
    }

    @Override
    public Dodatneusluge create(Dodatneusluge dusluga) throws Exception {
        Dodatneusluge savedDusluga = this.dodatneuslugeRepository.insert(dusluga);
        return savedDusluga;
    }

    @Override
    public Dodatneusluge update(Dodatneusluge dusluga) throws Exception {
        Dodatneusluge duslugaUpdt = this.dodatneuslugeRepository.findOne(dusluga.getId());

        if(duslugaUpdt == null){
            throw new Exception("Nije pronadjena dodatna usluga.");
        }

        duslugaUpdt.setNaziv(dusluga.getNaziv());

        Dodatneusluge updateDusluga = this.dodatneuslugeRepository.save(duslugaUpdt);
        return updateDusluga;
    }

    @Override
    public void delete(String id) {
        this.dodatneuslugeRepository.delete(id);
    }

}

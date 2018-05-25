package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DodatnaUslugaServiceImpl implements DodatnaUslugaService{

    @Autowired
    private DodatnaUslugaRepository dodatnaUslugaRepository;


    @Override
    public List<DodatnaUsluga> findAll(){
        List<DodatnaUsluga> dusluga = this.dodatnaUslugaRepository.findAll();
        return dusluga;
    }

    @Override
    public DodatnaUsluga findOne(String id){
        DodatnaUsluga dusluga = this.dodatnaUslugaRepository.findOne(id);
        return dusluga;
    }

    @Override
    public DodatnaUsluga create(DodatnaUsluga dusluga){
        DodatnaUsluga savedDusluga = this.dodatnaUslugaRepository.insert(dusluga);
        return savedDusluga;
    }

    @Override
    public DodatnaUsluga update(DodatnaUsluga dusluga){
        DodatnaUsluga duslugaUpdt = this.dodatnaUslugaRepository.findOne(dusluga.getId());


        duslugaUpdt.setNaziv(dusluga.getNaziv());




        DodatnaUsluga updateDusluga = this.dodatnaUslugaRepository.save(duslugaUpdt);
        return updateDusluga;
    }

    @Override
    public void delete(String id) {
        this.dodatnaUslugaRepository.delete(id);
    }


}

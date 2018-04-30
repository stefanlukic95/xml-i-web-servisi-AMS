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
}

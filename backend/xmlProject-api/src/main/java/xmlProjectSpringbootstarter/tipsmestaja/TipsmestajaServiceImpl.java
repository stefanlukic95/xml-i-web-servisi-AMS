package xmlProjectSpringbootstarter.tipsmestaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipsmestajaServiceImpl implements TipsmestajaService{

    @Autowired
    private TipsmestajaRepository tipsmestajaRepository;


    @Override
    public List<Tipsmestaja> findAll(){
        List<Tipsmestaja> tipsmestaja = this.tipsmestajaRepository.findAll();
        return tipsmestaja;
    }

    @Override
    public Tipsmestaja findOne(String id){
        Tipsmestaja tipsmestaja = this.tipsmestajaRepository.findOne(id);
        return tipsmestaja;
    }

    @Override
    public Tipsmestaja create(Tipsmestaja tipsmestaja) throws Exception {
        Tipsmestaja savedTip = this.tipsmestajaRepository.insert(tipsmestaja);
        return savedTip;
    }

    @Override
    public Tipsmestaja update(Tipsmestaja tipsmestaja) throws Exception {
        Tipsmestaja tipUpdt = this.tipsmestajaRepository.findOne(tipsmestaja.getId());

        if(tipUpdt == null){
            throw new Exception("Nije pronadjen tip smestaja.");
        }

        tipUpdt.setNaziv(tipsmestaja.getNaziv());



        Tipsmestaja updateTip = this.tipsmestajaRepository.save(tipUpdt);
        return updateTip;
    }

    @Override
    public void delete(String id) {
        this.tipsmestajaRepository.delete(id);
    }
}

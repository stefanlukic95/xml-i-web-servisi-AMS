package xmlProjectSpringbootstarter.komentari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomentariServiceImpl implements KomentariService{

    @Autowired
    private KomentariRepository komentariRepository;


    @Override
    public List<Komentari> findAll(){
        List<Komentari> komentar = this.komentariRepository.findAll();
        return komentar;
    }

    @Override
    public Komentari findOne(String id){
        Komentari komentar = this.komentariRepository.findOne(id);
        return komentar;
    }

    @Override
    public Komentari create(Komentari komentar) throws Exception {
        Komentari savedKomentar = this.komentariRepository.insert(komentar);
        return savedKomentar;
    }

    @Override
    public Komentari update(Komentari komentar) throws Exception {
        Komentari komentariUpdt = this.komentariRepository.findOne(komentar.getId());

        if(komentariUpdt == null){
            throw new Exception("Nije pronadjen komentar.");
        }

        if(komentariUpdt.isOdobren() == true) {
            komentariUpdt.setOdobren(false);
        }else if(komentariUpdt.isOdobren() == false){
            komentariUpdt.setOdobren(true);
        }

        Komentari updateKomentari = this.komentariRepository.save(komentariUpdt);
        return updateKomentari;
    }

    @Override
    public void delete(String id) {
        this.komentariRepository.delete(id);
    }
}

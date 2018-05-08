package xmlProjectSpringbootstarter.kategorija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaServiceImpl implements KategorijaService {

    @Autowired
    private KategorijaRepository kategorijaRepository;


    @Override
    public List<Kategorija> findAll(){
        List<Kategorija> kategorija = this.kategorijaRepository.findAll();
        return kategorija;
    }

    @Override
    public Kategorija findOne(String id){
        Kategorija kategorija = this.kategorijaRepository.findOne(id);
        return kategorija;
    }

    @Override
    public Kategorija create(Kategorija kategorija) throws Exception {
        Kategorija savedKategorija = this.kategorijaRepository.insert(kategorija);
        return savedKategorija;
    }

    @Override
    public Kategorija update(Kategorija kategorija) throws Exception {
        Kategorija kategorijaUpdt = this.kategorijaRepository.findOne(kategorija.getId());

        if(kategorijaUpdt == null){
            throw new Exception("Nije pronadjena kategorija.");
        }

        kategorijaUpdt.setNaziv(kategorija.getNaziv());




        Kategorija updateKategorija = this.kategorijaRepository.save(kategorijaUpdt);
        return updateKategorija;
    }

    @Override
    public void delete(String id) {
        this.kategorijaRepository.delete(id);
    }
}

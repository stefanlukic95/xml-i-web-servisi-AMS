package xmlProjectSpringbootstarter.kategorija;

import java.util.List;

public interface KategorijaService {
    List<Kategorija> findAll();
    Kategorija findOne(String id);
    Kategorija create(Kategorija kategorija) throws Exception;
    Kategorija update(Kategorija kategorija) throws Exception;
    void delete(String id);
}

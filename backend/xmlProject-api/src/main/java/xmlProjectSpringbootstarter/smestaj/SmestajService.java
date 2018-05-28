package xmlProjectSpringbootstarter.smestaj;

import java.util.List;

public interface SmestajService {
    List<Smestaj> findAll();
    Smestaj findOne(String id);
    Smestaj create(Smestaj smestaj);
    Smestaj update(Smestaj smestaj);
    List<Smestaj> searchBynas(String id);
    void delete(String id);

}

package xmlProjectSpringbootstarter.smestaj;

import java.util.List;

public interface SmestajService {
    List<Smestaj> findAll();
    Smestaj findOne(String id);
    Smestaj create(Smestaj smestaj) throws Exception;
    Smestaj update(Smestaj smestaj) throws Exception;
    void delete(String id);

}

package xmlProjectSpringbootstarter.drzava;

import java.util.List;

public interface DrzavaService {
    List<Drzava> findAll();
    Drzava findOne(String id);

}

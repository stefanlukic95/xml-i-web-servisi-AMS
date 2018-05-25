package xmlProjectSpringbootstarter.dodatnaUsluga;

import java.util.List;

public interface DodatnaUslugaService {

    List<DodatnaUsluga> findAll();
    DodatnaUsluga findOne(String id);
    DodatnaUsluga create(DodatnaUsluga dusluga) throws Exception;
    DodatnaUsluga update(DodatnaUsluga dusluga) throws Exception;
    void delete(String id);
}

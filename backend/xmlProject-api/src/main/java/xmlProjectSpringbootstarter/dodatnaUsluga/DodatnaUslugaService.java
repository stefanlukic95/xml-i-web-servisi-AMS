package xmlProjectSpringbootstarter.dodatnaUsluga;

import java.util.List;

public interface DodatnaUslugaService {

    List<DodatnaUsluga> findAll();
    DodatnaUsluga findOne(String id);
    DodatnaUsluga create(DodatnaUsluga dusluga);
    DodatnaUsluga update(DodatnaUsluga dusluga);
    void delete(String id);
}

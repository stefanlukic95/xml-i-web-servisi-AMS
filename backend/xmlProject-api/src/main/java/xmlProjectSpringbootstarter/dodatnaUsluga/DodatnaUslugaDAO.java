package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.stereotype.Repository;

@Repository
public class DodatnaUslugaDAO {

    public static DodatnaUsluga create(DodatnaUsluga dodatnaUsluga) {
        return dodatnaUsluga;
    }
}

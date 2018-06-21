package xmlProjectSpringbootstarter.drzava;

import org.springframework.stereotype.Repository;
import smestaj.Drzava;

@Repository
public class DrzavaDAO {

    public Drzava create(Drzava drz) {
        return drz;
    }
}

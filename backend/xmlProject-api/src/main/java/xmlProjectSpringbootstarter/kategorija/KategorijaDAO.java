package xmlProjectSpringbootstarter.kategorija;

import org.springframework.stereotype.Repository;

@Repository
public class KategorijaDAO {

    public static Kategorija create(Kategorija kategorija) {
        return kategorija;
    }
}

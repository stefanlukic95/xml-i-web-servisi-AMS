package xmlProjectSpringbootstarter.dodatneuslg;

import java.util.List;

public interface DodatneuslugeService {
    List<Dodatneusluge> findAll();
    Dodatneusluge findOne(String id);
    Dodatneusluge create(Dodatneusluge dusluga) throws Exception;
    Dodatneusluge update(Dodatneusluge dusluga) throws Exception;
    void delete(String id);

}

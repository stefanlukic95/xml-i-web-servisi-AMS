package xmlProjectSpringbootstarter.lokacija;


import java.util.List;

public interface LokacijaService {
    List<Lokacija> findAll();
    Lokacija findOne(String id);
    Lokacija create(Lokacija lokacija) throws Exception;
    Lokacija update(Lokacija lokacija) throws Exception;
    void delete(String id);
}

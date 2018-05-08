package xmlProjectSpringbootstarter.termin;

import java.util.List;

public interface TerminService {
    List<Termin> findAll();
    Termin findOne(String id);
    Termin create(Termin termin) throws Exception;
    Termin update(Termin termin) throws Exception;
    void delete(String id);
}

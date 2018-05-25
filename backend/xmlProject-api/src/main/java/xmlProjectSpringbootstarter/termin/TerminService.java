package xmlProjectSpringbootstarter.termin;

import java.util.List;

public interface TerminService {
    List<Termin> findAll();
    Termin findOne(String id);
    Termin create(Termin termin);
    Termin update(Termin termin);
    void delete(String id);
}

package xmlProjectSpringbootstarter.komentari;

import java.util.List;

public interface KomentariService {
    List<Komentari> findAll();
    Komentari findOne(String id);
    Komentari create(Komentari komentar) throws Exception;
    Komentari update(Komentari komentar) throws Exception;
    void delete(String id);
}

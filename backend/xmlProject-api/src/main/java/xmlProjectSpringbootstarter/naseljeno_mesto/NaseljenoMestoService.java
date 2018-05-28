package xmlProjectSpringbootstarter.naseljeno_mesto;

import java.util.List;

public interface NaseljenoMestoService {
    NaseljenoMestoOut findOne(String id);
    NaseljenoMesto insert(NaseljenoMesto nas);
    List<NaseljenoMesto> search(String naziv);
}

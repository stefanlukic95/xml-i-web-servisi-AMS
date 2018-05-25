package xmlProjectSpringbootstarter.naseljeno_mesto;

public interface NaseljenoMestoService {
    NaseljenoMestoOut findOne(String id);
    NaseljenoMesto insert(NaseljenoMesto nas);
}

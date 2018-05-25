package xmlProjectSpringbootstarter.naseljeno_mesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaseljenoMestoServiceImpl implements NaseljenoMestoService {

    @Autowired
    private NaseljenoMestoRepository naseljenoMestoRepository;

    @Override
    public NaseljenoMesto findOne(String id) {
        return naseljenoMestoRepository.findOne(id);
    }

    @Override
    public NaseljenoMesto insert(NaseljenoMesto nas) {
        return naseljenoMestoRepository.insert(nas);
    }
}

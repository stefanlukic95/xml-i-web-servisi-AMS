package xmlProjectSpringbootstarter.drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrzavaServiceImpl implements DrzavaService {
    @Autowired
    private DrzavaRepository drzavaRepository;

    @Override
    public List<Drzava> findAll() {
        return drzavaRepository.findAll();
    }

    @Override
    public Drzava findOne(String id) {
        return drzavaRepository.findOne(id);
    }
}

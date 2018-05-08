package xmlProjectSpringbootstarter.tipsmestaja;

import java.util.List;

public interface TipsmestajaService {
    List<Tipsmestaja> findAll();
    Tipsmestaja findOne(String id);
    Tipsmestaja create(Tipsmestaja tipsmestaja) throws Exception;
    Tipsmestaja update(Tipsmestaja tipsmestaja) throws Exception;
    void delete(String id);
}

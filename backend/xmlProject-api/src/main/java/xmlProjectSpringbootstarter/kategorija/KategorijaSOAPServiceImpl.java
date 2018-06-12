package xmlProjectSpringbootstarter.kategorija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="KategorijaService", endpointInterface="xmlProjectSpringbootstarter.kategorija.KategorijaSOAPService")
public class KategorijaSOAPServiceImpl implements KategorijaSOAPService {

    @Autowired
    KategorijaDAO kategorijaDAO;

    @Override
    public Kategorija create(Kategorija tipsmestaja) {
        Kategorija acc = KategorijaDAO.create(tipsmestaja);
        System.out.println("OK!");
        return acc;
    }
}

package xmlProjectSpringbootstarter.smestaj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="ZauzetostService", endpointInterface="xmlProjectSpringbootstarter.smestaj.ZauzetostSOAPService")
public class ZauzetostSOAPImpl implements ZauzetostSOAPService{

    @Autowired
    ZauzetostDAO zauzetostDAO;

    @Override
    public Zauzetost create(Zauzetost zauzetost) {
        Zauzetost acc = ZauzetostDAO.create(zauzetost);
        System.out.println("OK!");
        return acc;
    }
}

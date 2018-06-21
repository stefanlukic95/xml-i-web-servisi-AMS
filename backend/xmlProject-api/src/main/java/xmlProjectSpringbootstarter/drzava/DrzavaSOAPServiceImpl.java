package xmlProjectSpringbootstarter.drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smestaj.Drzava;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="DrzavaService", endpointInterface="xmlProjectSpringbootstarter.drzava.DrzavaSOAPService")
public class DrzavaSOAPServiceImpl implements DrzavaSOAPService {


    @Autowired
    DrzavaDAO drzavaDAO;

    @Override
    public Drzava create(Drzava drz) {
        Drzava acc = drzavaDAO.create(drz);
        System.out.println("OK!");
        return acc;
    }

    @Override
    public Drzava findOne(String id) {
        return null;
    }
}

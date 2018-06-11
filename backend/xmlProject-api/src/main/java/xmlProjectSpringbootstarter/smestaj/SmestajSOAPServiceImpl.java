package xmlProjectSpringbootstarter.smestaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="SmestajService", endpointInterface="xmlProjectSpringbootstarter.smestaj.SmestajSOAPService")
public class SmestajSOAPServiceImpl implements SmestajSOAPService {

    @Autowired
    SmestajDAO smestajDAO;

    @Override
    public Smestaj create(Smestaj smestaj) {
        Smestaj acc = smestajDAO.create(smestaj);
        System.out.println("OK!");
        return acc;
    }
}

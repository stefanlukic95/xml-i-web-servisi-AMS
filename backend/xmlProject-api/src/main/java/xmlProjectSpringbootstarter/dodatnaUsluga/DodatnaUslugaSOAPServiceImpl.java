package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="DodatnaUslugaService", endpointInterface="xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUslugaSOAPService")
public class DodatnaUslugaSOAPServiceImpl implements DodatnaUslugaSOAPService{

    @Autowired
    DodatnaUslugaDAO dodatnaUslugaDAO;

    @Override
    public DodatnaUsluga create(DodatnaUsluga dodatnaUsluga) {
        DodatnaUsluga acc = DodatnaUslugaDAO.create(dodatnaUsluga);
        System.out.println("OK!");
        return acc;
    }

}

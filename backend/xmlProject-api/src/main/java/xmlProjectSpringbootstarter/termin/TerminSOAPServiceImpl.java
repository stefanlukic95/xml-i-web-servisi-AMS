package xmlProjectSpringbootstarter.termin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="TerminService", endpointInterface="xmlProjectSpringbootstarter.termin.TerminSOAPService")
public class TerminSOAPServiceImpl implements TerminSOAPService {

    @Autowired
    TerminDAO terminDAO;

    @Override
    public Termin create(Termin termin) {
        Termin acc = TerminDAO.create(termin);
        System.out.println("OK!");
        return acc;
    }
}

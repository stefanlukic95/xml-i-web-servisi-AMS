package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="RezervacijaService", endpointInterface="xmlProjectSpringbootstarter.rezervacija.RezervacijaSOAPService")
public class RezervacijaSOAPServiceImpl implements RezervacijaSOAPService{

    @Autowired
    RezervacijaDAO rezervacijaDAO;

    @Override
    public Rezervacija create(Rezervacija rezervacija) {
        Rezervacija acc = RezervacijaDAO.create(rezervacija);
        System.out.println("OK!");
        return acc;
    }
}

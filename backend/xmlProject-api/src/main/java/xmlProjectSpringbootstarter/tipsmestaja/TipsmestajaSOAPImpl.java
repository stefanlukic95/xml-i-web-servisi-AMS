package xmlProjectSpringbootstarter.tipsmestaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService (targetNamespace="http://xmlProjectSpringbootstarter/", serviceName="TipsmestajaService", endpointInterface="xmlProjectSpringbootstarter.tipsmestaja.TipsmestajaSOAPService")
public class TipsmestajaSOAPImpl implements TipsmestajaSOAPService{

    @Autowired
    TipsmestajaDAO tipsmestajaDAO;

    @Override
    public Tipsmestaja create(Tipsmestaja tipsmestaja) {
        Tipsmestaja acc = TipsmestajaDAO.create(tipsmestaja);
        System.out.println("OK!");
        return acc;
    }
}

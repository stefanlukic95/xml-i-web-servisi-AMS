package xmlProjectSpringbootstarter.tipsmestaja;


import javax.jws.WebService;

@WebService
public interface TipsmestajaSOAPService {

    Tipsmestaja create(Tipsmestaja tipsmestaja);
}

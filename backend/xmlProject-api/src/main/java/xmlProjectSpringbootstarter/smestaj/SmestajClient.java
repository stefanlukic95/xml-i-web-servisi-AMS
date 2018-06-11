package xmlProjectSpringbootstarter.smestaj;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class SmestajClient {
    public static void main(String[] args) {
        try

        {
            URL url = new URL("http://localhost:8080/soap-api/smestajSOAPService?wsdl");  // gadjamo spring boot aplikaciju iza čije adrese navodimo putanju do cxf servleta (cxf.path definisan u application.properties) i putanju na kojoj je publish-ovan endpoint (definisano u WebServiceConfig)
            QName qname = new QName("http://xmlProjectSpringbootstarter/", "smestajSOAPService");  // pozivamo servis na osnovu prostora imena i naziva samog servisa
            Service service = Service.create(url, qname);
            SmestajSOAPService smestajSOAPService = service.getPort(SmestajSOAPService.class);
            Smestaj testObj = new Smestaj();
            smestajSOAPService.create(testObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

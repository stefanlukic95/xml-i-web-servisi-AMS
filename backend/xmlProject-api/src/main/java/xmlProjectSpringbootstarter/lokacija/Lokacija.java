package xmlProjectSpringbootstarter.lokacija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Lokacija")
public class Lokacija {

    @Id
    private String id;
    private String drzava;
    private String grad;
    private String adresa;

    public  Lokacija(){

    }

    public Lokacija(String id, String drzava, String grad, String adresa) {
        this.id = id;
        this.drzava = drzava;
        this.grad = grad;
        this.adresa = adresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}

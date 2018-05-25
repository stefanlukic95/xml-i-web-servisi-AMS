package xmlProjectSpringbootstarter.kategorija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Kategorija")
public class Kategorija {

    @Id
    private String id;
    private String naziv;


    public Kategorija(){

    }

    public Kategorija(String naziv) {
        this.naziv = naziv;
    }

    public String getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

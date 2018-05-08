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

    public Kategorija(String id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

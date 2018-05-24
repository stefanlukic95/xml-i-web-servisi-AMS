package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dodatne usluge")
public class DodatnaUsluga {
    @Id
    private String id;
    private String naziv;

    public DodatnaUsluga(String naziv) {
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

package xmlProjectSpringbootstarter.ocena;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Ocena")
public class Ocena {

    @Id
    private String id;
    private Integer ocena;
    private String smestaj;
    private List<String> korisnici;

    public Ocena(Integer ocena, List<String> korisnici) {
        this.ocena = ocena;
        this.korisnici = korisnici;
    }

    public Ocena() {

    }

    public String getId() {
        return id;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public List<String> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<String> korisnici) {
        this.korisnici = korisnici;
    }
}

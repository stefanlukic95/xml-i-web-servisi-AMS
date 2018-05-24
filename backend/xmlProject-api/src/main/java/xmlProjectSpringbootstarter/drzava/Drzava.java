package xmlProjectSpringbootstarter.drzava;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Drzave")
public class Drzava {
    @Id
    private String id;
    private String naziv;
    private String sifra;

    public Drzava() {

    }

    public String getId() {
        return id;
    }

    public Drzava(String naziv, String sifra) {
        this.naziv = naziv;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

package xmlProjectSpringbootstarter.naseljeno_mesto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xmlProjectSpringbootstarter.drzava.Drzava;

@Document(collection = "Naseljena mesta")
public class NaseljenoMesto {

    @Id
    private String id;
    private String naziv;
    private String pttBroj;
    private String drzava;

    public NaseljenoMesto() {

    }

    public NaseljenoMesto(String naziv, String pttBroj, String drzava) {
        this.naziv = naziv;
        this.pttBroj = pttBroj;
        this.drzava = drzava;
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

    public String getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(String pttBroj) {
        this.pttBroj = pttBroj;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}

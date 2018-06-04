package xmlProjectSpringbootstarter.komentari;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Komentari")
public class Komentari {

    @Id
    private String id;
    private String sadrzaj;
    private String ime;
    private boolean odobren;

    public Komentari(){

    }

    public Komentari(String sadrzaj, String ime, boolean odobren) {
        this.sadrzaj = sadrzaj;
        this.ime = ime;
        this.odobren = odobren;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}

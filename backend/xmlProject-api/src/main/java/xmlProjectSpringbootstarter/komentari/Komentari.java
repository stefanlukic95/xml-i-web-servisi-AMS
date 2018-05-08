package xmlProjectSpringbootstarter.komentari;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Komentari")
public class Komentari {

    @Id
    private String id;
    private String sadrzaj;


    public Komentari(){

    }

    public Komentari(String id, String sadrzaj) {
        this.id = id;
        this.sadrzaj = sadrzaj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}

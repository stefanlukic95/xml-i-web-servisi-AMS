package xmlProjectSpringbootstarter.termin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Termin")
public class Termin {
    @Id
    private String id;
    private String mesec;
    private int cena;

    public Termin(){

    }

    public Termin(String id, String mesec, int cena) {
        this.id = id;
        this.mesec = mesec;
        this.cena = cena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}


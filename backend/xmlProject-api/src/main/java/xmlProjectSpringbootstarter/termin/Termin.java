package xmlProjectSpringbootstarter.termin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Termin")
public class Termin {
    @Id
    private String id;
    private Integer mesec;
    private int cena;

    public Termin(){

    }

    public Termin( Integer mesec, int cena) {
        this.mesec = mesec;
        this.cena = cena;
    }

    public String getId() {
        return id;
    }

    public Integer getMesec() {
        return mesec;
    }

    public void setMesec(Integer mesec) {
        this.mesec = mesec;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

}


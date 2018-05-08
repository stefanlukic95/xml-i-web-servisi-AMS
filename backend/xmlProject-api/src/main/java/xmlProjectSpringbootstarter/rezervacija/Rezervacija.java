package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collection = "Rezervacija")
public class Rezervacija {

    @Id
    private String id;
    private Date datumDolaska;
    private Date datumOdlaska;

    public Rezervacija(){

    }

    public Rezervacija(String id, Date datumDolaska, Date datumOdlaska) {
        this.id = id;
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public Date getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(Date datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }
}

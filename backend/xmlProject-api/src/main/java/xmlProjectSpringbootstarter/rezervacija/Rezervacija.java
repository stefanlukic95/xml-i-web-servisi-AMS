package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xmlProjectSpringbootstarter.korisnik.Korisnik;

import java.time.LocalDate;
import java.util.Date;

@Document (collection = "Rezervacija")
public class Rezervacija {

    @Id
    private String id;
    private LocalDate datumDolaska;
    private LocalDate datumOdlaska;

    public Rezervacija(){

    }

    public Rezervacija(LocalDate datumDolaska, LocalDate datumOdlaska) {
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
    }


    public String getId() {
        return id;
    }

    public LocalDate getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(LocalDate datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public LocalDate getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(LocalDate datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }
}

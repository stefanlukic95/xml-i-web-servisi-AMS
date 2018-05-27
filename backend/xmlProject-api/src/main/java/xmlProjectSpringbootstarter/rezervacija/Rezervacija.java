package xmlProjectSpringbootstarter.rezervacija;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document (collection = "Rezervacija")
public class Rezervacija {

    @Id
    private String id;
    private LocalDate datumDolaska;
    private LocalDate datumOdlaska;
    private Integer cena;

    public Rezervacija(){

    }

    public Rezervacija(LocalDate datumDolaska, LocalDate datumOdlaska, Integer cena) {
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
        this.cena = cena;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
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

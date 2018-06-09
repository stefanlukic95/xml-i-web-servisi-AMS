package xmlProjectSpringbootstarter.rezervacija;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xmlProjectSpringbootstarter.korisnik.Korisnik;

import java.util.Date;

@Document (collection = "Rezervacija")
public class Rezervacija {

    @Id
    private String id;
    private Date datumDolaska;
    private Date datumOdlaska;
    private String smestajNaziv;
    @JsonIgnore
    private String smestajId;
    @JsonIgnore
    private String korisnikId;
    private Korisnik agent;
    private boolean izvrsena;
    private Integer cena;


    public Rezervacija() {

    }

    public Rezervacija(Date datumDolaska, Date datumOdlaska, String smestajNaziv, String smestajId, String korisnikId, Korisnik agent, boolean izvrsena, Integer cena) {
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
        this.smestajNaziv = smestajNaziv;
        this.smestajId = smestajId;
        this.korisnikId = korisnikId;
        this.agent = agent;
        this.izvrsena = izvrsena;
        this.cena = cena;
    }

    public Korisnik getAgent() {
        return agent;
    }

    public void setAgent(Korisnik agent) {
        this.agent = agent;
    }

    public String getSmestajId() {
        return smestajId;
    }

    public void setSmestajId(String smestajId) {
        this.smestajId = smestajId;
    }

    public String getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(String korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getSmestajNaziv() {
        return smestajNaziv;
    }

    public void setSmestajNaziv(String smestajNaziv) {
        this.smestajNaziv = smestajNaziv;
    }

    public boolean isIzvrsena() {
        return izvrsena;
    }

    public void setIzvrsena(boolean izvrsena) {
        this.izvrsena = izvrsena;
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

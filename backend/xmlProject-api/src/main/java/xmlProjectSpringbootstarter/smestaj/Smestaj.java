package xmlProjectSpringbootstarter.smestaj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUsluga;
import xmlProjectSpringbootstarter.komentari.Komentari;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;
import xmlProjectSpringbootstarter.termin.Termin;

import java.util.List;

@Document(collection = "Smestaj")
public class Smestaj {

    @Id
    private String id;
    private String naziv;
    private Integer kapacitet;
    private String naseljeno_mesto; // referenca na naseljeno mesto u kom se nalazi
    private String opis;
    private List<String> slike;
    private List<Rezervacija> rezervacije;
    private List<Zauzetost> zauzeto;
    private List<Komentari> komentari;
    private String agent; //referenca na agenta koji je vlasnik smestaja
    private String tipSmestaja; //referenca na tip smestaja
    private String kategorijaSmestaja; //referenca na kategoriju smestaja
    private List<Termin> termini;
    private List<DodatnaUsluga> dodatne_usluge;

    public Smestaj(String naziv, Integer kapacitet, String naseljeno_mesto, String opis, List<String> slike, List<Rezervacija> rezervacije, List<Zauzetost> zauzeto, List<Komentari> komentari, String agent, String tipSmestaja, String kategorijaSmestaja, List<Termin> termini, List<DodatnaUsluga> dodatne_usluge) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.naseljeno_mesto = naseljeno_mesto;
        this.opis = opis;
        this.slike = slike;
        this.rezervacije = rezervacije;
        this.zauzeto = zauzeto;
        this.komentari = komentari;
        this.agent = agent;
        this.tipSmestaja = tipSmestaja;
        this.kategorijaSmestaja = kategorijaSmestaja;
        this.termini = termini;
        this.dodatne_usluge = dodatne_usluge;
    }

    public List<Zauzetost> getZauzeto() {
        return zauzeto;
    }

    public List<Komentari> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Komentari> komentari) {
        this.komentari = komentari;
    }

    public void setZauzeto(List<Zauzetost> zauzeto) {
        this.zauzeto = zauzeto;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    public List<DodatnaUsluga> getDodatne_usluge() {
        return dodatne_usluge;
    }

    public void setDodatne_usluge(List<DodatnaUsluga> dodatne_usluge) {
        this.dodatne_usluge = dodatne_usluge;
    }

    public String getId() {
        return id;
    }

    public String getTipSmestaja() {
        return tipSmestaja;
    }

    public void setTipSmestaja(String tipSmestaja) {
        this.tipSmestaja = tipSmestaja;
    }

    public String getKategorijaSmestaja() {
        return kategorijaSmestaja;
    }

    public void setKategorijaSmestaja(String kategorijaSmestaja) {
        this.kategorijaSmestaja = kategorijaSmestaja;
    }

    public Smestaj(){

    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public String getNaseljeno_mesto() {
        return naseljeno_mesto;
    }

    public void setNaseljeno_mesto(String naseljeno_mesto) {
        this.naseljeno_mesto = naseljeno_mesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<String> getSlike() {
        return slike;
    }

    public void setSlike(List<String> slike) {
        this.slike = slike;
    }
}


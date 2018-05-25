package xmlProjectSpringbootstarter.smestaj;

import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUsluga;
import xmlProjectSpringbootstarter.kategorija.Kategorija;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMesto;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;
import xmlProjectSpringbootstarter.termin.Termin;
import xmlProjectSpringbootstarter.tipsmestaja.Tipsmestaja;

import java.util.List;

public class SmestajOut {

    private String id;
    private String naziv;
    private Integer kapacitet;
    private NaseljenoMesto naseljeno_mesto;
    private String opis;
    private String slika;
    private List<Rezervacija> rezervacije;
    private Korisnik agent;
    private Tipsmestaja tipSmestaja;
    private Kategorija kategorijaSmestaja;
    private List<Termin> termini;
    private List<DodatnaUsluga> dodatne_usluge;

    public SmestajOut(String id, String naziv, Integer kapacitet, NaseljenoMesto naseljeno_mesto, String opis, String slika, List<Rezervacija> rezervacije, Korisnik agent, Tipsmestaja tipSmestaja, Kategorija kategorijaSmestaja, List<Termin> termini, List<DodatnaUsluga> dodatne_usluge) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.naseljeno_mesto = naseljeno_mesto;
        this.opis = opis;
        this.slika = slika;
        this.rezervacije = rezervacije;
        this.agent = agent;
        this.tipSmestaja = tipSmestaja;
        this.kategorijaSmestaja = kategorijaSmestaja;
        this.termini = termini;
        this.dodatne_usluge = dodatne_usluge;
    }

    public SmestajOut() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public NaseljenoMesto getNaseljeno_mesto() {
        return naseljeno_mesto;
    }

    public void setNaseljeno_mesto(NaseljenoMesto naseljeno_mesto) {
        this.naseljeno_mesto = naseljeno_mesto;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Korisnik getAgent() {
        return agent;
    }

    public void setAgent(Korisnik agent) {
        this.agent = agent;
    }

    public Tipsmestaja getTipSmestaja() {
        return tipSmestaja;
    }

    public void setTipSmestaja(Tipsmestaja tipSmestaja) {
        this.tipSmestaja = tipSmestaja;
    }

    public Kategorija getKategorijaSmestaja() {
        return kategorijaSmestaja;
    }

    public void setKategorijaSmestaja(Kategorija kategorijaSmestaja) {
        this.kategorijaSmestaja = kategorijaSmestaja;
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
}

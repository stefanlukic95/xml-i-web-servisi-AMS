package xmlProjectSpringbootstarter.smestaj;

import xmlProjectSpringbootstarter.dodatnaUsluga.DodatnaUsluga;
import xmlProjectSpringbootstarter.kategorija.Kategorija;
import xmlProjectSpringbootstarter.komentari.Komentari;
import xmlProjectSpringbootstarter.korisnik.Korisnik;
import xmlProjectSpringbootstarter.naseljeno_mesto.NaseljenoMestoOut;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;
import xmlProjectSpringbootstarter.termin.Termin;
import xmlProjectSpringbootstarter.tipsmestaja.Tipsmestaja;

import java.util.List;

public class SmestajOut {

    private String id;
    private String naziv;
    private Integer kapacitet;
    private NaseljenoMestoOut naseljeno_mesto;
    private String opis;
    private List<String> slike;
    private List<Rezervacija> rezervacije;
    private List<Zauzetost> zauzeto;
    private List<Komentari> komentari;
    private Korisnik agent;
    private Tipsmestaja tipSmestaja;
    private Kategorija kategorijaSmestaja;
    private List<Termin> termini;
    private List<DodatnaUsluga> dodatne_usluge;

    public SmestajOut(String id, String naziv, Integer kapacitet, NaseljenoMestoOut naseljeno_mesto, String opis, List<String> slike, List<Rezervacija> rezervacije, List<Zauzetost> zauzeto, List<Komentari> komentari, Korisnik agent, Tipsmestaja tipSmestaja, Kategorija kategorijaSmestaja, List<Termin> termini, List<DodatnaUsluga> dodatne_usluge) {
        this.id = id;
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

    public List<Komentari> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Komentari> komentari) {
        this.komentari = komentari;
    }

    public SmestajOut() {

    }

    public List<Zauzetost> getZauzeto() {
        return zauzeto;
    }

    public void setZauzeto(List<Zauzetost> zauzeto) {
        this.zauzeto = zauzeto;
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

    public NaseljenoMestoOut getNaseljeno_mesto() {
        return naseljeno_mesto;
    }

    public void setNaseljeno_mesto(NaseljenoMestoOut naseljeno_mesto) {
        this.naseljeno_mesto = naseljeno_mesto;
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

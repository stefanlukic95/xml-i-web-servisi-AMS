package xmlProjectSpringbootstarter.korisnik;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xmlProjectSpringbootstarter.poruka.Poruka;
import xmlProjectSpringbootstarter.rezervacija.Rezervacija;

import java.util.List;

@Document(collection = "Korisnici")
public class Korisnik {

    @Id
    private String id;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String brtel;
    private String adresa;
    private String pmb;
    private List<Rezervacija> rezervacije;
    private List<Poruka> primljene_poruke;
    private List<Poruka> poslate_poruke;

    @JsonIgnore
    private boolean enabled;
    @JsonIgnore
    private List<String> uloge;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String email, String password, String brtel, String adresa, String pmb, List<Rezervacija> rezervacije, List<Poruka> primljene_poruke, List<Poruka> poslate_poruke, boolean enabled, List<String> uloge) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.brtel = brtel;
        this.adresa = adresa;
        this.pmb = pmb;
        this.rezervacije = rezervacije;
        this.primljene_poruke = primljene_poruke;
        this.poslate_poruke = poslate_poruke;
        this.enabled = enabled;
        this.uloge = uloge;
    }

    public List<Poruka> getPrimljene_poruke() {
        return primljene_poruke;
    }

    public void setPrimljene_poruke(List<Poruka> primljene_poruke) {
        this.primljene_poruke = primljene_poruke;
    }

    public List<Poruka> getPoslate_poruke() {
        return poslate_poruke;
    }

    public void setPoslate_poruke(List<Poruka> poslate_poruke) {
        this.poslate_poruke = poslate_poruke;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrtel() {
        return brtel;
    }

    public void setBrtel(String brtel) {
        this.brtel = brtel;
    }

    public String getPmb() {
        return pmb;
    }

    public void setPmb(String pmb) {
        this.pmb = pmb;
    }

    public List<String> getUloge() {
        return uloge;
    }

    public void setUloge(List<String> uloge) {
        this.uloge = uloge;
    }
}

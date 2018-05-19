package xmlProjectSpringbootstarter.korisnik;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Korisnici")
public class Korisnik {

    @Id
    private String id;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String br_tel;
    private String pmb;
    @JsonIgnore
    private boolean enabled;
    @JsonIgnore
    private List<String> uloge;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String email, String password, String br_tel, String pmb, boolean enabled, List<String> uloge) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.br_tel = br_tel;
        this.pmb = pmb;
        this.enabled = enabled;
        this.uloge = uloge;
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

    public String getBr_tel() {
        return br_tel;
    }

    public void setBr_tel(String br_tel) {
        this.br_tel = br_tel;
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

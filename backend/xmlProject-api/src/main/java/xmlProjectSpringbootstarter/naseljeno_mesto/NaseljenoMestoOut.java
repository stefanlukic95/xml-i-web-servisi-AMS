package xmlProjectSpringbootstarter.naseljeno_mesto;

import xmlProjectSpringbootstarter.drzava.Drzava;

public class NaseljenoMestoOut {

    private String id;
    private String naziv;
    private String pttBroj;
    private Drzava drzava;

    public NaseljenoMestoOut(String id, String naziv, String pttBroj, Drzava drzava) {
        this.id = id;
        this.naziv = naziv;
        this.pttBroj = pttBroj;
        this.drzava = drzava;
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

    public String getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(String pttBroj) {
        this.pttBroj = pttBroj;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }
}

package xmlProjectSpringbootstarter.smestaj;


import java.time.LocalDate;

public class Zauzetost {
    private LocalDate dat_pocetak;
    private LocalDate dat_kraj;

    public Zauzetost(LocalDate dat_pocetak, LocalDate dat_kraj) {
        this.dat_pocetak = dat_pocetak;
        this.dat_kraj = dat_kraj;
    }

    public Zauzetost() {

    }

    public LocalDate getDat_pocetak() {
        return dat_pocetak;
    }

    public void setDat_pocetak(LocalDate dat_pocetak) {
        this.dat_pocetak = dat_pocetak;
    }

    public LocalDate getDat_kraj() {
        return dat_kraj;
    }

    public void setDat_kraj(LocalDate dat_kraj) {
        this.dat_kraj = dat_kraj;
    }
}

package xmlProjectSpringbootstarter.smestaj;


import java.time.LocalDate;
import java.util.Date;

public class Zauzetost {
    private Date dat_pocetak;
    private Date dat_kraj;

    public Zauzetost(Date dat_pocetak, Date dat_kraj) {
        this.dat_pocetak = dat_pocetak;
        this.dat_kraj = dat_kraj;
    }

    public Date getDat_pocetak() {
        return dat_pocetak;
    }

    public void setDat_pocetak(Date dat_pocetak) {
        this.dat_pocetak = dat_pocetak;
    }

    public Date getDat_kraj() {
        return dat_kraj;
    }

    public void setDat_kraj(Date dat_kraj) {
        this.dat_kraj = dat_kraj;
    }
}

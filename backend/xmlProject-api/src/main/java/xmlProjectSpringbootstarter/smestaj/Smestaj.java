package xmlProjectSpringbootstarter.smestaj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Smestaj")
public class Smestaj {


    @Id
    private String id;
    private int kapacitet;
    private String opis;
    private String slika;

    public Smestaj(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
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



    public Smestaj(String id, int kapacitet, String opis, String slika) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.opis = opis;
        this.slika = slika;
    }


}


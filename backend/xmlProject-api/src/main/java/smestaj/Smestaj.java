//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.20 at 02:09:58 PM CEST 
//


package smestaj;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kapacitet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naseljeno_mesto" type="{smestaj}naseljeno_mesto"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slike" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="rezervacije" type="{smestaj}rezervacija" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="zauzeto" type="{smestaj}zauzetost" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="komentari" type="{smestaj}komentar" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="agent" type="{smestaj}radnik"/>
 *         &lt;element name="tip_smestaja" type="{smestaj}tip_smestaja"/>
 *         &lt;element name="kategorija_smestaja" type="{smestaj}kategorija"/>
 *         &lt;element name="termini" type="{smestaj}termin" maxOccurs="12" minOccurs="12"/>
 *         &lt;element name="dodtane_usluge" type="{smestaj}dodatna_usluga" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestaj", propOrder = {
    "id",
    "naziv",
    "kapacitet",
    "naseljenoMesto",
    "opis",
    "slike",
    "rezervacije",
    "zauzeto",
    "komentari",
    "agent",
    "tipSmestaja",
    "kategorijaSmestaja",
    "termini",
    "dodtaneUsluge"
})
public class Smestaj {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String naziv;
    protected int kapacitet;
    @XmlElement(name = "naseljeno_mesto", required = true)
    protected NaseljenoMesto naseljenoMesto;
    @XmlElement(required = true)
    protected String opis;
    @XmlElement(required = true)
    protected List<String> slike;
    protected List<Rezervacija> rezervacije;
    protected List<Zauzetost> zauzeto;
    protected List<Komentar> komentari;
    @XmlElement(required = true)
    protected Radnik agent;
    @XmlElement(name = "tip_smestaja", required = true)
    protected TipSmestaja tipSmestaja;
    @XmlElement(name = "kategorija_smestaja", required = true)
    protected Kategorija kategorijaSmestaja;
    @XmlElement(required = true)
    protected List<Termin> termini;
    @XmlElement(name = "dodtane_usluge")
    protected List<DodatnaUsluga> dodtaneUsluge;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the kapacitet property.
     * 
     */
    public int getKapacitet() {
        return kapacitet;
    }

    /**
     * Sets the value of the kapacitet property.
     * 
     */
    public void setKapacitet(int value) {
        this.kapacitet = value;
    }

    /**
     * Gets the value of the naseljenoMesto property.
     * 
     * @return
     *     possible object is
     *     {@link NaseljenoMesto }
     *     
     */
    public NaseljenoMesto getNaseljenoMesto() {
        return naseljenoMesto;
    }

    /**
     * Sets the value of the naseljenoMesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaseljenoMesto }
     *     
     */
    public void setNaseljenoMesto(NaseljenoMesto value) {
        this.naseljenoMesto = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the slike property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slike property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlike().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSlike() {
        if (slike == null) {
            slike = new ArrayList<String>();
        }
        return this.slike;
    }

    /**
     * Gets the value of the rezervacije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rezervacije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRezervacije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rezervacija }
     * 
     * 
     */
    public List<Rezervacija> getRezervacije() {
        if (rezervacije == null) {
            rezervacije = new ArrayList<Rezervacija>();
        }
        return this.rezervacije;
    }

    /**
     * Gets the value of the zauzeto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zauzeto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZauzeto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zauzetost }
     * 
     * 
     */
    public List<Zauzetost> getZauzeto() {
        if (zauzeto == null) {
            zauzeto = new ArrayList<Zauzetost>();
        }
        return this.zauzeto;
    }

    /**
     * Gets the value of the komentari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the komentari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKomentari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Komentar }
     * 
     * 
     */
    public List<Komentar> getKomentari() {
        if (komentari == null) {
            komentari = new ArrayList<Komentar>();
        }
        return this.komentari;
    }

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Radnik }
     *     
     */
    public Radnik getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Radnik }
     *     
     */
    public void setAgent(Radnik value) {
        this.agent = value;
    }

    /**
     * Gets the value of the tipSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link TipSmestaja }
     *     
     */
    public TipSmestaja getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipSmestaja }
     *     
     */
    public void setTipSmestaja(TipSmestaja value) {
        this.tipSmestaja = value;
    }

    /**
     * Gets the value of the kategorijaSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link Kategorija }
     *     
     */
    public Kategorija getKategorijaSmestaja() {
        return kategorijaSmestaja;
    }

    /**
     * Sets the value of the kategorijaSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kategorija }
     *     
     */
    public void setKategorijaSmestaja(Kategorija value) {
        this.kategorijaSmestaja = value;
    }

    /**
     * Gets the value of the termini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Termin }
     * 
     * 
     */
    public List<Termin> getTermini() {
        if (termini == null) {
            termini = new ArrayList<Termin>();
        }
        return this.termini;
    }

    /**
     * Gets the value of the dodtaneUsluge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dodtaneUsluge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDodtaneUsluge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DodatnaUsluga }
     * 
     * 
     */
    public List<DodatnaUsluga> getDodtaneUsluge() {
        if (dodtaneUsluge == null) {
            dodtaneUsluge = new ArrayList<DodatnaUsluga>();
        }
        return this.dodtaneUsluge;
    }

}

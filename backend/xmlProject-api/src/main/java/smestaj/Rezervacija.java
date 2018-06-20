//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.20 at 02:09:58 PM CEST 
//


package smestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rezervacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum_dolaska" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum_odlaska" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="naziv_smestaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id_smestaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id_korisnika" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="agent" type="{smestaj}radnik"/>
 *         &lt;element name="izvrseno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacija", propOrder = {
    "id",
    "datumDolaska",
    "datumOdlaska",
    "nazivSmestaja",
    "idSmestaja",
    "idKorisnika",
    "agent",
    "izvrseno",
    "cena"
})
public class Rezervacija {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(name = "datum_dolaska", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDolaska;
    @XmlElement(name = "datum_odlaska", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOdlaska;
    @XmlElement(name = "naziv_smestaja", required = true)
    protected String nazivSmestaja;
    @XmlElement(name = "id_smestaja", required = true)
    protected String idSmestaja;
    @XmlElement(name = "id_korisnika", required = true)
    protected String idKorisnika;
    @XmlElement(required = true)
    protected Radnik agent;
    protected boolean izvrseno;
    protected int cena;

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
     * Gets the value of the datumDolaska property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDolaska() {
        return datumDolaska;
    }

    /**
     * Sets the value of the datumDolaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDolaska(XMLGregorianCalendar value) {
        this.datumDolaska = value;
    }

    /**
     * Gets the value of the datumOdlaska property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOdlaska() {
        return datumOdlaska;
    }

    /**
     * Sets the value of the datumOdlaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOdlaska(XMLGregorianCalendar value) {
        this.datumOdlaska = value;
    }

    /**
     * Gets the value of the nazivSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivSmestaja() {
        return nazivSmestaja;
    }

    /**
     * Sets the value of the nazivSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivSmestaja(String value) {
        this.nazivSmestaja = value;
    }

    /**
     * Gets the value of the idSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSmestaja() {
        return idSmestaja;
    }

    /**
     * Sets the value of the idSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSmestaja(String value) {
        this.idSmestaja = value;
    }

    /**
     * Gets the value of the idKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdKorisnika(String value) {
        this.idKorisnika = value;
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
     * Gets the value of the izvrseno property.
     * 
     */
    public boolean isIzvrseno() {
        return izvrseno;
    }

    /**
     * Sets the value of the izvrseno property.
     * 
     */
    public void setIzvrseno(boolean value) {
        this.izvrseno = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     */
    public int getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     */
    public void setCena(int value) {
        this.cena = value;
    }

}

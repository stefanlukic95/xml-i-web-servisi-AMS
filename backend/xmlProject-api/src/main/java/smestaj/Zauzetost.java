//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.21 at 01:24:11 PM CEST 
//


package smestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for zauzetost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zauzetost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum_pocetka" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum_kraja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zauzetost", propOrder = {
    "datumPocetka",
    "datumKraja"
})
public class Zauzetost {

    @XmlElement(name = "datum_pocetka", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPocetka;
    @XmlElement(name = "datum_kraja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumKraja;

    /**
     * Gets the value of the datumPocetka property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPocetka() {
        return datumPocetka;
    }

    /**
     * Sets the value of the datumPocetka property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPocetka(XMLGregorianCalendar value) {
        this.datumPocetka = value;
    }

    /**
     * Gets the value of the datumKraja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumKraja() {
        return datumKraja;
    }

    /**
     * Sets the value of the datumKraja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumKraja(XMLGregorianCalendar value) {
        this.datumKraja = value;
    }

}
//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.0-b170531.0717 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.03.07 �ð� 12:42:30 PM KST 
//


package org.example.atsol_trajectory_20190306_v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>AircraftXMLType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="AircraftXMLType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Generator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Reg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Altitude" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="GroundSpeed" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="LocationStatus" type="{http://www.example.org/ATSOL_TRAJECTORY_20190306_V6}LocationStatusType"/&gt;
 *         &lt;element name="Callsign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Origination"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Destination"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="STD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ETD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ATD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="STA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ETA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ATA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="RouteAir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RouteGround" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RwyArr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RwyDep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="STAR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpotArr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpotLT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SpotDep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ETC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AircraftXMLType", propOrder = {
    "generator",
    "time",
    "reg",
    "type",
    "latitude",
    "longitude",
    "altitude",
    "groundSpeed",
    "locationStatus",
    "callsign",
    "origination",
    "destination",
    "std",
    "etd",
    "atd",
    "sta",
    "eta",
    "ata",
    "routeAir",
    "routeGround",
    "rwyArr",
    "rwyDep",
    "star",
    "iap",
    "sid",
    "spotArr",
    "spotLT",
    "spotDep",
    "etc"
})
public class AircraftXMLType {

    @XmlElement(name = "Generator", required = true)
    protected String generator;
    @XmlElement(name = "Time", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;
    @XmlElement(name = "Reg", required = true)
    protected String reg;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "Altitude")
    protected int altitude;
    @XmlElement(name = "GroundSpeed")
    protected int groundSpeed;
    @XmlElement(name = "LocationStatus", required = true)
    @XmlSchemaType(name = "string")
    protected LocationStatusType locationStatus;
    @XmlElement(name = "Callsign")
    protected String callsign;
    @XmlElement(name = "Origination", required = true)
    protected String origination;
    @XmlElement(name = "Destination", required = true)
    protected String destination;
    @XmlElement(name = "STD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar std;
    @XmlElement(name = "ETD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar etd;
    @XmlElement(name = "ATD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar atd;
    @XmlElement(name = "STA", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sta;
    @XmlElement(name = "ETA", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eta;
    @XmlElement(name = "ATA", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ata;
    @XmlElement(name = "RouteAir")
    protected String routeAir;
    @XmlElement(name = "RouteGround")
    protected String routeGround;
    @XmlElement(name = "RwyArr")
    protected String rwyArr;
    @XmlElement(name = "RwyDep")
    protected String rwyDep;
    @XmlElement(name = "STAR")
    protected String star;
    @XmlElement(name = "IAP")
    protected String iap;
    @XmlElement(name = "SID")
    protected String sid;
    @XmlElement(name = "SpotArr")
    protected String spotArr;
    @XmlElement(name = "SpotLT")
    protected String spotLT;
    @XmlElement(name = "SpotDep")
    protected String spotDep;
    @XmlElement(name = "ETC")
    protected String etc;

    /**
     * generator �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerator() {
        return generator;
    }

    /**
     * generator �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerator(String value) {
        this.generator = value;
    }

    /**
     * time �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * time �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * reg �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReg() {
        return reg;
    }

    /**
     * reg �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReg(String value) {
        this.reg = value;
    }

    /**
     * type �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * type �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * latitude �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * latitude �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * longitude �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * longitude �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * altitude �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * altitude �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setAltitude(int value) {
        this.altitude = value;
    }

    /**
     * groundSpeed �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getGroundSpeed() {
        return groundSpeed;
    }

    /**
     * groundSpeed �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setGroundSpeed(int value) {
        this.groundSpeed = value;
    }

    /**
     * locationStatus �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link LocationStatusType }
     *     
     */
    public LocationStatusType getLocationStatus() {
        return locationStatus;
    }

    /**
     * locationStatus �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationStatusType }
     *     
     */
    public void setLocationStatus(LocationStatusType value) {
        this.locationStatus = value;
    }

    /**
     * callsign �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * callsign �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallsign(String value) {
        this.callsign = value;
    }

    /**
     * origination �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigination() {
        return origination;
    }

    /**
     * origination �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigination(String value) {
        this.origination = value;
    }

    /**
     * destination �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * destination �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * std �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTD() {
        return std;
    }

    /**
     * std �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTD(XMLGregorianCalendar value) {
        this.std = value;
    }

    /**
     * etd �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getETD() {
        return etd;
    }

    /**
     * etd �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setETD(XMLGregorianCalendar value) {
        this.etd = value;
    }

    /**
     * atd �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getATD() {
        return atd;
    }

    /**
     * atd �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setATD(XMLGregorianCalendar value) {
        this.atd = value;
    }

    /**
     * sta �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTA() {
        return sta;
    }

    /**
     * sta �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTA(XMLGregorianCalendar value) {
        this.sta = value;
    }

    /**
     * eta �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getETA() {
        return eta;
    }

    /**
     * eta �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setETA(XMLGregorianCalendar value) {
        this.eta = value;
    }

    /**
     * ata �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getATA() {
        return ata;
    }

    /**
     * ata �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setATA(XMLGregorianCalendar value) {
        this.ata = value;
    }

    /**
     * routeAir �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteAir() {
        return routeAir;
    }

    /**
     * routeAir �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteAir(String value) {
        this.routeAir = value;
    }

    /**
     * routeGround �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteGround() {
        return routeGround;
    }

    /**
     * routeGround �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteGround(String value) {
        this.routeGround = value;
    }

    /**
     * rwyArr �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRwyArr() {
        return rwyArr;
    }

    /**
     * rwyArr �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRwyArr(String value) {
        this.rwyArr = value;
    }

    /**
     * rwyDep �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRwyDep() {
        return rwyDep;
    }

    /**
     * rwyDep �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRwyDep(String value) {
        this.rwyDep = value;
    }

    /**
     * star �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTAR() {
        return star;
    }

    /**
     * star �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTAR(String value) {
        this.star = value;
    }

    /**
     * iap �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIAP() {
        return iap;
    }

    /**
     * iap �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIAP(String value) {
        this.iap = value;
    }

    /**
     * sid �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSID() {
        return sid;
    }

    /**
     * sid �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSID(String value) {
        this.sid = value;
    }

    /**
     * spotArr �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotArr() {
        return spotArr;
    }

    /**
     * spotArr �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotArr(String value) {
        this.spotArr = value;
    }

    /**
     * spotLT �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotLT() {
        return spotLT;
    }

    /**
     * spotLT �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotLT(String value) {
        this.spotLT = value;
    }

    /**
     * spotDep �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpotDep() {
        return spotDep;
    }

    /**
     * spotDep �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotDep(String value) {
        this.spotDep = value;
    }

    /**
     * etc �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getETC() {
        return etc;
    }

    /**
     * etc �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setETC(String value) {
        this.etc = value;
    }

}

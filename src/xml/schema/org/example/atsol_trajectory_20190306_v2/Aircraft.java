//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.0-b170531.0717 버전을 통해 생성되었습니다. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.03.06 시간 08:56:11 PM KST 
//


package org.example.atsol_trajectory_20190306_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Aircraft complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="Aircraft"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Generator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Time"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="19"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Reg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Altitude" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="GroundSpeed" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="LocationStatus" type="{http://www.example.org/ATSOL_TRAJECTORY_20190306_V2}LocationStatusType"/&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aircraft", propOrder = {
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
    "routeAir",
    "routeGround",
    "rwyArr",
    "rwyDep",
    "star",
    "iap",
    "sid",
    "spotArr",
    "spotLT",
    "spotDep"
})
public class Aircraft {

    @XmlElement(name = "Generator", required = true)
    protected String generator;
    @XmlElement(name = "Time", required = true)
    protected String time;
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

    /**
     * generator 속성의 값을 가져옵니다.
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
     * generator 속성의 값을 설정합니다.
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
     * time 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * time 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * reg 속성의 값을 가져옵니다.
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
     * reg 속성의 값을 설정합니다.
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
     * type 속성의 값을 가져옵니다.
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
     * type 속성의 값을 설정합니다.
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
     * latitude 속성의 값을 가져옵니다.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * latitude 속성의 값을 설정합니다.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * longitude 속성의 값을 가져옵니다.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * longitude 속성의 값을 설정합니다.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * altitude 속성의 값을 가져옵니다.
     * 
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * altitude 속성의 값을 설정합니다.
     * 
     */
    public void setAltitude(int value) {
        this.altitude = value;
    }

    /**
     * groundSpeed 속성의 값을 가져옵니다.
     * 
     */
    public int getGroundSpeed() {
        return groundSpeed;
    }

    /**
     * groundSpeed 속성의 값을 설정합니다.
     * 
     */
    public void setGroundSpeed(int value) {
        this.groundSpeed = value;
    }

    /**
     * locationStatus 속성의 값을 가져옵니다.
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
     * locationStatus 속성의 값을 설정합니다.
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
     * callsign 속성의 값을 가져옵니다.
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
     * callsign 속성의 값을 설정합니다.
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
     * origination 속성의 값을 가져옵니다.
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
     * origination 속성의 값을 설정합니다.
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
     * destination 속성의 값을 가져옵니다.
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
     * destination 속성의 값을 설정합니다.
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
     * routeAir 속성의 값을 가져옵니다.
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
     * routeAir 속성의 값을 설정합니다.
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
     * routeGround 속성의 값을 가져옵니다.
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
     * routeGround 속성의 값을 설정합니다.
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
     * rwyArr 속성의 값을 가져옵니다.
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
     * rwyArr 속성의 값을 설정합니다.
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
     * rwyDep 속성의 값을 가져옵니다.
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
     * rwyDep 속성의 값을 설정합니다.
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
     * star 속성의 값을 가져옵니다.
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
     * star 속성의 값을 설정합니다.
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
     * iap 속성의 값을 가져옵니다.
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
     * iap 속성의 값을 설정합니다.
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
     * sid 속성의 값을 가져옵니다.
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
     * sid 속성의 값을 설정합니다.
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
     * spotArr 속성의 값을 가져옵니다.
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
     * spotArr 속성의 값을 설정합니다.
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
     * spotLT 속성의 값을 가져옵니다.
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
     * spotLT 속성의 값을 설정합니다.
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
     * spotDep 속성의 값을 가져옵니다.
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
     * spotDep 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpotDep(String value) {
        this.spotDep = value;
    }

}

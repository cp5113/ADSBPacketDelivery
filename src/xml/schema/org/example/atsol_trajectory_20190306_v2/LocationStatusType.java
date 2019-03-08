//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.0-b170531.0717 버전을 통해 생성되었습니다. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.03.06 시간 08:56:11 PM KST 
//


package org.example.atsol_trajectory_20190306_v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LocationStatusType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OnTaxiway"/&gt;
 *     &lt;enumeration value="OnRunway"/&gt;
 *     &lt;enumeration value="OnSID"/&gt;
 *     &lt;enumeration value="OnSTAR"/&gt;
 *     &lt;enumeration value="OnAPP"/&gt;
 *     &lt;enumeration value="OnATS"/&gt;
 *     &lt;enumeration value="InAirspace"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LocationStatusType")
@XmlEnum
public enum LocationStatusType {

    @XmlEnumValue("OnTaxiway")
    ON_TAXIWAY("OnTaxiway"),
    @XmlEnumValue("OnRunway")
    ON_RUNWAY("OnRunway"),
    @XmlEnumValue("OnSID")
    ON_SID("OnSID"),
    @XmlEnumValue("OnSTAR")
    ON_STAR("OnSTAR"),
    @XmlEnumValue("OnAPP")
    ON_APP("OnAPP"),
    @XmlEnumValue("OnATS")
    ON_ATS("OnATS"),
    @XmlEnumValue("InAirspace")
    IN_AIRSPACE("InAirspace");
    private final String value;

    LocationStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LocationStatusType fromValue(String v) {
        for (LocationStatusType c: LocationStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

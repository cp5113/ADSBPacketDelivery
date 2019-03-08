//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.0-b170531.0717 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.03.07 �ð� 12:42:30 PM KST 
//


package xml.schema.org.example.atsol_trajectory_20190306_v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LocationStatusType�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
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

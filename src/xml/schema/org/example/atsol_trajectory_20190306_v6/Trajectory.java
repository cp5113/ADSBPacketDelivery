//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.0-b170531.0717 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.03.07 �ð� 12:42:30 PM KST 
//


package xml.schema.org.example.atsol_trajectory_20190306_v6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trajectory complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="Trajectory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AircraftXML" type="{http://www.example.org/ATSOL_TRAJECTORY_20190306_V6}AircraftXMLType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trajectory", propOrder = {
    "aircraftXML"
})
public class Trajectory {

    @XmlElement(name = "AircraftXML", required = true)
    protected List<AircraftXMLType> aircraftXML;

    /**
     * Gets the value of the aircraftXML property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aircraftXML property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAircraftXML().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AircraftXMLType }
     * 
     * 
     */
    public List<AircraftXMLType> getAircraftXML() {
        if (aircraftXML == null) {
            aircraftXML = new ArrayList<AircraftXMLType>();
        }
        return this.aircraftXML;
    }

}

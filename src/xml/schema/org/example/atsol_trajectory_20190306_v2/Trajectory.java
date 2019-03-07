//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.0-b170531.0717 버전을 통해 생성되었습니다. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.03.06 시간 08:56:11 PM KST 
//


package org.example.atsol_trajectory_20190306_v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trajectory complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="Trajectory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Aircraft" type="{http://www.example.org/ATSOL_TRAJECTORY_20190306_V2}Aircraft" maxOccurs="unbounded"/&gt;
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
    "aircraft"
})
public class Trajectory {

    @XmlElement(name = "Aircraft", required = true)
    protected List<Aircraft> aircraft;

    /**
     * Gets the value of the aircraft property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aircraft property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAircraft().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aircraft }
     * 
     * 
     */
    public List<Aircraft> getAircraft() {
        if (aircraft == null) {
            aircraft = new ArrayList<Aircraft>();
        }
        return this.aircraft;
    }

}

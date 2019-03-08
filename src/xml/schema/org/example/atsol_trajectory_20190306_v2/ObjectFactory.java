//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.0-b170531.0717 버전을 통해 생성되었습니다. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2019.03.06 시간 08:56:11 PM KST 
//


package org.example.atsol_trajectory_20190306_v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.atsol_trajectory_20190306_v2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ATSOL_QNAME = new QName("http://www.example.org/ATSOL_TRAJECTORY_20190306_V2", "ATSOL");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.atsol_trajectory_20190306_v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Trajectory }
     * 
     */
    public Trajectory createTrajectory() {
        return new Trajectory();
    }

    /**
     * Create an instance of {@link Aircraft }
     * 
     */
    public Aircraft createAircraft() {
        return new Aircraft();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trajectory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Trajectory }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.org/ATSOL_TRAJECTORY_20190306_V2", name = "ATSOL")
    public JAXBElement<Trajectory> createATSOL(Trajectory value) {
        return new JAXBElement<Trajectory>(_ATSOL_QNAME, Trajectory.class, null, value);
    }

}

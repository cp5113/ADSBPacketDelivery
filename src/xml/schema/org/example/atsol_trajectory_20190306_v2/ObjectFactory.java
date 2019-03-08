//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.0-b170531.0717 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://jaxb.java.net/">https://jaxb.java.net/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2019.03.06 �ð� 08:56:11 PM KST 
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

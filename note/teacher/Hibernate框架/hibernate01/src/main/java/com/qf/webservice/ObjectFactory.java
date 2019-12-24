
package com.qf.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.qf.webservice package. 
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

    private final static QName _QueryPhoneResponse_QNAME = new QName("http://webservice.qf.com/", "queryPhoneResponse");
    private final static QName _QueryPhone_QNAME = new QName("http://webservice.qf.com/", "queryPhone");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.qf.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryPhoneResponse }
     * 
     */
    public QueryPhoneResponse createQueryPhoneResponse() {
        return new QueryPhoneResponse();
    }

    /**
     * Create an instance of {@link QueryPhone }
     * 
     */
    public QueryPhone createQueryPhone() {
        return new QueryPhone();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.qf.com/", name = "queryPhoneResponse")
    public JAXBElement<QueryPhoneResponse> createQueryPhoneResponse(QueryPhoneResponse value) {
        return new JAXBElement<QueryPhoneResponse>(_QueryPhoneResponse_QNAME, QueryPhoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.qf.com/", name = "queryPhone")
    public JAXBElement<QueryPhone> createQueryPhone(QueryPhone value) {
        return new JAXBElement<QueryPhone>(_QueryPhone_QNAME, QueryPhone.class, null, value);
    }

}

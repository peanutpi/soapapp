//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.06 at 10:26:32 PM IST 
//


package soap.com.app.producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saleOrder" type="{http://com.soap/app/producing-web-service}saleOrder"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saleOrder"
})
@XmlRootElement(name = "getSaleOrderResponse")
public class GetSaleOrderResponse {

    @XmlElement(required = true)
    protected SaleOrder saleOrder;

    /**
     * Gets the value of the saleOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SaleOrder }
     *     
     */
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    /**
     * Sets the value of the saleOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleOrder }
     *     
     */
    public void setSaleOrder(SaleOrder value) {
        this.saleOrder = value;
    }

}

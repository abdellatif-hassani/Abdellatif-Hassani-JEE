
package proxy;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.2
 * Generated source version: 3.0
 * 
 */
@WebService(name = "BanqueWS", targetNamespace = "http://ws.enset.ma/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueWS {


    /**
     * 
     * @param code
     * @return
     *     returns proxy.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompte", targetNamespace = "http://ws.enset.ma/", className = "proxy.GetCompte")
    @ResponseWrapper(localName = "getCompteResponse", targetNamespace = "http://ws.enset.ma/", className = "proxy.GetCompteResponse")
    @Action(input = "http://ws.enset.ma/BanqueWS/getCompteRequest", output = "http://ws.enset.ma/BanqueWS/getCompteResponse")
    public Compte getCompte(
        @WebParam(name = "code", targetNamespace = "")
        int code);

    /**
     * 
     * @return
     *     returns java.util.List<proxy.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listComptes", targetNamespace = "http://ws.enset.ma/", className = "proxy.ListComptes")
    @ResponseWrapper(localName = "listComptesResponse", targetNamespace = "http://ws.enset.ma/", className = "proxy.ListComptesResponse")
    @Action(input = "http://ws.enset.ma/BanqueWS/listComptesRequest", output = "http://ws.enset.ma/BanqueWS/listComptesResponse")
    public List<Compte> listComptes();

    /**
     * 
     * @param montant
     * @return
     *     returns double
     */
    @WebMethod(operationName = "ConversionEuroToDh")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ConversionEuroToDh", targetNamespace = "http://ws.enset.ma/", className = "proxy.ConversionEuroToDh")
    @ResponseWrapper(localName = "ConversionEuroToDhResponse", targetNamespace = "http://ws.enset.ma/", className = "proxy.ConversionEuroToDhResponse")
    @Action(input = "http://ws.enset.ma/BanqueWS/ConversionEuroToDhRequest", output = "http://ws.enset.ma/BanqueWS/ConversionEuroToDhResponse")
    public double conversionEuroToDh(
        @WebParam(name = "montant", targetNamespace = "")
        double montant);

}

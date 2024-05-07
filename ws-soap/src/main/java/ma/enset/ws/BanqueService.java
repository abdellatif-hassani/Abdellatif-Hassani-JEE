package ma.enset.ws;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import ma.enset.model.Compte;

import java.util.Date;
import java.util.List;

@WebService(name = "BanqueWS")
public class BanqueService {
    @WebMethod(operationName = "ConversionEuroToDh")
    public double conversion(@WebParam(name = "montant") double mt) {
        return mt * 11;
    }

    @WebMethod()
    public Compte getCompte(@WebParam(name = "code") int code) {
        Compte cp = new Compte(code, Math.random()*10000, new Date());
        return cp;
    }

    @WebMethod()
    public List<Compte> listComptes() {
        return List.of(new Compte(1, Math.random()*10000, new Date()),
                new Compte(2, Math.random()*10000, new Date()),
                new Compte(2, Math.random()*10000, new Date())
        );
    }
}

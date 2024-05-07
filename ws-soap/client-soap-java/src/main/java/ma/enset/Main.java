package ma.enset;

import proxy.BanqueServiceService;
import proxy.BanqueWS;
import proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueWS proxy = new BanqueServiceService().getBanqueWSPort();
        System.out.println(proxy.conversionEuroToDh(100));
        Compte cp = proxy.getCompte(1);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        System.out.println(cp.getDateCreation());
        proxy.listComptes().forEach(c -> {
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
            System.out.println(c.getDateCreation());
        });
    }
}
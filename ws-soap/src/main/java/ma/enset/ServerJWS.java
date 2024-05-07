package ma.enset;

import jakarta.xml.ws.Endpoint;
import ma.enset.ws.BanqueService;

public class ServerJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:7070/BanqueWS", new BanqueService());
        System.out.println("Server JWS is running");
    }
}

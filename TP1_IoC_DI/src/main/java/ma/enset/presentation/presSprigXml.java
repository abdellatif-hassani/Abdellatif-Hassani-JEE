package ma.enset.presentation;

import ma.enset.metier.IMetierProduct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class presSprigXml {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetierProduct metier = (IMetierProduct) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}

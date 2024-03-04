package ma.enset.presentation;

import ma.enset.metier.IMetierProduct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class presSpringAnnotation {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext("ma.enset.metier", "ma.enset.dao");
        IMetierProduct metier = context.getBean(IMetierProduct.class);
        System.out.println(metier.calcul());
    }
}

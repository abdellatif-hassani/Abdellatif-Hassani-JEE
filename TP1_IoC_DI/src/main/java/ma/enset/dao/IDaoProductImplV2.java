package ma.enset.dao;

import ma.enset.entities.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Second Implementation of the IDaoProduct interface in which data is retreived from a web service
@Repository("dao2")
public class IDaoProductImplV2 implements IDaoProduct{
    @Override
    public List<Product> getData() throws SQLException {
        //Supposed that data is retreived from REST API
        System.out.println("Version web service ");
        List<Product> products = new ArrayList<>();
        products.add(new Product(12, "MACBOOK pro m2", 12000, 4));
        products.add(new Product(12, "PC HP G8", 5600, 14));
        return products;
    }

    @Override
    public void add(Product o) throws SQLException {

    }
}

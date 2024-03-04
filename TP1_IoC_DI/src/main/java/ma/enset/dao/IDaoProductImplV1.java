package ma.enset.dao;

import ma.enset.entities.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//First Implementation of IDaoProduct interface in which data is retreived from the database
@Repository("dao1")
public class IDaoProductImplV1 implements IDaoProduct{
    //Retreiving data from DB
    @Override
    public List<Product> getData() throws SQLException {
        System.out.println("Version base de données");
        //Connecting to database
        Connection connection = SingletonDB.getConnection();
        //Creating a list to store the Products retreived from DB
        List<Product> products = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT");
        //Object relational mapping : converting data returned as table to objects
        while(resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setQuantity(resultSet.getInt("quantity"));
            //Adding the product to the list
            products.add(product);
        }
        //returning the list of products
        return products;
    }

    @Override
    public void add(Product o) throws SQLException {
        //Connecting to database
        Connection connection = SingletonDB.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSET INTO PRODUCT(name, price, quantity) WHERE (?, ?, ?)");
        statement.setLong(0, o.getId());
        statement.setString(0, o.getName());
        statement.setDouble(0, o.getPrice());
        statement.setInt(0, o.getQuantity());
        statement.executeUpdate();
    }
}

package ma.enset.metier;

import ma.enset.dao.IDaoProduct;
import ma.enset.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class IMetierImpl implements IMetierProduct{
    private IDaoProduct iDaoProduct;

//    public IMetierImpl() {
//    }

    public IMetierImpl(@Qualifier("dao2") IDaoProduct iDaoProduct) {
        this.iDaoProduct = iDaoProduct;
    }

    //calculing the average price of products
    @Override
    public double calcul() throws SQLException {
        List<Product> products = iDaoProduct.getData();
        double sumPrice= products.stream().mapToDouble(Product::getPrice).average().getAsDouble();
        return sumPrice;
    }

    public void setiDaoProduct(IDaoProduct iDaoProduct) {
        this.iDaoProduct = iDaoProduct;
    }

}

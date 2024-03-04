package ma.enset.presentation;

import ma.enset.dao.IDaoProduct;
import ma.enset.dao.IDaoProductImplV1;
import ma.enset.metier.IMetierImpl;
import ma.enset.metier.IMetierProduct;

import java.sql.SQLException;


public class Pres2 {
    public static void main(String[] args) throws SQLException {
        //Instanciation statique en utilisant "new" des objets iDaoProductImplV1 et iMetierProduct
        IDaoProduct iDaoProduct = new IDaoProductImplV1();
        //Injection de l'objet iDaoProductImplV1 à l'objet iMetierProduct par le constructeur
        IMetierProduct iMetierProduct = new IMetierImpl(iDaoProduct);
//        //Injection de l'objet iDaoProductImplV1 à l'objet iMetierProduct par le setter
//        IMetierProduct iMetierProduct = new IMetierImpl();
//        ((IMetierImpl) iMetierProduct).setiDaoProduct(iDaoProduct);
        System.out.println("Version : "+iDaoProduct.getClass()+" *** Result : "+iMetierProduct.calcul());

    }
}

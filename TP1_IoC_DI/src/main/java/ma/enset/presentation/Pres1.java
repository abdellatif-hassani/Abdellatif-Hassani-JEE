package ma.enset.presentation;

import ma.enset.dao.IDaoProduct;
import ma.enset.metier.IMetierProduct;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Scanner;

public class Pres1 {
    public static void main(String[] args) throws SQLException {
                //Instanciation dynamique en utilisant un fichier de configuration config.txt
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.next();
            String metierClassName = scanner.next();
            Class cDao = Class.forName(daoClassName);
            IDaoProduct iDaoProduct = (IDaoProduct) cDao.getConstructor().newInstance();
            Class cMetier = Class.forName(metierClassName);
            IMetierProduct iMetierProduct = (IMetierProduct) cMetier.getConstructor().newInstance();
            Method method = cMetier.getMethod("setiDaoProduct", IDaoProduct.class);
            method.invoke(iMetierProduct, iDaoProduct);
            System.out.println("Version : "+iDaoProduct.getClass()+" *** Result : "+iMetierProduct.calcul());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package persistence;

import java.io.File;
import java.io.IOException;

public class ProductRepository {
    File fileVariable = new File("Gestion\\data\\basedate.txt");

    public ProductRepository() {
    }

    public void Ssas() {
        System.out.println("Existe : " + fileVariable.exists());
        try {
            if (fileVariable.createNewFile()){
                System.out.println("Se creo");
            }else {
                System.out.println("ya existe");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

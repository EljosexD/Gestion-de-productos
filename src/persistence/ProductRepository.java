package persistence;

import java.io.*;

public class ProductRepository {
    File fileVariable = new File("Gestion\\data\\basedate.txt");

    public ProductRepository() {
    }

    public void writeFile(int id,String name,double price,int amount,String type){
        try {
            FileWriter writer = new FileWriter(fileVariable,true);
            writer.write(id+","+name+","+price+","+amount+","+type+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public void readerFile(){
        String content;
        try {
            FileReader read = new FileReader(fileVariable);
            BufferedReader readReader = new BufferedReader(read);
            content = readReader.readLine();
            while(content != null){
                System.out.println(content);
                content = readReader.readLine();
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public void CreateFile() {
        try {
            if (this.fileVariable.createNewFile()){
                FileWriter writer = new FileWriter(fileVariable,true);
                writer.write("Id,Name,Price,Amount,Type\n");
                writer.close();
                System.out.println("Create your databases");
            }else {
                System.out.println("Detected file : " + fileVariable.getName());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}

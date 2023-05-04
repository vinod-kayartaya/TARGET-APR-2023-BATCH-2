package com.targetindia.programs;

import com.targetindia.model.Customer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class GetCustomersFromFile {
    public static void main(String[] args) throws  Exception {

        FileInputStream file = new FileInputStream("customers.dat");
        ObjectInputStream in = new ObjectInputStream(file);

        while(true){
            try{
                Customer c = (Customer) in.readObject();
                c.print();

                byte[] bytes = c.getPhoto();
                if(bytes!=null){
                    // save the byte[] as a file
                    FileOutputStream pic = new FileOutputStream(c.getName()+".jpg");
                    pic.write(bytes);
                    pic.close();
                }
            }catch (EOFException e){
                break;
            }
        }

        in.close();
        file.close();
    }
}

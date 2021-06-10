/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mickley Khoza
 */
public class SupplierRead {
    private String name;
    private String productType;
    private String productDescription;

    public SupplierRead() {
        super();
    }

    public  SupplierRead (String stHolderId, String name, String productType, String productDescription ) {
        
        this.name = name;
        this.productType = productType;
        this.productDescription = productDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return String.format("%-5s\t%-20s\t%-10s\t%-15s",super.toString(), getName(),getProductType(), getProductDescription());
    }
    
    
    
    public static void main(String[] args) {
        Supplier s1 = new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV");
        Supplier s2 = new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan");
        Supplier s3 = new Supplier("S290", "MotorMania", "Hyundai", "compact budget");
        Supplier s4 = new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan");
        Supplier s5 = new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus");
        
        
        ArrayList< Supplier> supplier = new ArrayList<>();
        supplier.add(s1);
        supplier.add(s2);
        supplier.add(s3);
        supplier.add(s4);
        supplier.add(s5);
        
        
        try{
            FileOutputStream writeData = new FileOutputStream("supplierOutFile.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(supplier);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData = new FileInputStream("supplierOutFile.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList people2 = (ArrayList< SupplierRead>) readStream.readObject();
            readStream.close();

            System.out.println(people2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
    


    


    


    


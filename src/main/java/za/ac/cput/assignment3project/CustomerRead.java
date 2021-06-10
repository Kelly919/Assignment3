/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;
import java.io.*;
import java.util.ArrayList;
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
public class CustomerRead {
    
    
   private String firstName;
    private String surName;
    private String address;
    private String dateOfBirth;
    private double credit;
    private boolean canRent;   //true - can rent a car; false - not allowed to rent because they have not returned a previously rented car

    public CustomerRead()    {
        super();
    }

    public CustomerRead(String stHolderId, String firstName, String surName, String addr, String dob, double cred, boolean canRent)    {
    	
        setFirstName(firstName);
        setSurName(surName);
        setAddress(addr);
        setDateOfBirth(dob);
        setCredit(cred);
        setCanRent(canRent);
    }
  
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setSurName(String surName)   {
        this.surName = surName;
    }

    public void setAddress(String addr)    {
        this.address = addr;
    }

    public void setDateOfBirth(String dob) { this.dateOfBirth = dob; }

    public void setCredit(double cred)    {
        this.credit = cred;
    }

	public void setCanRent(boolean canRent)  {
		this.canRent = canRent;
	}

    public String getFirstName()     {
        return firstName;
    }

    public String getSurName()    {
        return surName;
    }

    public String getAddress()    {
        return address;
    }

    public String getDateOfBirth() { return dateOfBirth; }

    public double getCredit()    {
        return credit;
    }

	public boolean getCanRent()     {
        return canRent;
    }

    @Override
    public String toString()      {
        return String.format("%-10s\t%-10s\t%-10s\t%-15s\t%-10s\tR%-10.2f\t%-10s", super.toString(), getFirstName()
                , getSurName(),
                getAddress(), 
                getDateOfBirth(),
                getCredit(), 
                getCanRent());
    }


    


    
    
    public static void main(String[] args) {


        Customer c1 = new Customer("C100", "Mike", "Rohsopht", "Bellville", "1993-01-24", 975.10, true);
        Customer c2 = new Customer("C130", "Stu", "Padassol", "Sea Point", "1987-05-18", 645.25, true);
        Customer c3= new Customer("C150", "Luke", "Atmyass", "Bellville", "1981-01-27", 1520.50, false);
        Customer c4= new Customer("C250", "Eileen", "Sideways", "Nyanga", "1999-11-27", 190.85, true);
        Customer c5= new Customer("C260", "Ima", "Stewpidas", "Atlantis", "2001-01-27", 1890.70, true);
        Customer c6= new Customer("C300", "Ivana.B", "Withew", "Langa", "1998-07-16", 1190.50, false);
        
        
        ArrayList< Customer> customer = new ArrayList<>();

        customer.add(c1);
        customer.add(c2);
        customer.add(c3);
        customer.add(c4);
        customer.add(c5);
        customer.add(c6);
        
        
        try{
            FileOutputStream writeData = new FileOutputStream("customerOutFile.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(customer);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream readData = new FileInputStream("customerOutFile.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList people2 = (ArrayList< CustomerRead>) readStream.readObject();
            readStream.close();

            System.out.println(people2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
    


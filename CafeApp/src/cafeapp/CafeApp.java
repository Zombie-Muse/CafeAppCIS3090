/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeapp;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Gary McCormack
 */
public class CafeApp {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String last = null, line;
        
        System.out.println("Welcome to CIS3090 Cafe");      //Welcome message...Nice little touch, right?
        
        CafeOrder order = new CafeOrder();      //creates an order object
        order.Coffee();     //gets the coffe choice
        order.AddOn();      //gets all the add-ons 
        order.Food();       //gets the food choice
        
        order.calculateTotal(); //calculates the order total
        
        try {
        FileOutputStream orderFile = new FileOutputStream("order.txt", true);   //creates (if not already created) a text file to write the order to...
        PrintWriter outFS = new PrintWriter(orderFile);                         //...if the text file already exists, it adds the order to the end of the text file
        outFS.println(order.printOrder());
        
        outFS.close();
        }
        catch (Exception e){                //catches any exceptions
            System.out.println(e);
        }
        try {
            
            BufferedReader in = new BufferedReader(new FileReader("order.txt"));        //reads from created text file and outputs the last line (the current order)
            while ((line = in.readLine()) != null) {
                if (line != null) {
                    last = line;
                    
                }
            }
            System.out.println(last);                   //prints the last line of the text file
        }
        
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeapp;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Gary McCormack CIS3090
 */
public class CafeOrder {
    private int selection;              			//initializes all the variables
    private double coffeePrice = 0.0;
    private double foodPrice = 0.0;
    private double addOnPrice = 0.0;
    private double runningTotal = 0.0;
    private double total = 0.0;
    private String coffeeName, foodName;
    private ArrayList<String> addOn = new ArrayList<String>();      		//creates and ArrayList for the selected add-on options
    private NumberFormat nf = NumberFormat.getCurrencyInstance();  	 		//outputs the double result in the format of dollars and cents
    
    public void CafeOrder() {       				//basic constructor..not used but thought I should include it
    }
    
    public void Coffee() {          				//method for getting coffee order
        Scanner sc = new Scanner(System.in);    
        while (true) {
            try{
            System.out.print("=== Select Coffee ===\n"      				//prints menu options
                + "1 Espresso           $3.00\n"
                + "2 Latte              $4.75\n"
                + "3 Cappuccino         $4.00\n"
                + "4 Cold Brew          $4.00\n"
                + "Select a coffee [1, 4]: ");
        
            selection = sc.nextInt();           	//takes input for coffee selection
        
            switch(selection){              		//switch statements assign proper variable values via set methods
                case 1:                         	//sets the price and name
                    setCoffeePrice(3.0);
                    setCoffeeName("Espresso");
                    break;
                
                case 2:                         	//sets the price and name
                    setCoffeePrice(4.75);
                    setCoffeeName("Latte");
                    break;
                
                case 3:                         	//sets the price and name
                    setCoffeePrice(4.0);
                    setCoffeeName("Cappuccino");
                    break;
                
                case 4:                         	//sets the price and name
                    setCoffeePrice(4.0);
                    setCoffeeName("Cold Brew");
                    break;
                default:
                    System.out.println("Please enter a valid selection"); 	//if input numbers are not 1 - 4, it continues the loop until a valid selection is made
                    continue;
            }
            break;                          		//breaks the loop
        }
            catch (Exception e){
                System.out.println("Please enter numbers only");        	//catches invalid inputs (i.e. if user enters letters rather than numbers)
                sc.next();
            }
        }
    }
    
    public void Food() {                        	//method for getting food order
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
            System.out.print("=== Select Food ===\n"        				//prints food options
                + "1 Tuna Sandwich     $11.00\n"
                + "2 Chicken Sandwich   $9.00\n"
                + "3 Burrito            $10.00\n"
                + "4 Yogurt Bowl        $9.00\n"
                + "5 Avocado Toast      $8.00\n"
                + "Select a food [1, 5]: ");
        
            selection = sc.nextInt();           	//takes input for food selection
        
            switch(selection){              		//switch statements assign proper values for variables via set methods
                case 1:                             //sets price and name
                    setFoodName("Tuna Sandwich");
                    setFoodPrice(11.0);
                    break;
                
                case 2:                             //sets price and name
                    setFoodName("Chicken Sandwich");
                    setFoodPrice(9.0);
                    break;
                
                case 3:                             //sets price and name
                    setFoodName("Burrito");
                    setFoodPrice(10.0);
                    break;
                
                case 4:                             //sets price and name
                    setFoodName("Yogurt");
                    setFoodPrice(9.0);
                    break;
                case 5:                             //sets price and name
                    setFoodName("Avocado Toast");
                    setFoodPrice(8.0);
                    break;
                default:                            //if numbers are not 1-5, the loop continues until a valid selection is made
                    System.out.println("Please enter a valid selection");
                    continue;
            }
            break;
        }
        catch (Exception e){
                System.out.println("Please enter numbers only");          	//catches invalid inputs (i.e. if user enters letters rather than numbers)
                sc.next();
            }
    }
    }
    
    public void AddOn() {               			//method for getting all add-on options
        double price = 0.0;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            try {
            System.out.print("=== Select Add-On ===\n"          			//prints add-on options
                + "1 Extra Espresso     $1.50\n"
                + "2 Panna              $1.50\n"
                + "3 Oat Milk           $1.00\n"
                + "4 Almond Milk        $1.00\n"
                + "5 Quit Add-On selection\n"
                + "Select an add-on [1, 5]: ");
        
            selection = sc.nextInt();             	//takes input for add-on selections
        
            switch(selection){                  	//switch statements assign proper values for variables via set methods
                case 1:
                    addOn.add("Extra Espresso");   	//sets name and price
                    price = 1.5;
                    runningTotal += price;         	//adds up total of all add-ons thus far
                    continue;
                
                case 2:                            	//sets name and price
                    addOn.add("Panna");
                    price = 1.5;
                    runningTotal += price;         	//adds up total of all add-ons thus far
                    continue;
                
                case 3:                            	//sets name and price
                    addOn.add("Oat Milk");
                    price = 1.0;
                    runningTotal += price;         	//adds up total of all add-ons thus far
                    continue;
                
                case 4:                            	//sets name and price
                    addOn.add("Almond Milk");
                    price = 1.0;
                    runningTotal += price;         	//adds up total of all add-ons thus far
                    continue;
                case 5:                           	//breaks out of the loop
                    break;
                default:
                    System.out.println("Please enter a valid selection"); 	//if numbers are not 1-5, the loop continues until a valid selection is made
                    continue;
            }
            setAddOnPrice(runningTotal);           	//sets add-on price to the running total of all add-ons
            if (addOn.size() < 1){                  //if no options are selected, addOn is set to null
                addOn = null;
            }
            break;                      			//breaks out of the loop
        }
        catch (Exception e){
                System.out.println("Please enter numbers only");            //catches invalid inputs (i.e. if user enters letters rather than numbers)
                sc.next();
            }
    }
    }
    
    public void setAddOnPrice(double addOnPrice) { 	//sets add-on price
        this.addOnPrice = addOnPrice;
    }
    
    @Override
    public String toString(){                   	//sets the addOn ArrayList as a string
        String adds = "";
        if (addOn != null){                     	//if there are no selections, add-ons are not printed out in the order
        adds = String.join(", ", addOn);
        }
        else {
            adds = null;
        }
        return adds;
    }
    
    public double calculateTotal() {                //calculates total of the entire order
        total = coffeePrice + foodPrice + addOnPrice;
        return total;
    }
    
    public void setCoffeePrice(double coffeePrice) {//sets the coffee price
        this.coffeePrice = coffeePrice;
    }
    
    public double getCoffeePrice() {            	//returns the coffee price
        return coffeePrice;
    }
    
    public void setFoodPrice(double foodPrice) {  	//sets the food price
        this.foodPrice = foodPrice;
    }
    
    public double getFoodPrice() {              	//returns the food price
        return foodPrice;
    }
    
    public String getCoffeeName() {         		//returns the selected coffee name
        return coffeeName;
    }
    
    public void setCoffeeName(String coffeeName) {	//sets the selected coffee name
        this.coffeeName = coffeeName;
    }
    
    public String getFoodName() {           		//returns the selected food name
        return foodName;
    }
    
    public void setFoodName(String foodName) {      //sets the selected food name
        this.foodName = foodName;
    }
    
    public String printOrder(){             		//brings all selections and total together on one line and returns the result
        String coffee = getCoffeeName();
        String adds = toString();
        String food = getFoodName();
        String orderTotal = nf.format(total);
        String custName = getCustName();
        Date now = new Date();                      //sets date and time on the order
        DateFormat defaultDate = DateFormat.getDateTimeInstance();
        String time = defaultDate.format(now);
        String s;
		
        if (adds != null){                          //if the order includes add-ons, it will return this
            s = time + " " + custName + ", " + coffee + ", " + adds + ", " + food + ", " + orderTotal;
			}
        else {                                      //if the order does NOT include add-ons, it will return this
            s = time + " " + custName + ", " + coffee + ", " + food + ", " + orderTotal;
			}
        return s;
    }
    

    public String getCustName() {          			 //prompts user for the name for the order and returns that name
        String name;	
        System.out.print("Please enter your name:  ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        
        return name;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4lohani;

/**
 *
 * @author finda
 */
public class Package {
    
    private double [][] costs = {{2.0,1.5,0.5},
                                 {3.0,2.35,1.5},
                                 {4.5,3.25,2.15}};        
    private int weight;
    private double shippingCost;
    private String customerName;
    private String shippingMethod; //air, truck, or mail
    

   Package(int weight, String shippingMethod, String customerName)
   {//start of constructor
       this.shippingMethod = shippingMethod;
       this.customerName = customerName;
       this.weight = weight;
       this.shippingCost= calcuateCost();
       
   }//end of constructor

   public int getWeight()
   {//start of method
       return this.weight;
   }//end of method
   
   public String getCustomerName()
   {//start of method
       return this.customerName;
   }//end of method

   public String getShippingMethod()
   {//start of method
       return this.shippingMethod;
   }//end of method
   

   public double getShippingCost()
   {
       return this.shippingCost;
   }
   
   public double calcuateCost()
   {//start of method
       try
       {
       if(weight >= 1 && weight <=8)
       {//start of switch
           switch(shippingMethod)
           {//start of switch
                case "air": 
                   shippingCost = costs[0][0];
                   break;//end of case
                case "truck":
                   shippingCost = costs[0][1];
                   break;//end of case
                case "mail":
                   shippingCost = costs[0][2];
                   break;//end of case
           }//end of switch    
       }//end of if
       else
       {//start of else
           if(weight <= 16)
           {//start of if
           
                switch(shippingMethod)
                {//start of switch
                    case "air": 
                    shippingCost = costs[1][0];
                    break;//end of case
                    case "truck":
                    shippingCost = costs[1][1];
                    break;//end of case
                    case "mail":
                    shippingCost = costs[1][2];
                    break;//end of case
                }//end of switch   
           }//end of if
           else
           {//start of else
                switch(shippingMethod)
                {
                    case "air": 
                    shippingCost = costs[2][0];
                    break;//end of case    
                    case "truck":
                    shippingCost = costs[2][1];
                    break;//end of case 
                    case "mail":
                    shippingCost = costs[2][2];
                    break;//end of case 
                }//end of switch   
           }//end of else
       }//end of else
       }//end of try
       catch(NullPointerException e)
       {
           
       }
       return shippingCost;
   }
}

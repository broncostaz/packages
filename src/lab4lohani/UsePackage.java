
package lab4lohani;

import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class UsePackage {

    /**
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
          //variable initizalization
        boolean repeat = true;
        int weight = 0;
        int count = 0;
        int packageCount = 0;
        int insuredPackageCount = 0;
        double shippingCost = 0.0;
        double invoiceShippingCostInsurance = 0.0;
        double invoiceShippingCost = 0.0;
        double invoiceInsuredCost = 0.0;
        String insurance = "";
        String customerName = "";
        String shippingMethod = "";
        String doOver = "";
        InsuredPackage [] customerInsuredPackages = new InsuredPackage[50];
        Package [] customerPackages = new Package[50];
        
        customerName = getCustomerName(customerName);
        do{//start of do while loop
   
        weight = getPackageWeight(weight, repeat);
        shippingMethod = getShippingMethod(shippingMethod);
        insurance = wantInsurance(insurance);
      
        
        if(insurance.equalsIgnoreCase("Yes"))
        {//start of if
            insuredPackageCount++;
            customerInsuredPackages[count] = new InsuredPackage(weight, 
                shippingMethod, customerName);
            
            JOptionPane.showMessageDialog(null, 
                 "Customer Name: " + customerInsuredPackages[count].getCustomerName()
                 + "\nWeight: " + customerInsuredPackages[count].getWeight() 
                 + "\nShipping Method: " + 
                 customerInsuredPackages[count].getShippingMethod() 
                 + "\nShipping Cost: " +
                 customerInsuredPackages[count].getShippingCost()
                 +  "\nInsurance Cost: " +
                 customerInsuredPackages[count].getInsuranceCost()
                 + "\nTotal Cost: " + customerInsuredPackages[count].getTotalCost(),
                 "Insured Package Details", JOptionPane.INFORMATION_MESSAGE);
        }//end of if
        else
        {//start of else
            packageCount++;
             customerPackages[count] = new Package(weight, shippingMethod, 
                    customerName);
           
        JOptionPane.showMessageDialog(null, 
                 "Customer Name: " + customerPackages[count].getCustomerName()
                 + "\nWeight: " + customerPackages[count].getWeight() 
                 + "\nShipping Method: " + 
                 customerPackages[count].getShippingMethod() 
                 + "\nTotal/Shipping Cost: " +
                 customerPackages[count].getShippingCost(),
                 "Package Details", JOptionPane.INFORMATION_MESSAGE);
        }//end of else
       
        count++;
        
        doOver = JOptionPane.showInputDialog(null, "Do you want to order"
                + " another package? Yes or no?", "Another Package",
                JOptionPane.INFORMATION_MESSAGE);
        while(!doOver.equalsIgnoreCase("Yes") && 
                !doOver.equalsIgnoreCase("No"))
        {//start of while
            JOptionPane.showMessageDialog(null, "You did not input yes or no!",
                    "Alert", JOptionPane.ERROR_MESSAGE);
            doOver = JOptionPane.showInputDialog(null, "Do you want to order"
                + " another package? Please enter, yes or no?", 
                    "Another Package", JOptionPane.INFORMATION_MESSAGE);
        }//end of while
        }while(doOver.equalsIgnoreCase("Yes"));
        
        
        try
        {//start of try
            if(packageCount >= 1)
            for(int i = 0; i < customerPackages.length - 1; i++)
            {//start of for
               invoiceShippingCost +=  customerPackages[i].getShippingCost();
            }//end of for
            if(insuredPackageCount >= 1)
            for(int i = 0; i < customerInsuredPackages.length - 1; i++)
            {//start of for
               invoiceShippingCostInsurance +=
                       customerInsuredPackages[i].getShippingCost();
               invoiceInsuredCost += 
                       customerInsuredPackages[i].getInsuranceCost();
            }//end of for            
        }//end of try
        catch(NullPointerException e)
        {//start of catch
              JOptionPane.showMessageDialog(null, "A NullPointerException "
                      + "occured", "Alert", JOptionPane.ERROR_MESSAGE);
        }//end of catch
        catch(Exception e)
        {//start of catch
            JOptionPane.showMessageDialog(null, "An exception occured ",
                    "Alert", JOptionPane.ERROR_MESSAGE);
        }//end of catch
        try
        {
        JOptionPane.showMessageDialog(null, 
                 "Customer Name: " + customerName
                 + "\nAmount of Packages Ordered: " + count  
                 + "\nTotal Shipping Cost (Insurance and Regular Package): " +
                 (invoiceShippingCostInsurance + invoiceShippingCost)
                 + "\nTotal InsuranceCost (Only applied to Insured "
                 + "Packages): " + invoiceInsuredCost 
                 + "\nTotal Invoice Cost: " + (invoiceInsuredCost + 
                 invoiceShippingCostInsurance + invoiceShippingCost), 
                 "Invoice Details", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(NullPointerException e)
        {
          JOptionPane.showMessageDialog(null, "A NullPointerException "
                      + "occured", "Alert", JOptionPane.ERROR_MESSAGE);   
        }
    }//end of main
   
    public static int getPackageWeight(int weight, boolean repeat )
    {//start of method
 
        do
        {//start of do
        try
        {//start of try     
        weight = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "What is the weight of your package?", "Weight of Package", 
                JOptionPane.INFORMATION_MESSAGE));
        repeat = true;
            while(weight < 1)
            {//start of while
            JOptionPane.showMessageDialog(null, "The weight has to be greater "
                    + "or equal to 1 oz!", "alert", 
                    JOptionPane.ERROR_MESSAGE);    
            weight = Integer.parseInt(JOptionPane.showInputDialog(null,
                "What is the weight of the package?", "weight", 
                JOptionPane.INFORMATION_MESSAGE));
            repeat = true;
            }//end of while
        }//end of try
        catch(NumberFormatException e)
        {//start of catch
            JOptionPane.showMessageDialog(null,"Input can ONLY BE int numbers", 
                    "NumberFormatException", JOptionPane.ERROR_MESSAGE);
            repeat = false;
        }//end of catch
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert",
            JOptionPane.ERROR_MESSAGE);
        }
        }while(repeat == false);
        
       return weight;
    }//end of method
   
    public static String getShippingMethod(String shippingMethod)
    {//start of method
        shippingMethod = JOptionPane.showInputDialog(null, 
                "What shipping method do you want to use to ship the package"
                        + " Air, Truck, or Mail", "Shipping Method",
                        JOptionPane.INFORMATION_MESSAGE);
        while(!shippingMethod.equalsIgnoreCase("Mail") && 
                !shippingMethod.equalsIgnoreCase("Truck") && 
                !shippingMethod.equalsIgnoreCase("Air"))
        {//start of while
            JOptionPane.showMessageDialog(null, "The shipping method must "
             + "be either Air, Truck, or Mail!", "Alert", 
             JOptionPane.ERROR_MESSAGE);
            shippingMethod = JOptionPane.showInputDialog(null, 
                    "What shipping method do you wan to use, Air, Truck, or"
                            + ", Mail?",
                    "Shipping Method", JOptionPane.INFORMATION_MESSAGE);
        }//end of while 
        
        shippingMethod.toLowerCase();
        return shippingMethod;
    }//end of method
    
    public static String wantInsurance(String insurance)
    {//start of method
        insurance = JOptionPane.showInputDialog(null, "Do you want the"
            + " package insured? Yes or No?", "Want Insurance", 
            JOptionPane.INFORMATION_MESSAGE);
        while(!insurance.equalsIgnoreCase("yes") && 
                !insurance.equalsIgnoreCase("no"))
        {//start of while
            JOptionPane.showMessageDialog(null, "You have inputted somthing" +
                " that is not yes or no!1", "Alert", JOptionPane.ERROR_MESSAGE);
            insurance = JOptionPane.showInputDialog(null, "Do you want"
                    + " to insure the package? MUST BE Yes or No?", "Insurance",
                    JOptionPane.INFORMATION_MESSAGE);
        }//end of while
        return insurance;
    }//end of method
    
    public static String getCustomerName(String name)
    {
        name = JOptionPane.showInputDialog(null, "What is the customers"
                + " name?", "Customer Name", JOptionPane.INFORMATION_MESSAGE);
        while(!name.matches("[a-zA-Z]+"))
        {
            JOptionPane.showMessageDialog(null, "The name enter is not a "
            + "real name as it either was entered with special characters"
            + " or numbers.", "Alert", JOptionPane.ERROR_MESSAGE);
            name = JOptionPane.showInputDialog(null, "What is the customers"
             + " name? Enter only letters!", "Name", 
             JOptionPane.INFORMATION_MESSAGE);
        }
        return name;
    }
}
    


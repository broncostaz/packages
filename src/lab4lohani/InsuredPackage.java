
package lab4lohani;

/**
 *
 * 
 */
public class InsuredPackage extends Package{
    private double shipping;
    private double insuranceCost;
    private double totalShippingCostWithInsurance;
    private double [] costs = {2.45, 3.95, 5.55};
    
    
    InsuredPackage(int weight, String shippingMethod, String customerName)
    {//start of constructor
        super(weight, shippingMethod, customerName);
        this.insuranceCost = calcuateCost();
    }//end of constructor
    
    public double getInsuranceCost()
    {//start of method
        return this.insuranceCost;
    }//end of method
    

    public double getTotalCost()
    {
        return this.totalShippingCostWithInsurance;
    }

    @Override
    public double calcuateCost()
    {//start of method
        try
        {    
        super.calcuateCost();
        
        if(super.getShippingCost() <= 1.00)
        {//start of if
            insuranceCost = costs[0];
        }//end
        else
        {
            if(super.getShippingCost() <= 3.00)
            {//start of if
                insuranceCost = costs[1];
            }//end of if
            else
            {//start of else
            insuranceCost = costs[2];
            }//end of else
        }//end of else
        totalShippingCostWithInsurance = super.getShippingCost() + 
                insuranceCost;
        }
        catch(NullPointerException e)
        {
            
        }
        return insuranceCost;
    }//end of method
}

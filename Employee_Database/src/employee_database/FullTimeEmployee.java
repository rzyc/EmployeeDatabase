package employee_database;

public class FullTimeEmployee extends Employee 
{    
    // Fields
    private double annualSalary;
    
    // Constructor
    public FullTimeEmployee (int empNo, boolean aMale, String fName, String lName, double dRate, double aSalary)
    {
         super (empNo, aMale, fName, lName, dRate);
         annualSalary = aSalary;
    }
    
    // Method to calculate annual net income rounded to 2 decimal places
    public double getAnnualNetIncome ()
    {
        return annualSalary*(1-deductionRate);
    }
    
    // Getter method
    public double getAnnualSalary ()
    {
        return annualSalary;
    }
}

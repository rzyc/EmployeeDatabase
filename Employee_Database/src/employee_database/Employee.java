package employee_database;

public class Employee 
{
    // Fields
    protected int empNumber;
    protected boolean isMale;
    protected String firstName;
    protected String lastName;
    protected double deductionRate;

    // Constructor
    public Employee(int empNo, boolean aMale, String fName, String lName, double dRate) 
    {
        empNumber = empNo;
        isMale = aMale;
        firstName = fName;
        lastName = lName;
        deductionRate = dRate;
    }

    // Returns isMale field as a string
    public String strIsMale()
    {
        if (isMale)
        {
            return "Male";
        }
        else
        {
            return "Female";
        }
    }
    
    // Getter methods
    public int getEmpNumber() 
    {  
        return empNumber;
    }

    public boolean getIsMale() 
    {
        return isMale;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public double getDeductionRate() 
    {
        return deductionRate;
    }
}

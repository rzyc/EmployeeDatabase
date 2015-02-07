package employee_database;

public class PartTimeEmployee extends Employee {
    
    // Fields
    private double hourlyWage;
    private double hoursWeek;
    private double weeksYear;
    
    // Constructor
    public PartTimeEmployee (int empNo, boolean aMale, String fName, String lName, double dRate, double hrlyWage, double hrsWeek, double wksYear)
    {
        super (empNo, aMale, fName, lName, dRate);
        hourlyWage = hrlyWage;
        hoursWeek = hrsWeek;
        weeksYear = wksYear;
    }
    
    // Method to calculate annual net income to 2 decimal places
    public double getAnnualNetIncome ()
    {
        return hourlyWage*hoursWeek*weeksYear*(1-deductionRate);
    }

    // Getter methods
    public double getHourlyWage()
    {
        return hourlyWage;
    }
    
    public double getHoursWeek()
    {
        return hoursWeek;
    }
    
    public double getWeeksYear()
    {
        return weeksYear;
    }
}
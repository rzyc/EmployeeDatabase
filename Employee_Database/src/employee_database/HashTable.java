package employee_database;

import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashTable
{
    // Fields
    private int numBuckets;
    private int numItems;
    ArrayList<ArrayList<Employee>> table;
    private PrintWriter writer;
    File database;

    // Constructor
    public HashTable(int numBuckets)
    {
        this.numBuckets = numBuckets;
        numItems = 0;
        table = new ArrayList<ArrayList<Employee>>(numBuckets);
        for (int i = 0;i < numBuckets;i++)
        {
            table.add(new ArrayList<Employee>());
        }
        database = new File("Database.txt");
    }

    // Returns the bucket for the key value
    public int Hash(int key)
    {
        return (key % numBuckets);
    }

    // Adds an employee to the HashTable
    public void addEmployee(Employee item)
    {
        int hash = Hash(item.getEmpNumber());
        table.get(hash).add(item);
        numItems++;
    }

    // Replaces an existing employee
    public void replaceEmployee(Employee item)
    {
        int hash = Hash(item.getEmpNumber());
        int bucketPosition = 0;
        for (int i = 0;i < table.get(hash).size();i++)
        {
            if (item.getEmpNumber() == table.get(hash).get(i).getEmpNumber())
            {
                bucketPosition = i;
            }
        }
        table.get(hash).set(bucketPosition, item);
    }

    // Returns true if an employee with the employee number exists, returns false otherwise
    public boolean employeeExists(int key)
    {
        int hash = Hash(key);
        for (int i = 0;i < table.get(hash).size();i++)
        {
            if (key == table.get(hash).get(i).getEmpNumber())
            {
                return true;
            }
        }
        return false;
    }

    // Returns an employee object when an employee number is entered and that employee exists,
    // returns null if the employee does not exist
    public Employee getEmployee(int key)
    {
        int hash = Hash(key);
        for (int i = 0;i < table.get(hash).size();i++)
        {
            if (key == table.get(hash).get(i).getEmpNumber())
            {
                return table.get(hash).get(i);
            }
        }
        return null;
    }

    // Removes an employee with the given employee number
    public void removeEmployee(int key)
    {
        int hash = Hash(key);
        for (int i = 0;i < table.get(hash).size();i++)
        {
            if (key == table.get(hash).get(i).getEmpNumber())
            {
                table.get(hash).remove(i);
            }
        }
    }

    // Saves the database to text file
    public void saveBucket()
    {
        try
        {
            writer = new PrintWriter("Database.txt");
        }
        catch (IOException ex)
        {
            Logger.getLogger(HashTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean curBool = false;

        // Goes through table and prints out every employee to text file
        for (int i = 0;i < table.size();i++)
        {
            for (int j = 0;j < table.get(i).size();j++)
            {
                if (table.get(i).get(j) instanceof FullTimeEmployee)
                {
                    FullTimeEmployee current = (FullTimeEmployee) table.get(i).get(j);

                    writer.flush();

                    if (curBool)
                    {
                        writer.println();
                    }

                    writer.println(current.getEmpNumber());
                    writer.println(current.getIsMale());
                    writer.println(current.getFirstName());
                    writer.println(current.getLastName());
                    writer.println(current.getDeductionRate());
                    writer.println("true");
                    writer.print(current.getAnnualSalary());

                    curBool = true;
                }
                else
                {
                    PartTimeEmployee current = (PartTimeEmployee) table.get(i).get(j);

                    writer.flush();

                    if (curBool)
                    {
                        writer.println();
                    }

                    writer.println(current.getEmpNumber());
                    writer.println(current.getIsMale());
                    writer.println(current.getFirstName());
                    writer.println(current.getLastName());
                    writer.println(current.getDeductionRate());
                    writer.println("false");
                    writer.println(current.getHourlyWage());
                    writer.println(current.getHoursWeek());
                    writer.print(current.getWeeksYear());

                    curBool = true;
                }
            }
        }
        writer.close();
    }
    
    // Getter methods
    public int getNumBuckets()
    {
        return numBuckets;
    }

    public int getNumItems()
    {
        return numItems;
    }
    
    public ArrayList<ArrayList<Employee>> getTable ()
    {
        return table;
    }
}

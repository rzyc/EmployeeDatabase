package employee_database;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public class NumberVerifier extends InputVerifier
{
    // Fields
    private double upper;
    private double value;
    private boolean doubleCheck;
    private boolean returnValue;

    // Constructor
    public NumberVerifier(double upperBound, boolean doubleCheck)
    {
        upper = upperBound;
        this.doubleCheck = doubleCheck;
    }

    // Verifies the input of the JComponent
    @Override
    public boolean verify(JComponent input)
    {
        // Local variables
        final JTextComponent source = (JTextComponent) input;
        String text = source.getText();
        returnValue = false;
        
        // Checking a double
        if (doubleCheck == true)
        {
            try
            {
                value = Double.parseDouble(text);
            } 
            catch (NumberFormatException e)
            {
                returnValue = false;
            }
        }
        // Checking an integer
        else
        {
            try
            {
                value = Integer.parseInt(text);
            }
            catch (NumberFormatException e)
            {
                returnValue = false;
            }
        }

        // Checks for cases when value has no upper bound
        if (upper == -1)
        {
            if (0 < value)
            {
                returnValue = true;
            }
        }
        // Checks for cases when value has an upper and lower bound
        else
        {
            if ((0 < value) && (value < upper))
            {
                returnValue = true;
            }
        }   
        
        // Changes colour of JComponent based on whether the input is valid
        if (returnValue)
        {
            source.setBackground(new Color (100, 200, 40)); // Green
        }
        else
        {
            source.setBackground(new Color (240, 40, 40)); // Red
            returnValue = false;
        }
        
        // Resets the colour of JComponent if it is empty
        if (source.getText().equals(""))
        {
            returnValue = true;
            source.setBackground(Color.WHITE);
        }
        
        return returnValue;
    }
  }
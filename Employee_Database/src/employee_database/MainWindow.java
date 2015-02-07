package employee_database;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import javax.swing.InputVerifier;
import javax.swing.table.DefaultTableModel;
        
public class MainWindow extends javax.swing.JFrame
{ 
    // Fields
    private HashTable hashTable;
    private boolean changesMade;
    private HashSet<Integer> usedNum;
    private Random generator;
    private Integer empNum;
    private InputVerifier deductionRateVerifier;
    private InputVerifier hourlyWageVerifier;
    private InputVerifier hoursWeekVerifier;
    private InputVerifier weeksYearVerifier;
    private InputVerifier annualSalaryVerifier;
    private InputVerifier employeeNumberVerifier;
    private Color green;
    private Color red;
    private String[] titles;

    public MainWindow()
    {
        initComponents();
        hashTable = new HashTable (4);
        empNum = 0;
        usedNum = new HashSet<Integer>();
        generator = new Random();
        green = new Color(100, 200, 40);
        red = new Color(240, 40, 40);
        titles = new String[] {"Employee Number", "Employment", "Sex", "First Name", "Last Name", "Deduction Rate", "Hourly Wage", "Hours/Week", "Weeks/Year", "Annual Salary", "Annual Net Income"};
        
        File database = new File("Database.txt");
        
        try
        {
            Scanner dbScanner = new Scanner(database);

            while (dbScanner.hasNextLine())
            {
                int num = dbScanner.nextInt();
                boolean sex = dbScanner.nextBoolean();
                String fName = dbScanner.next();
                String lName = dbScanner.next();
                double ded = dbScanner.nextDouble();
                boolean type = dbScanner.nextBoolean();
                // Full-Time
                if (type) 
                {
                    double sal = dbScanner.nextDouble();
                    Employee newFullTimeEmployee = new FullTimeEmployee(num, sex, fName, lName, ded, sal);
                    hashTable.addEmployee(newFullTimeEmployee);
                }
                // Part-Time
                else
                {
                    double hrw = dbScanner.nextDouble();
                    double hpw = dbScanner.nextDouble();
                    double wpy = dbScanner.nextDouble();
                    Employee newPartTimeEmployee = new PartTimeEmployee(num, sex, fName, lName, ded, hrw, hpw, wpy);
                    hashTable.addEmployee(newPartTimeEmployee);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        // Instantiates and sets the input verifiers
        deductionRateVerifier = new NumberVerifier(1, true);
        apt_DeductionRateField.setInputVerifier(deductionRateVerifier);
        aft_DeductionRateField.setInputVerifier(deductionRateVerifier);
        s_DeductionRateField.setInputVerifier(deductionRateVerifier);

        hourlyWageVerifier = new NumberVerifier(-1, true);
        apt_HourlyWageField.setInputVerifier(hourlyWageVerifier);
        s_HourlyWageField.setInputVerifier(hourlyWageVerifier);

        hoursWeekVerifier = new NumberVerifier(168, true);
        apt_HoursWeekField.setInputVerifier(hoursWeekVerifier);
        s_HoursWeekField.setInputVerifier(hoursWeekVerifier);

        weeksYearVerifier = new NumberVerifier(52, true);
        apt_WeeksYearField.setInputVerifier(weeksYearVerifier);
        s_WeeksYearField.setInputVerifier(weeksYearVerifier);

        annualSalaryVerifier = new NumberVerifier(-1, true);
        aft_AnnualSalaryField.setInputVerifier(annualSalaryVerifier);
        s_AnnualSalaryField.setInputVerifier(annualSalaryVerifier);

        employeeNumberVerifier = new NumberVerifier(10000000, false);
        s_SearchEmployeeNumberField.setInputVerifier(employeeNumberVerifier);
    }

    @SuppressWarnings ("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        exitDialog = new javax.swing.JDialog();
        e_AskForSave = new javax.swing.JLabel();
        e_DontSaveButton = new javax.swing.JButton();
        e_CancelButton = new javax.swing.JButton();
        e_SaveButton = new javax.swing.JButton();
        deleteDialog = new javax.swing.JDialog();
        d_AskForDelete = new javax.swing.JLabel();
        d_NoDeleteButton = new javax.swing.JButton();
        d_YesDeleteButton = new javax.swing.JButton();
        confirmationDialog = new javax.swing.JDialog();
        c_Confirmation = new javax.swing.JLabel();
        fullViewDialog = new javax.swing.JDialog();
        f_Panel = new javax.swing.JScrollPane();
        f_Table = new javax.swing.JTable();
        mainWindow = new javax.swing.JTabbedPane();
        addPartTimePanel = new javax.swing.JPanel();
        apt_GenerateEmployeeNumberButton = new javax.swing.JButton();
        apt_EmployeeNumber = new javax.swing.JLabel();
        apt_Sex = new javax.swing.JLabel();
        apt_SexCombo = new javax.swing.JComboBox();
        apt_FirstName = new javax.swing.JLabel();
        apt_FirstNameField = new javax.swing.JTextField();
        apt_LastName = new javax.swing.JLabel();
        apt_LastNameField = new javax.swing.JTextField();
        apt_DeductionRate = new javax.swing.JLabel();
        apt_HourlyWage = new javax.swing.JLabel();
        apt_HourlyWageField = new javax.swing.JTextField();
        apt_HoursWeek = new javax.swing.JLabel();
        apt_HoursWeekField = new javax.swing.JTextField();
        apt_WeeksYear = new javax.swing.JLabel();
        apt_WeeksYearField = new javax.swing.JTextField();
        apt_AddEmployeeButton = new javax.swing.JButton();
        apt_NotEnoughInfoWarning = new javax.swing.JLabel();
        apt_SaveDatabaseButton = new javax.swing.JButton();
        apt_DeductionRateField = new javax.swing.JTextField();
        addFullTimePanel = new javax.swing.JPanel();
        aft_GenerateEmployeeNumberButton = new javax.swing.JButton();
        aft_EmployeeNumber = new javax.swing.JLabel();
        aft_Sex = new javax.swing.JLabel();
        aft_SexCombo = new javax.swing.JComboBox();
        aft_FirstName = new javax.swing.JLabel();
        aft_FirstNameField = new javax.swing.JTextField();
        aft_LastName = new javax.swing.JLabel();
        aft_LastNameField = new javax.swing.JTextField();
        aft_DeductionRate = new javax.swing.JLabel();
        aft_DeductionRateField = new javax.swing.JTextField();
        aft_AnnualSalary = new javax.swing.JLabel();
        aft_AnnualSalaryField = new javax.swing.JTextField();
        aft_AddEmployeeButton = new javax.swing.JButton();
        aft_SaveDatabaseButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        s_SearchEmployeeButton = new javax.swing.JButton();
        s_RemoveEmployeeButton = new javax.swing.JButton();
        s_SearchEmployeeNumber = new javax.swing.JLabel();
        s_SearchEmployeeNumberField = new javax.swing.JTextField();
        s_Sex = new javax.swing.JLabel();
        s_FirstName = new javax.swing.JLabel();
        s_LastName = new javax.swing.JLabel();
        s_DeductionRate = new javax.swing.JLabel();
        s_Employment = new javax.swing.JLabel();
        s_AnnualSalary = new javax.swing.JLabel();
        s_HourlyWage = new javax.swing.JLabel();
        s_HoursWeek = new javax.swing.JLabel();
        s_WeeksYear = new javax.swing.JLabel();
        s_AnnualNetIncome = new javax.swing.JLabel();
        s_SaveDatabaseButton = new javax.swing.JButton();
        s_EmployeeNumber = new javax.swing.JLabel();
        s_EmployeeNumberDisplay = new javax.swing.JLabel();
        s_ModifyEmployeeButton = new javax.swing.JButton();
        s_SexCombo = new javax.swing.JComboBox();
        s_FirstNameField = new javax.swing.JTextField();
        s_LastNameField = new javax.swing.JTextField();
        s_DeductionRateField = new javax.swing.JTextField();
        s_WeeksYearField = new javax.swing.JTextField();
        s_HoursWeekField = new javax.swing.JTextField();
        s_HourlyWageField = new javax.swing.JTextField();
        s_AnnualSalaryField = new javax.swing.JTextField();
        s_AnnualNetIncomeDisplay = new javax.swing.JLabel();
        s_EmploymentCombo = new javax.swing.JComboBox();
        s_ViewDataBase = new javax.swing.JButton();

        exitDialog.setTitle("Diamond 2013");
        exitDialog.setIconImage(null);
        exitDialog.setLocation(new Point(mainWindow.getBounds().x + mainWindow.getBounds().width/2 - 250, mainWindow.getBounds().y + mainWindow.getBounds().height/2 - 75));
        exitDialog.setMinimumSize(new java.awt.Dimension(500, 125));
        exitDialog.setPreferredSize(new java.awt.Dimension(500, 125));
        exitDialog.pack();

        e_AskForSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e_AskForSave.setText("Do you want to save the changes you made to your employee database?");

        e_DontSaveButton.setText("Don't save");
        e_DontSaveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                e_DontSaveButtonActionPerformed(evt);
            }
        });

        e_CancelButton.setText("Cancel");
        e_CancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                e_CancelButtonActionPerformed(evt);
            }
        });

        e_SaveButton.setText("Save");
        e_SaveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                e_SaveButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout exitDialogLayout = new org.jdesktop.layout.GroupLayout(exitDialog.getContentPane());
        exitDialog.getContentPane().setLayout(exitDialogLayout);
        exitDialogLayout.setHorizontalGroup(
            exitDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(exitDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(e_AskForSave, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
            .add(exitDialogLayout.createSequentialGroup()
                .add(46, 46, 46)
                .add(e_DontSaveButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(e_CancelButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(e_SaveButton)
                .add(46, 46, 46))
        );
        exitDialogLayout.setVerticalGroup(
            exitDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(exitDialogLayout.createSequentialGroup()
                .add(29, 29, 29)
                .add(e_AskForSave)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(exitDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(e_DontSaveButton)
                    .add(e_CancelButton)
                    .add(e_SaveButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        deleteDialog.setTitle("Diamond 2013");
        deleteDialog.setIconImage(null);
        deleteDialog.setLocation(new Point(mainWindow.getBounds().x + mainWindow.getBounds().width/2 - 250, mainWindow.getBounds().y + mainWindow.getBounds().height/2 - 75));
        deleteDialog.setMinimumSize(new java.awt.Dimension(500, 125));
        deleteDialog.pack();

        d_AskForDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d_AskForDelete.setText("--");
        d_AskForDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        d_NoDeleteButton.setText("No");
        d_NoDeleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                d_NoDeleteButtonActionPerformed(evt);
            }
        });

        d_YesDeleteButton.setText("Yes");
        d_YesDeleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                d_YesDeleteButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout deleteDialogLayout = new org.jdesktop.layout.GroupLayout(deleteDialog.getContentPane());
        deleteDialog.getContentPane().setLayout(deleteDialogLayout);
        deleteDialogLayout.setHorizontalGroup(
            deleteDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(deleteDialogLayout.createSequentialGroup()
                .add(41, 41, 41)
                .add(d_NoDeleteButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 278, Short.MAX_VALUE)
                .add(d_YesDeleteButton)
                .add(56, 56, 56))
            .add(deleteDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(d_AskForDelete, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteDialogLayout.setVerticalGroup(
            deleteDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, deleteDialogLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .add(d_AskForDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(deleteDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(d_NoDeleteButton)
                    .add(d_YesDeleteButton))
                .add(12, 12, 12))
        );

        confirmationDialog.setTitle("Diamond 2013");
        confirmationDialog.setSize(new java.awt.Dimension(400, 150));

        c_Confirmation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c_Confirmation.setText("--");

        org.jdesktop.layout.GroupLayout confirmationDialogLayout = new org.jdesktop.layout.GroupLayout(confirmationDialog.getContentPane());
        confirmationDialog.getContentPane().setLayout(confirmationDialogLayout);
        confirmationDialogLayout.setHorizontalGroup(
            confirmationDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(confirmationDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(c_Confirmation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        confirmationDialogLayout.setVerticalGroup(
            confirmationDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(confirmationDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(c_Confirmation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        fullViewDialog.setTitle("Diamond 2013");
        fullViewDialog.setBounds(new java.awt.Rectangle(0, 0, 1250, 450));

        f_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "Employee Number", "Employment", "Sex", "First Name", "Last Name", "Deduction Rate", "Hourly Wage", "Hours/Week", "Weeks/Year", "Annual Salary", "Annual Net Income"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        f_Panel.setViewportView(f_Table);
        f_Table.getColumnModel().getColumn(1).setMinWidth(100);
        f_Table.getColumnModel().getColumn(1).setPreferredWidth(100);
        f_Table.getColumnModel().getColumn(1).setMaxWidth(100);
        f_Table.getColumnModel().getColumn(2).setMinWidth(50);
        f_Table.getColumnModel().getColumn(2).setPreferredWidth(50);
        f_Table.getColumnModel().getColumn(2).setMaxWidth(50);

        org.jdesktop.layout.GroupLayout fullViewDialogLayout = new org.jdesktop.layout.GroupLayout(fullViewDialog.getContentPane());
        fullViewDialog.getContentPane().setLayout(fullViewDialogLayout);
        fullViewDialogLayout.setHorizontalGroup(
            fullViewDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fullViewDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(f_Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                .addContainerGap())
        );
        fullViewDialogLayout.setVerticalGroup(
            fullViewDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fullViewDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(f_Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Diamond 2013");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                WindowClosing(evt);
            }
        });

        apt_GenerateEmployeeNumberButton.setText("Generate Employee Number");
        apt_GenerateEmployeeNumberButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                apt_GenerateEmployeeNumberButtonActionPerformed(evt);
            }
        });

        apt_EmployeeNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apt_EmployeeNumber.setText("000000");

        apt_Sex.setText("Sex");

        apt_SexCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        apt_FirstName.setText("First Name");

        apt_LastName.setText("Last Name");

        apt_DeductionRate.setText("Deduction Rate");

        apt_HourlyWage.setText("Hourly Wage");

        apt_HoursWeek.setText("Hours/Week");

        apt_WeeksYear.setText("Weeks/Year");

        apt_AddEmployeeButton.setText("Add Employee");
        apt_AddEmployeeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                apt_AddEmployeeButtonActionPerformed(evt);
            }
        });

        apt_NotEnoughInfoWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apt_NotEnoughInfoWarning.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        apt_NotEnoughInfoWarning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        apt_SaveDatabaseButton.setText("Save Database");
        apt_SaveDatabaseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                apt_SaveDatabaseButtonActionPerformed(evt);
            }
        });

        apt_DeductionRateField.setInputVerifier (deductionRateVerifier);

        org.jdesktop.layout.GroupLayout addPartTimePanelLayout = new org.jdesktop.layout.GroupLayout(addPartTimePanel);
        addPartTimePanel.setLayout(addPartTimePanelLayout);
        addPartTimePanelLayout.setHorizontalGroup(
            addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, addPartTimePanelLayout.createSequentialGroup()
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(addPartTimePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(apt_EmployeeNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(addPartTimePanelLayout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(apt_SaveDatabaseButton))
                            .add(apt_GenerateEmployeeNumberButton)
                            .add(apt_AddEmployeeButton)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, addPartTimePanelLayout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(apt_NotEnoughInfoWarning, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(addPartTimePanelLayout.createSequentialGroup()
                                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(apt_FirstName)
                                    .add(apt_Sex)
                                    .add(apt_LastName)
                                    .add(apt_DeductionRate))
                                .add(35, 35, 35)
                                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(apt_FirstNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .add(apt_LastNameField)
                                    .add(apt_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(apt_DeductionRateField))
                                .add(83, 83, 83)
                                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(apt_HoursWeek)
                                    .add(apt_WeeksYear)
                                    .add(apt_HourlyWage))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(apt_HourlyWageField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .add(apt_HoursWeekField)
                                    .add(apt_WeeksYearField))))
                        .add(34, 34, 34)))
                .addContainerGap())
        );
        addPartTimePanelLayout.setVerticalGroup(
            addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(addPartTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apt_SaveDatabaseButton)
                    .add(apt_GenerateEmployeeNumberButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(apt_EmployeeNumber)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apt_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(apt_Sex)
                    .add(apt_HourlyWage)
                    .add(apt_HourlyWageField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apt_FirstName)
                    .add(apt_FirstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(apt_HoursWeek)
                    .add(apt_HoursWeekField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apt_LastName)
                    .add(apt_LastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(apt_WeeksYear)
                    .add(apt_WeeksYearField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(addPartTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apt_DeductionRate)
                    .add(apt_DeductionRateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(apt_AddEmployeeButton)
                .add(18, 18, 18)
                .add(apt_NotEnoughInfoWarning, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainWindow.addTab("Add Part-Time Employee", addPartTimePanel);

        aft_GenerateEmployeeNumberButton.setText("Generate Employee Number");
        aft_GenerateEmployeeNumberButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aft_GenerateEmployeeNumberButtonActionPerformed(evt);
            }
        });

        aft_EmployeeNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aft_EmployeeNumber.setText("000000");

        aft_Sex.setText("Sex");

        aft_SexCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        aft_FirstName.setText("First Name");

        aft_LastName.setText("Last Name");

        aft_DeductionRate.setText("Deduction Rate");

        aft_AnnualSalary.setText("Annual Salary");

        aft_AddEmployeeButton.setText("Add Employee");
        aft_AddEmployeeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aft_AddEmployeeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aft_AddEmployeeButtonActionPerformed(evt);
            }
        });

        aft_SaveDatabaseButton.setText("Save Database");
        aft_SaveDatabaseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aft_SaveDatabaseButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout addFullTimePanelLayout = new org.jdesktop.layout.GroupLayout(addFullTimePanel);
        addFullTimePanel.setLayout(addFullTimePanelLayout);
        addFullTimePanelLayout.setHorizontalGroup(
            addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(addFullTimePanelLayout.createSequentialGroup()
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(addFullTimePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(aft_EmployeeNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(aft_GenerateEmployeeNumberButton)
                            .add(aft_AddEmployeeButton)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, addFullTimePanelLayout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(aft_SaveDatabaseButton))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, addFullTimePanelLayout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(aft_FirstName)
                            .add(aft_Sex)
                            .add(aft_LastName)
                            .add(aft_DeductionRate))
                        .add(35, 35, 35)
                        .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(aft_LastNameField)
                            .add(aft_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(aft_DeductionRateField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, aft_FirstNameField))
                        .add(83, 83, 83)
                        .add(aft_AnnualSalary)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                        .add(aft_AnnualSalaryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(34, 34, 34)))
                .addContainerGap())
        );
        addFullTimePanelLayout.setVerticalGroup(
            addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(addFullTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(aft_SaveDatabaseButton)
                    .add(aft_GenerateEmployeeNumberButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(aft_EmployeeNumber)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(aft_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(aft_Sex)
                    .add(aft_AnnualSalary)
                    .add(aft_AnnualSalaryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(aft_FirstName)
                    .add(aft_FirstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(aft_LastName)
                    .add(aft_LastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(addFullTimePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(aft_DeductionRate)
                    .add(aft_DeductionRateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(aft_AddEmployeeButton)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        mainWindow.addTab("Add Full-Time Employee", addFullTimePanel);

        s_SearchEmployeeButton.setText("Search for Employee");
        s_SearchEmployeeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_SearchEmployeeButtonActionPerformed(evt);
            }
        });

        s_RemoveEmployeeButton.setText("Remove Employee");
        s_RemoveEmployeeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_RemoveEmployeeButtonActionPerformed(evt);
            }
        });

        s_SearchEmployeeNumber.setText("Search for Employee #");

        s_Sex.setText("Sex");

        s_FirstName.setText("First Name");

        s_LastName.setText("Last Name");

        s_DeductionRate.setText("Deduction Rate");

        s_Employment.setText("Employment");

        s_AnnualSalary.setText("Annual Salary");

        s_HourlyWage.setText("Hourly Wage");

        s_HoursWeek.setText("Hours/Week");

        s_WeeksYear.setText("Weeks/Year");

        s_AnnualNetIncome.setText("Annual Net Income");

        s_SaveDatabaseButton.setText("Save Database");
        s_SaveDatabaseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_SaveDatabaseButtonActionPerformed(evt);
            }
        });

        s_EmployeeNumber.setText("Employee Number");

        s_EmployeeNumberDisplay.setText("--");

        s_ModifyEmployeeButton.setText("Modify Employee");
        s_ModifyEmployeeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_ModifyEmployeeButtonActionPerformed(evt);
            }
        });

        s_SexCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        s_AnnualNetIncomeDisplay.setText("--");

        s_EmploymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Part-Time", "Full-Time" }));
        s_EmploymentCombo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_EmploymentComboActionPerformed(evt);
            }
        });

        s_ViewDataBase.setText("View Database");
        s_ViewDataBase.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                s_ViewDataBaseActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout searchPanelLayout = new org.jdesktop.layout.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, searchPanelLayout.createSequentialGroup()
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(searchPanelLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(s_Employment)
                            .add(s_SearchEmployeeNumber)
                            .add(s_FirstName)
                            .add(s_LastName)
                            .add(s_DeductionRate)
                            .add(s_EmployeeNumber)
                            .add(s_Sex)))
                    .add(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(s_SearchEmployeeButton)))
                .add(18, 18, 18)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(searchPanelLayout.createSequentialGroup()
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(searchPanelLayout.createSequentialGroup()
                                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, s_EmployeeNumberDisplay, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, s_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, s_FirstNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, s_LastNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, s_DeductionRateField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .add(50, 50, 50)
                                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(s_AnnualNetIncome)
                                    .add(s_HoursWeek)
                                    .add(s_HourlyWage)
                                    .add(s_WeeksYear)
                                    .add(s_AnnualSalary)))
                            .add(s_EmploymentCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_WeeksYearField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_HoursWeekField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_HourlyWageField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_AnnualSalaryField)
                            .add(s_AnnualNetIncomeDisplay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, searchPanelLayout.createSequentialGroup()
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(searchPanelLayout.createSequentialGroup()
                                .add(s_RemoveEmployeeButton)
                                .add(18, 18, 18)
                                .add(s_ModifyEmployeeButton))
                            .add(s_SearchEmployeeNumberField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 117, Short.MAX_VALUE)
                        .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_ViewDataBase)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, s_SaveDatabaseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 134, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_SearchEmployeeButton)
                    .add(s_RemoveEmployeeButton)
                    .add(s_SaveDatabaseButton)
                    .add(s_ModifyEmployeeButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_SearchEmployeeNumber)
                    .add(s_SearchEmployeeNumberField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(s_ViewDataBase))
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(searchPanelLayout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(s_EmployeeNumber))
                    .add(searchPanelLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(s_EmployeeNumberDisplay)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(s_AnnualSalary)
                        .add(s_AnnualSalaryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(s_Sex)
                        .add(s_SexCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_FirstName)
                    .add(s_FirstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(s_HourlyWage)
                    .add(s_HourlyWageField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_LastName)
                    .add(s_LastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(s_HoursWeek)
                    .add(s_HoursWeekField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_DeductionRate)
                    .add(s_DeductionRateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(s_WeeksYear)
                    .add(s_WeeksYearField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(searchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(s_Employment)
                    .add(s_EmploymentCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(s_AnnualNetIncome)
                    .add(s_AnnualNetIncomeDisplay))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        mainWindow.addTab("Search for an Employee", searchPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainWindow)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(mainWindow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Formats double values into money format
    private String formatMoney(double input)
    {
        BigDecimal unrounded = new BigDecimal(input);
        BigDecimal rounded = unrounded.setScale(2, BigDecimal.ROUND_HALF_UP);
        return String.format("%.2f", rounded.doubleValue());
    }

    // Clears all information from the Add Part-Time Employee panel
    private void resetAPT()
    {
        empNum = 0;
        aft_EmployeeNumber.setText("000000");
        apt_EmployeeNumber.setText("000000");

        apt_FirstNameField.setText("");
        apt_FirstNameField.setBackground(Color.WHITE);

        apt_LastNameField.setText("");
        apt_LastNameField.setBackground(Color.WHITE);

        apt_DeductionRateField.setText("");
        apt_DeductionRateField.setBackground(Color.WHITE);

        apt_HourlyWageField.setText("");
        apt_HourlyWageField.setBackground(Color.WHITE);

        apt_HoursWeekField.setText("");
        apt_HoursWeekField.setBackground(Color.WHITE);

        apt_WeeksYearField.setText("");
        apt_WeeksYearField.setBackground(Color.WHITE);
    }

    // Clears all information from the Add Full-Time Employee panel
    private void resetAFT()
    {
        empNum = 0;
        aft_EmployeeNumber.setText("000000");
        apt_EmployeeNumber.setText("000000");

        aft_FirstNameField.setText("");
        aft_FirstNameField.setBackground(Color.WHITE);

        aft_LastNameField.setText("");
        aft_LastNameField.setBackground(Color.WHITE);

        aft_DeductionRateField.setText("");
        aft_DeductionRateField.setBackground(Color.WHITE);

        aft_AnnualSalaryField.setText("");
        aft_AnnualSalaryField.setBackground(Color.WHITE);
    }

    // Clears all information from the Search for an Employee panel
    private void resetSearch()
    {
        s_SearchEmployeeNumberField.setText("");
        s_SearchEmployeeNumberField.setBackground(Color.WHITE);

        s_EmployeeNumberDisplay.setText("--");
        s_EmployeeNumberDisplay.setBackground(Color.WHITE);

        s_SexCombo.setSelectedItem("Male");

        s_FirstNameField.setText("");
        s_FirstNameField.setBackground(Color.WHITE);

        s_LastNameField.setText("");
        s_LastNameField.setBackground(Color.WHITE);

        s_DeductionRateField.setText("");
        s_DeductionRateField.setBackground(Color.WHITE);

        s_EmploymentCombo.setSelectedItem("Part-Time Employee");

        s_AnnualSalaryField.setText("");
        s_AnnualSalaryField.setBackground(Color.WHITE);

        s_HourlyWageField.setText("");
        s_HourlyWageField.setBackground(Color.WHITE);

        s_HoursWeekField.setText("");
        s_HoursWeekField.setBackground(Color.WHITE);

        s_WeeksYearField.setText("");
        s_WeeksYearField.setBackground(Color.WHITE);

        s_AnnualNetIncomeDisplay.setText("");
        s_AnnualNetIncomeDisplay.setBackground(Color.WHITE);
    }

    // Generates an employee number on the Add Part-Time Employee panel
    private void apt_GenerateEmployeeNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apt_GenerateEmployeeNumberButtonActionPerformed
        empNum = generator.nextInt((999999 - 1) + 1) + 1;
        if (!usedNum.contains(empNum))
        {
            this.aft_EmployeeNumber.setText(empNum.toString());
        }
        this.apt_EmployeeNumber.setText(empNum.toString());
    }//GEN-LAST:event_apt_GenerateEmployeeNumberButtonActionPerformed

    // Generates an employee number on the Add Full-Time Employee panel
    private void aft_GenerateEmployeeNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aft_GenerateEmployeeNumberButtonActionPerformed
        empNum = generator.nextInt((999999 - 1) + 1) + 1;
        if (!usedNum.contains(empNum))
        {
            this.aft_EmployeeNumber.setText(empNum.toString());
        }
        this.apt_EmployeeNumber.setText(empNum.toString());
    }//GEN-LAST:event_aft_GenerateEmployeeNumberButtonActionPerformed

    private void s_RemoveEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_RemoveEmployeeButtonActionPerformed
        deleteDialog.setLocation(new Point((int) Math.round(mainWindow.getLocationOnScreen().getX()) + mainWindow.getBounds().width / 2 - 250, (int) Math.round(mainWindow.getLocationOnScreen().getY()) + mainWindow.getBounds().height / 2 - 37));
        if (s_EmployeeNumberDisplay.getText().equals("--"))
        {
            displayMessage("<html>You have not found an employee to delete. Find an employee and try again.", red);
        }
        else
        {
            d_AskForDelete.setText("Are you sure you want to delete employee #" + s_EmployeeNumberDisplay.getText() + "?");
            deleteDialog.setVisible(true);
        }
    }//GEN-LAST:event_s_RemoveEmployeeButtonActionPerformed

    private void s_SearchEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_SearchEmployeeButtonActionPerformed
        int requestedEmployeeNumber;

        // A possible employee number has been entered
        if (employeeNumberVerifier.verify(s_SearchEmployeeNumberField) && !s_SearchEmployeeNumberField.getText().equals(""))
        {
            requestedEmployeeNumber = Integer.parseInt(s_SearchEmployeeNumberField.getText());
            resetSearch();
            
            // Employee is in the database
            if (hashTable.employeeExists(requestedEmployeeNumber))
            {
                // Displays generic employee info
                s_EmployeeNumberDisplay.setText(Integer.toString(hashTable.getEmployee(requestedEmployeeNumber).getEmpNumber()));
                s_SexCombo.setSelectedItem(hashTable.getEmployee(requestedEmployeeNumber).strIsMale());
                s_FirstNameField.setText(hashTable.getEmployee(requestedEmployeeNumber).getFirstName());
                s_LastNameField.setText(hashTable.getEmployee(requestedEmployeeNumber).getLastName());
                s_DeductionRateField.setText(formatMoney(hashTable.getEmployee(requestedEmployeeNumber).getDeductionRate()));

                // If employee is full, display info in format
                if (hashTable.getEmployee(requestedEmployeeNumber) instanceof FullTimeEmployee)
                {
                    FullTimeEmployee requestedFullEmployee = (FullTimeEmployee) hashTable.getEmployee(requestedEmployeeNumber);
                    s_EmploymentCombo.setSelectedItem("Full-Time");
                    s_AnnualSalaryField.setText(formatMoney(requestedFullEmployee.getAnnualSalary()));
                    s_AnnualNetIncomeDisplay.setText(formatMoney(requestedFullEmployee.getAnnualNetIncome()));
                }
                // If employee is part, display info in format
                else
                {
                    PartTimeEmployee requestedPartEmployee = (PartTimeEmployee) hashTable.getEmployee(requestedEmployeeNumber);
                    s_EmploymentCombo.setSelectedItem("Part-Time");
                    s_HourlyWageField.setText(formatMoney(requestedPartEmployee.getHourlyWage()));
                    s_HoursWeekField.setText(formatMoney(requestedPartEmployee.getHoursWeek()));
                    s_WeeksYearField.setText(formatMoney(requestedPartEmployee.getWeeksYear()));
                    s_AnnualNetIncomeDisplay.setText(formatMoney(requestedPartEmployee.getAnnualNetIncome()));
                }
          
                displayMessage("Employee found!", green);
                s_SearchEmployeeNumberField.setText("");
                s_SearchEmployeeNumberField.setBackground(Color.WHITE);
            }
            else
            {
                displayMessage("Employee does not exist!", red);
            }
        }
        else
        {
            displayMessage("Please enter a valid employee number.", red);
        }
    }//GEN-LAST:event_s_SearchEmployeeButtonActionPerformed

    private void displayMessage(String message, Color color)
    {
        confirmationDialog.setLocation(new Point((int) Math.round(mainWindow.getLocationOnScreen().getX()) + mainWindow.getBounds().width / 2 - 200, (int) Math.round(mainWindow.getLocationOnScreen().getY()) + mainWindow.getBounds().height / 2 - 75));
        c_Confirmation.setForeground(color);
        c_Confirmation.setText(message);
        confirmationDialog.setVisible(true);
    }

    // Checks the fields in the Add Part-Time Employee panel and adds an employee
    private void apt_AddEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apt_AddEmployeeButtonActionPerformed
        // Declare local variables and sets initial values
        boolean enoughInfo = true;
        String infoWarning = "<html>Not enough information has been provided. Please do the following: ";
        boolean male;
        boolean properInfo;

        // Gets the sex of the employee
        if (!"Male".equals(apt_SexCombo.getSelectedItem().toString()))
        {
            male = false;
        }
        else
        {
            male = true;
        }

        // Checks if the emplyee fields have been filled and if they have acceptable values
        if (empNum == 0)
        {
            enoughInfo = false;
            infoWarning += "generate an employee number, ";
        }

        if ("".equals(apt_FirstNameField.getText()))
        {
            enoughInfo = false;
            infoWarning += "enter a first name, ";
        }

        if ("".equals(apt_LastNameField.getText()))
        {
            enoughInfo = false;
            infoWarning += "enter a last name, ";
        }

        if ("".equals(apt_DeductionRateField.getText()) || !deductionRateVerifier.verify(apt_DeductionRateField))
        {
            enoughInfo = false;
            infoWarning += "enter a deduction rate, ";
        }

        if ("".equals(apt_HourlyWageField.getText()) || !hourlyWageVerifier.verify(apt_HourlyWageField))
        {
            enoughInfo = false;
            infoWarning += "enter an hourly wage, ";
        }

        if ("".equals(apt_HoursWeekField.getText()) || !hoursWeekVerifier.verify(apt_HoursWeekField))
        {
            enoughInfo = false;
            infoWarning += "enter the number of hours per week, ";
        }

        if ("".equals(apt_WeeksYearField.getText()) || !weeksYearVerifier.verify(apt_WeeksYearField))
        {
            enoughInfo = false;
            infoWarning += "enter the number of weeks per year, ";
        }

        // Prompts the user if the information entered is not enough
        if (enoughInfo == false)
        {
            infoWarning = infoWarning.substring(0, infoWarning.length() - 2);
            infoWarning += ".";
            displayMessage(infoWarning, red);
        }

        // Prompts the user if the information entered is the wrong format
        if (deductionRateVerifier.verify(apt_DeductionRateField) && hourlyWageVerifier.verify(apt_HourlyWageField) && hoursWeekVerifier.verify(apt_HoursWeekField) && weeksYearVerifier.verify(apt_WeeksYearField))
        {
            properInfo = true;
        }
        else
        {
            properInfo = false;
            infoWarning += "<br><br>Fields in red are not in the proper format or do not contain correct values.";
            displayMessage(infoWarning, red);
        }

        // Creates an employee object and adds the employee if fields are all filled properly
        if (enoughInfo == true && properInfo == true)
        {
            displayMessage("Employee has been succesfully added!", green);

            Employee newPartTimeEmployee = new PartTimeEmployee(empNum, male, apt_FirstNameField.getText(), apt_LastNameField.getText(), Double.parseDouble(apt_DeductionRateField.getText()), Double.parseDouble(apt_HourlyWageField.getText()), Double.parseDouble(apt_HoursWeekField.getText()), Double.parseDouble(apt_WeeksYearField.getText()));
            hashTable.addEmployee(newPartTimeEmployee);

            resetAPT();

            changesMade = true;
            
            // Updates table
            f_Table.setModel
            (new DefaultTableModel (createTableData(hashTable), titles));
        }
    }//GEN-LAST:event_apt_AddEmployeeButtonActionPerformed

    // Behaves in the same way as apt_AddEmployeeButtonActionPerformed, but with Full-Time Employee fields
    private void aft_AddEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aft_AddEmployeeButtonActionPerformed
        boolean enoughInfo = true;
        String infoWarning = "<html>Not enough information has been provided. Please do the following: ";
        boolean male;
        boolean properInfo;

        if (!"Male".equals(aft_SexCombo.getSelectedItem().toString()))
        {
            male = false;
        }
        else
        {
            male = true;
        }

        if (empNum == 0)
        {
            enoughInfo = false;
            infoWarning += "generate an employee number, ";
        }

        if ("".equals(aft_FirstNameField.getText()))
        {
            enoughInfo = false;
            infoWarning += "enter a first name, ";
        }

        if ("".equals(aft_LastNameField.getText()))
        {
            enoughInfo = false;
            infoWarning += "enter a last name, ";
        }

        if ("".equals(aft_DeductionRateField.getText()) || !deductionRateVerifier.verify(aft_DeductionRateField))
        {
            enoughInfo = false;
            infoWarning += "enter a deduction rate, ";
        }

        if ("".equals(aft_AnnualSalaryField.getText()) || !annualSalaryVerifier.verify(aft_AnnualSalaryField))
        {
            enoughInfo = false;
            infoWarning += "enter an annual salary, ";
        }

        // Sets a string to prompt the user if the information entered is enough
        if (enoughInfo == false)
        {
            infoWarning = infoWarning.substring(0, infoWarning.length() - 2);
            infoWarning += ".";
            displayMessage(infoWarning, red);
        }

        // Verifies all of the fields
        if (deductionRateVerifier.verify(aft_DeductionRateField) && annualSalaryVerifier.verify(aft_AnnualSalaryField))
        {
            properInfo = true;
        }
        else
        {
            properInfo = false;
            infoWarning += "<br><br>Fields in red are not in the proper format or do not contain correct values. Please correct these fields.";
            displayMessage(infoWarning, red);
        }

        // Goes through with adding employee if everything is fine
        if (enoughInfo == true && properInfo == true)
        {
            displayMessage("Employee has been succesfully added!", green);

            Employee newFullTimeEmployee = new FullTimeEmployee(empNum, male, aft_FirstNameField.getText(), aft_LastNameField.getText(), Double.parseDouble(aft_DeductionRateField.getText()), Double.parseDouble(aft_AnnualSalaryField.getText()));
            hashTable.addEmployee(newFullTimeEmployee);

            resetAFT();
            
            changesMade = true;
            
            f_Table.setModel
            (new DefaultTableModel (createTableData(hashTable), titles));
        }
    }//GEN-LAST:event_aft_AddEmployeeButtonActionPerformed

    // Saves the database
    private void apt_SaveDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_apt_SaveDatabaseButtonActionPerformed
    {//GEN-HEADEREND:event_apt_SaveDatabaseButtonActionPerformed
        hashTable.saveBucket();
        displayMessage("Successfully saved the database!", green);
        changesMade = false;
    }//GEN-LAST:event_apt_SaveDatabaseButtonActionPerformed

    // Cancels exiting the program without saving
    private void e_CancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_e_CancelButtonActionPerformed
    {//GEN-HEADEREND:event_e_CancelButtonActionPerformed
        exitDialog.setVisible(false);
    }//GEN-LAST:event_e_CancelButtonActionPerformed

    // Exits the program without saving
    private void e_DontSaveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_e_DontSaveButtonActionPerformed
    {//GEN-HEADEREND:event_e_DontSaveButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_e_DontSaveButtonActionPerformed

    // Checks if the user did not save changes and prompts the user if necessary
    private void WindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_WindowClosing
    {//GEN-HEADEREND:event_WindowClosing
        if (changesMade == true)
        {
            exitDialog.setLocation(new Point((int) Math.round(mainWindow.getLocationOnScreen().getX()) + mainWindow.getBounds().width / 2 - 250, (int) Math.round(mainWindow.getLocationOnScreen().getY()) + mainWindow.getBounds().height / 2 - 37));
            exitDialog.setVisible(true);
        }
        else
        {
            System.exit(1);
        }
    }//GEN-LAST:event_WindowClosing

    // Cancels deleting an employee
    private void d_NoDeleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_d_NoDeleteButtonActionPerformed
    {//GEN-HEADEREND:event_d_NoDeleteButtonActionPerformed
        // TODO add your handling code here:
        deleteDialog.setVisible(false);
    }//GEN-LAST:event_d_NoDeleteButtonActionPerformed

    // Deletes an employee
    private void d_YesDeleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_d_YesDeleteButtonActionPerformed
    {//GEN-HEADEREND:event_d_YesDeleteButtonActionPerformed
        hashTable.removeEmployee(Integer.parseInt(s_EmployeeNumberDisplay.getText()));
        changesMade = true;
        deleteDialog.setVisible(false);
        displayMessage("<html>Succesfully removed employee #" + s_EmployeeNumberDisplay.getText() + ".", green);
        resetSearch();
        f_Table.setModel
        (new DefaultTableModel (createTableData(hashTable), titles));
    }//GEN-LAST:event_d_YesDeleteButtonActionPerformed

    // Saves the database
    private void s_SaveDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_s_SaveDatabaseButtonActionPerformed
    {//GEN-HEADEREND:event_s_SaveDatabaseButtonActionPerformed
        hashTable.saveBucket();
        displayMessage("<html>Successfully saved the database!", green);
        changesMade = false;
    }//GEN-LAST:event_s_SaveDatabaseButtonActionPerformed

    // Modifies an existing employee
    private void s_ModifyEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_s_ModifyEmployeeButtonActionPerformed
    {//GEN-HEADEREND:event_s_ModifyEmployeeButtonActionPerformed
        // Uses same process as adding a new employee to create a new employee object that replaces the existing employee
        boolean enoughInfo = true;
        String infoWarning = "<html>Not enough information has been provided. Please do the following: ";
        boolean male;
        boolean properInfo;

        if (!s_EmployeeNumberDisplay.getText().equals("--"))
        {
            if (!"Male".equals(s_SexCombo.getSelectedItem().toString()))
            {
                male = false;
            }
            else
            {
                male = true;
            }

            if ("".equals(s_FirstNameField.getText()))
            {
                enoughInfo = false;
                infoWarning += "enter a first name, ";
            }

            if ("".equals(s_LastNameField.getText()))
            {
                enoughInfo = false;
                infoWarning += "enter a last name, ";
            }

            if ("".equals(s_DeductionRateField.getText()))
            {
                enoughInfo = false;
                infoWarning += "enter a deduction rate, ";
            }

            if (s_EmploymentCombo.getSelectedItem().equals("Part-Time"))
            {
                if ("".equals(s_HourlyWageField.getText()))
                {
                    enoughInfo = false;
                    infoWarning += "enter an hourly wage, ";
                }

                if ("".equals(s_HoursWeekField.getText()))
                {
                    enoughInfo = false;
                    infoWarning += "enter the number of hours per week, ";
                }

                if ("".equals(s_WeeksYearField.getText()))
                {
                    enoughInfo = false;
                    infoWarning += "enter the number of weeks per year, ";
                }

                // Sets a string to prompt the user if the information entered is enough
                if (enoughInfo == false)
                {
                    infoWarning = infoWarning.substring(0, infoWarning.length() - 2);
                    infoWarning += ".";
                    displayMessage(infoWarning, red);
                }
                else
                {
                    infoWarning = "<html>";
                }

                // Verifies all of the fields
                if (deductionRateVerifier.verify(s_DeductionRateField) && hourlyWageVerifier.verify(s_HourlyWageField) && hoursWeekVerifier.verify(s_HoursWeekField) && weeksYearVerifier.verify(s_WeeksYearField))
                {
                    properInfo = true;
                }
                else
                {
                    properInfo = false;
                    infoWarning += "<br><br>Fields in red are not in the proper format or do not contain correct values.";
                    displayMessage(infoWarning, red);
                }

                // Goes through with adding employee if everything is fine
                if (enoughInfo == true && properInfo == true)
                {
                    displayMessage("<html>Employee information has been successfully modified!", green);

                    Employee newPartTimeEmployee = new PartTimeEmployee(Integer.parseInt(s_EmployeeNumberDisplay.getText()), male, s_FirstNameField.getText(), s_LastNameField.getText(), Double.parseDouble(s_DeductionRateField.getText()), Double.parseDouble(s_HourlyWageField.getText()), Double.parseDouble(s_HoursWeekField.getText()), Double.parseDouble(s_WeeksYearField.getText()));
                    hashTable.replaceEmployee(newPartTimeEmployee);

                    // Clears the values used and their respective label/field
                    resetSearch();

                    // Notes a change has been made
                    changesMade = true;
                }
            }
            else
            {
                if ("".equals(s_AnnualSalaryField.getText()))
                {
                    enoughInfo = false;
                    infoWarning += "enter an annual salary, ";
                }

                // Sets a string to prompt the user if the information entered is enough
                if (enoughInfo == false)
                {
                    infoWarning = infoWarning.substring(0, infoWarning.length() - 2);
                    infoWarning += ".";
                }
                else
                {
                    infoWarning = "<html>";
                }

                // Verifies all of the fields
                if (deductionRateVerifier.verify(s_DeductionRateField) && annualSalaryVerifier.verify(s_AnnualSalaryField))
                {
                    properInfo = true;
                }
                else
                {
                    properInfo = false;
                    infoWarning += "<br><br>Fields in red are not in the proper format or do not contain correct values. Please correct these fields.";
                    displayMessage(infoWarning, red);

                }

                // Goes through with adding employee if everything is fine
                if (enoughInfo == true && properInfo == true)
                {
                    displayMessage("<html>Employee information has been succesfully modified!", green);

                    Employee newFullTimeEmployee = new FullTimeEmployee(Integer.parseInt(s_EmployeeNumberDisplay.getText()), male, s_FirstNameField.getText(), s_LastNameField.getText(), Double.parseDouble(s_DeductionRateField.getText()), Double.parseDouble(s_AnnualSalaryField.getText()));
                    hashTable.replaceEmployee(newFullTimeEmployee);

                    // Clears the values used and their respective label/field
                    resetSearch();

                    // Notes that a change has occured
                    changesMade = true;
                    
                    // Updates table
                    f_Table.setModel(new DefaultTableModel (createTableData(hashTable), titles));  
                }
            }
        }
        else
        {
            displayMessage("<html>You have not found an employee to modify. Find an employee and try again.", red);
        }
    }//GEN-LAST:event_s_ModifyEmployeeButtonActionPerformed

    // Changes visible fields when the user changes between a full-time and part-time employee
    private void s_EmploymentComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_s_EmploymentComboActionPerformed
    {//GEN-HEADEREND:event_s_EmploymentComboActionPerformed
        boolean isFullTime = s_EmploymentCombo.getSelectedItem().equals("Full-Time");
        
        s_AnnualSalaryField.setVisible(isFullTime);
        s_HourlyWageField.setVisible(!isFullTime);
        s_HoursWeekField.setVisible(!isFullTime);
        s_WeeksYearField.setVisible(!isFullTime);
        
        s_AnnualNetIncomeDisplay.setText("--");
    }//GEN-LAST:event_s_EmploymentComboActionPerformed

    // Saves the database
    private void aft_SaveDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aft_SaveDatabaseButtonActionPerformed
    {//GEN-HEADEREND:event_aft_SaveDatabaseButtonActionPerformed
        hashTable.saveBucket();
        displayMessage("Successfully saved the database!", green);
        changesMade = false;
    }//GEN-LAST:event_aft_SaveDatabaseButtonActionPerformed

    // Saves the database
    private void e_SaveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_e_SaveButtonActionPerformed
    {//GEN-HEADEREND:event_e_SaveButtonActionPerformed
        exitDialog.setVisible(false);
        hashTable.saveBucket();
        System.exit(1);
    }//GEN-LAST:event_e_SaveButtonActionPerformed

    // Returns data for displaying hashtable in a table
    public Object[][] createTableData(HashTable hashTable)
    {
        Object[][] output = new Object[hashTable.getNumItems()][11];
        Integer count = 0;
        Employee employee;

        for (int i = 0; i < hashTable.getNumBuckets(); i++)
        {
            for (int ii = 0; ii < hashTable.getTable().get(i).size(); ii++)
            {
                employee = hashTable.getTable().get(i).get(ii);

                output[count][0] = employee.getEmpNumber();
                output[count][2] = employee.strIsMale();
                output[count][3] = employee.getFirstName();
                output[count][4] = employee.getLastName();
                output[count][5] = employee.getDeductionRate();

                if (employee instanceof FullTimeEmployee)
                {

                    output[count][1] = "Full-Time";
                    output[count][6] = 0;
                    output[count][7] = 0;
                    output[count][8] = 0;
                    output[count][9] = Double.parseDouble(formatMoney(((FullTimeEmployee) employee).getAnnualSalary()));
                    output[count][10] = Double.parseDouble(formatMoney(((FullTimeEmployee) employee).getAnnualNetIncome()));
                }
                else
                {
                    output[count][1] = "Part-Time";
                    output[count][6] = Double.parseDouble(formatMoney(((PartTimeEmployee) employee).getHourlyWage()));
                    output[count][7] = Double.parseDouble(formatMoney(((PartTimeEmployee) employee).getHoursWeek()));
                    output[count][8] = Double.parseDouble(formatMoney(((PartTimeEmployee) employee).getWeeksYear()));
                    output[count][9] = 0;
                    output[count][10] = Double.parseDouble(formatMoney(((PartTimeEmployee) employee).getAnnualNetIncome()));
                }
                count ++;
            }
        }
        return output;
    }
    
    // Displays the entire database in a table
    private void s_ViewDataBaseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_s_ViewDataBaseActionPerformed
    {//GEN-HEADEREND:event_s_ViewDataBaseActionPerformed
        // Sets the model (data and titles) for the table
        f_Table.setModel
        (new DefaultTableModel (createTableData(hashTable), titles){
            Class[] types = { Integer.class, String.class, String.class,
                    String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class };

            // Sets the types of values for each column
            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
            
            // Makes the table non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
   }
        });
        
        // Sets the formatters for the cells
        f_Table.getColumnModel().getColumn(5).setCellRenderer(new DecimalFormatRenderer() );
        f_Table.getColumnModel().getColumn(6).setCellRenderer(new DecimalFormatRenderer() );
        f_Table.getColumnModel().getColumn(7).setCellRenderer(new DecimalFormatRenderer() );
        f_Table.getColumnModel().getColumn(8).setCellRenderer(new DecimalFormatRenderer() );
        f_Table.getColumnModel().getColumn(9).setCellRenderer(new DecimalFormatRenderer() );
        f_Table.getColumnModel().getColumn(10).setCellRenderer(new DecimalFormatRenderer() );
        
        // Creates a default sorter to sort the employees by each column
        f_Table.setAutoCreateRowSorter(true);
        
        fullViewDialog.setVisible(true);
    }//GEN-LAST:event_s_ViewDataBaseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addFullTimePanel;
    private javax.swing.JPanel addPartTimePanel;
    private javax.swing.JButton aft_AddEmployeeButton;
    private javax.swing.JLabel aft_AnnualSalary;
    private javax.swing.JTextField aft_AnnualSalaryField;
    private javax.swing.JLabel aft_DeductionRate;
    private javax.swing.JTextField aft_DeductionRateField;
    private javax.swing.JLabel aft_EmployeeNumber;
    private javax.swing.JLabel aft_FirstName;
    private javax.swing.JTextField aft_FirstNameField;
    private javax.swing.JButton aft_GenerateEmployeeNumberButton;
    private javax.swing.JLabel aft_LastName;
    private javax.swing.JTextField aft_LastNameField;
    private javax.swing.JButton aft_SaveDatabaseButton;
    private javax.swing.JLabel aft_Sex;
    private javax.swing.JComboBox aft_SexCombo;
    private javax.swing.JButton apt_AddEmployeeButton;
    private javax.swing.JLabel apt_DeductionRate;
    private javax.swing.JTextField apt_DeductionRateField;
    private javax.swing.JLabel apt_EmployeeNumber;
    private javax.swing.JLabel apt_FirstName;
    private javax.swing.JTextField apt_FirstNameField;
    private javax.swing.JButton apt_GenerateEmployeeNumberButton;
    private javax.swing.JLabel apt_HourlyWage;
    private javax.swing.JTextField apt_HourlyWageField;
    private javax.swing.JLabel apt_HoursWeek;
    private javax.swing.JTextField apt_HoursWeekField;
    private javax.swing.JLabel apt_LastName;
    private javax.swing.JTextField apt_LastNameField;
    private javax.swing.JLabel apt_NotEnoughInfoWarning;
    private javax.swing.JButton apt_SaveDatabaseButton;
    private javax.swing.JLabel apt_Sex;
    private javax.swing.JComboBox apt_SexCombo;
    private javax.swing.JLabel apt_WeeksYear;
    private javax.swing.JTextField apt_WeeksYearField;
    private javax.swing.JLabel c_Confirmation;
    private javax.swing.JDialog confirmationDialog;
    private javax.swing.JLabel d_AskForDelete;
    private javax.swing.JButton d_NoDeleteButton;
    private javax.swing.JButton d_YesDeleteButton;
    private javax.swing.JDialog deleteDialog;
    private javax.swing.JLabel e_AskForSave;
    private javax.swing.JButton e_CancelButton;
    private javax.swing.JButton e_DontSaveButton;
    private javax.swing.JButton e_SaveButton;
    private javax.swing.JDialog exitDialog;
    private javax.swing.JScrollPane f_Panel;
    private javax.swing.JTable f_Table;
    private javax.swing.JDialog fullViewDialog;
    private javax.swing.JTabbedPane mainWindow;
    private javax.swing.JLabel s_AnnualNetIncome;
    private javax.swing.JLabel s_AnnualNetIncomeDisplay;
    private javax.swing.JLabel s_AnnualSalary;
    private javax.swing.JTextField s_AnnualSalaryField;
    private javax.swing.JLabel s_DeductionRate;
    private javax.swing.JTextField s_DeductionRateField;
    private javax.swing.JLabel s_EmployeeNumber;
    private javax.swing.JLabel s_EmployeeNumberDisplay;
    private javax.swing.JLabel s_Employment;
    private javax.swing.JComboBox s_EmploymentCombo;
    private javax.swing.JLabel s_FirstName;
    private javax.swing.JTextField s_FirstNameField;
    private javax.swing.JLabel s_HourlyWage;
    private javax.swing.JTextField s_HourlyWageField;
    private javax.swing.JLabel s_HoursWeek;
    private javax.swing.JTextField s_HoursWeekField;
    private javax.swing.JLabel s_LastName;
    private javax.swing.JTextField s_LastNameField;
    private javax.swing.JButton s_ModifyEmployeeButton;
    private javax.swing.JButton s_RemoveEmployeeButton;
    private javax.swing.JButton s_SaveDatabaseButton;
    private javax.swing.JButton s_SearchEmployeeButton;
    private javax.swing.JLabel s_SearchEmployeeNumber;
    private javax.swing.JTextField s_SearchEmployeeNumberField;
    private javax.swing.JLabel s_Sex;
    private javax.swing.JComboBox s_SexCombo;
    private javax.swing.JButton s_ViewDataBase;
    private javax.swing.JLabel s_WeeksYear;
    private javax.swing.JTextField s_WeeksYearField;
    private javax.swing.JPanel searchPanel;
    // End of variables declaration//GEN-END:variables
}

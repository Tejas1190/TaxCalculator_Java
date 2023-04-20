import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaxCalculator extends JFrame implements ActionListener {
    private JRadioButton oldRegimeRadioButton, newRegimeRadioButton;
    private JTextField incomeField, taxField;
    private JButton calculateButton;

    public TaxCalculator() {
        // Set up the frame
        setTitle("Tax Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the components
        oldRegimeRadioButton = new JRadioButton("Old Regime");
        oldRegimeRadioButton.addActionListener(this);

        newRegimeRadioButton = new JRadioButton("New Regime");
        newRegimeRadioButton.addActionListener(this);

        ButtonGroup regimeButtonGroup = new ButtonGroup();
        regimeButtonGroup.add(oldRegimeRadioButton);
        regimeButtonGroup.add(newRegimeRadioButton);

        incomeField = new JTextField(10);
        taxField = new JTextField(10);
        taxField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Add the components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Income:"));
        panel.add(incomeField);
        panel.add(new JLabel("Tax:"));
        panel.add(taxField);
        panel.add(oldRegimeRadioButton);
        panel.add(newRegimeRadioButton);
        add(panel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double income = Double.parseDouble(incomeField.getText());

        // Calculate the tax based on the selected regime
        double tax = (oldRegimeRadioButton.isSelected())
                ? calculateOldRegimeTax(income)
                : calculateNewRegimeTax(income);

        taxField.setText(Double.toString(tax));
    }

    private double calculateOldRegimeTax(double income) {
        // Calculate the tax based on the old regime rules
        double tax = 0;
        tax += Math.min(250000, Math.max(0, income)) * 0.0;
        tax += Math.min(300000, Math.max(0, income - 250000)) * 0.05;
        tax += Math.min(500000, Math.max(0, income - 300000)) * 0.05;
        tax += Math.min(600000, Math.max(0, income - 500000)) * 0.1;
        tax += Math.min(750000, Math.max(0, income - 600000)) * 0.1;
        tax += Math.min(900000, Math.max(0, income - 750000)) * 0.15;
        tax += Math.min(1000000, Math.max(0, income - 900000)) * 0.15;
        tax += Math.min(1200000, Math.max(0, income - 1000000)) * 0.20;
        tax += Math.min(1250000, Math.max(0, income - 1200000)) * 0.20;
        tax += Math.min(1500000, Math.max(0, income - 1250000)) * 0.25;
        tax += Math.min(income, Math.max(0, income - 1500000)) * 0.3;
        return tax;
    }

    private double calculateNewRegimeTax(double income) {
        // Calculate the tax based on the old regime rules
        double tax = 0;
        tax += Math.min(250000, Math.max(0, income)) * 0.0;
        tax += Math.min(300000, Math.max(0, income - 250000)) * 0.0;
        tax += Math.min(500000, Math.max(0, income - 300000)) * 0.05;
        tax += Math.min(600000, Math.max(0, income - 500000)) * 0.05;
        tax += Math.min(750000, Math.max(0, income - 600000)) * 0.1;
        tax += Math.min(900000, Math.max(0, income - 750000)) * 0.1;
        tax += Math.min(1000000, Math.max(0, income - 900000)) * 0.15;
        tax += Math.min(1200000, Math.max(0, income - 1000000)) * 0.15;
        tax += Math.min(1250000, Math.max(0, income - 1200000)) * 0.20;
        tax += Math.min(1500000, Math.max(0, income - 1250000)) * 0.20;
        tax += Math.min(income, Math.max(0, income - 1500000)) * 0.3;
        return tax;
    }


    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
    }
}
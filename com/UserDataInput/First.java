import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;
public class First extends JFrame
{

    public String getCSVString(ArrayList<String> list) {

        // TODO - Add some validations here
        StringJoiner joiner = new StringJoiner(",");
        list.forEach(item -> joiner.add(item.toString()));
        String data = joiner.toString();
        data = data + "\n";
        return data;
    }

    private JPanel main_panel;
    private JLabel name_label, account_numer_label, label2,label3,label4,label5,label6,label7,label8,label9,lb;
    private JTextField ben_name_field, ben_account_number_field, ifsc, transaction_type, debit_account_number, transaction_date, amount, currency, emailId, remarks;
    private JButton submit_button;

    public First()
    {
        // Setting properties of main panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        setLayout(new FlowLayout());
        main_panel = new JPanel();
        main_panel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(main_panel);
        main_panel.setLayout(null);


        // Create Labels for the fields where data has to be added
        name_label = new JLabel("Beneficiary Name");

        // This functions takes in x-coordinate, y-cordinate, width and height. So you can make adjustments to other fields based on this.
        name_label.setBounds(50, 100, 175, 25);
        main_panel.add(name_label);


        account_numer_label = new JLabel("Benefeciary Acc. No.");
        account_numer_label.setBounds(400, 100, 175, 25);
        main_panel.add(account_numer_label);

        // Create input fields to allow user to enter data.
        ben_name_field = new JTextField();
        ben_name_field.setBounds(175, 100, 175, 25);
        main_panel.add(ben_name_field);
        ben_name_field.setColumns(8);

        ben_account_number_field = new JTextField();
        ben_account_number_field.setBounds(525, 100, 175, 25);
        main_panel.add(ben_account_number_field);
        ben_account_number_field.setColumns(18);

        submit_button = new JButton("Save Data");
        submit_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                ArrayList<String> data = new ArrayList<String>();
                data.add(ben_name_field.getText());
                data.add(ben_account_number_field.getText());

                String data_for_file = getCSVString(data);

                FileWriter stream;
                try {
                    stream = new FileWriter("../resources/file.txt", true);
                    BufferedWriter out = new BufferedWriter(stream);
                    out.write(data_for_file);
                    out.close();
                } catch (IOException e1) {
                    System.out.println("Unable to add to file. Encountered error - " + e1.getMessage());
                }
            }
            
        });
        submit_button.setBounds(350, 150, 175, 25);
        main_panel.add(submit_button);
    }
    public static void main(String[] args) {

        First gui = new First();
        gui.setVisible(true);
    }
}
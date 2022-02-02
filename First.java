package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class First extends JFrame
{
    JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,lb;
    JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JButton button;

    public First()
    {
        setLayout(new FlowLayout());

        label = new JLabel("beneficiary name");
        add(label);
        tf = new JTextField(10);
        add(tf);

        label1 = new JLabel("ben. acc no");
        add(label1);
        tf1 = new JTextField(10);
        add(tf1);

        label2 = new JLabel("IFSC");
        add(label2);
        tf2 = new JTextField(10);
        add(tf2);

        label3 = new JLabel("Transaction type");
        add(label3);
        tf3 = new JTextField(10);
        add(tf3);

        label4 = new JLabel("Debit Acc No");
        add(label4);
        tf4 = new JTextField(10);
        add(tf4);

        label5 = new JLabel("Transaction Date");
        add(label5);
        tf5 = new JTextField(10);
        add(tf5);

        label6 = new JLabel("Amount");
        add(label6);
        tf6 = new JTextField(10);
        add(tf6);

        label7 = new JLabel("Currency");
        add(label7);
        tf7 = new JTextField(10);
        add(tf7);

        label8 = new JLabel("Email ID");
        add(label8);
        tf8 = new JTextField(10);
        add(tf8);

        label9 = new JLabel("remarks");
        add(label9);
        tf9 = new JTextField(10);
        add(tf9);

        button = new JButton("write to file");
        add(button);

        event e = new event();
        button.addActionListener(e);
    }

    public class event implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
                String word = tf.getText();
                FileWriter stream = new FileWriter("C:\\Users\\ROHIT KASAT\\OneDrive\\Desktop\\Family\\file");
                BufferedWriter out = new BufferedWriter(stream);
                out.write(word);
                out.close();
            }catch(Exception ex) {}
        }


    }
    public static void main(String[] args) {

        First gui = new First();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,150);
        gui.setTitle("writer");
        gui.setVisible(true);


    }
}
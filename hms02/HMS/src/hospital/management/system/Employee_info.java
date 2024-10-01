package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,460);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,50,600,300);
        panel.setBackground(new Color(60, 100, 130));
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from emp_information";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Adding column headers
        JLabel label1 = new JLabel("Name");
        label1.setBounds(10, 20, 80, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(110, 20, 80, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Employee ID");
        label3.setBounds(210, 20, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Phone");
        label4.setBounds(330, 20, 80, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Email");
        label5.setBounds(430, 20, 80, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar");
        label6.setBounds(530, 20, 80, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 360, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();
            }
        });

        setUndecorated(true);
        setSize(850,470);
        setLayout(null);
        setLocation(260,193);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application closes when the frame is closed
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
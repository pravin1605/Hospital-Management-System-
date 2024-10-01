package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Patient_info extends JFrame {

    Patient_info() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 460);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 60, 820, 300);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(new Color(60, 100, 130));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Column headers
        JLabel label1 = new JLabel("Patient ID");
        label1.setBounds(10, 20, 100, 30);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(120, 20, 100, 30);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(230, 20, 100, 30);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(330, 20, 100, 30);
        label4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(420, 20, 120, 30);
        label5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Time");
        label6.setBounds(550, 20, 100, 30);
        label6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JLabel label7 = new JLabel("Deposit");
        label7.setBounds(620, 20, 100, 30);
        label7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel label8 = new JLabel("Room");
        label8.setBounds(730, 20, 100, 30);
        label8.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(360, 380, 120, 40);
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(backButton);

        backButton.addActionListener(e -> {
            dispose();
        });

        setUndecorated(true);
        setSize(850, 470);
        setLayout(null);
        setLocation(260, 193);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Patient_info();
    }
}

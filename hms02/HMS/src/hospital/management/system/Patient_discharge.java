package hospital.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {

    Patient_discharge() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 460);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new LineBorder(Color.WHITE, 2));
        panel.add(label);

        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(30, 80, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30, 130, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel Room_no = new JLabel();
        Room_no.setBounds(200, 130, 150, 20);
        Room_no.setFont(new Font("Tahoma", Font.BOLD, 15));
        Room_no.setForeground(Color.WHITE);
        panel.add(Room_no);

        JLabel label3 = new JLabel("In-Time");
        label3.setBounds(30, 180, 250, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel InTime = new JLabel();
        InTime.setBounds(200, 180, 150, 20);
        InTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        InTime.setForeground(Color.WHITE);
        panel.add(InTime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30, 230, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        Date date = new Date();
        JLabel outTime = new JLabel("" + date);
        outTime.setBounds(200, 230, 250, 20);
        outTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);

        JButton Discharge = new JButton("Discharge");
        Discharge.setBounds(60, 300, 120, 30);
        Discharge.setBackground(Color.BLACK);
        Discharge.setForeground(Color.WHITE);
        panel.add(Discharge);
        Discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    String selectedNumber = choice.getSelectedItem();
                    String roomNo = Room_no.getText();
                    c.statement.executeUpdate("delete from patient_info where number ='" + selectedNumber + "'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no ='" + roomNo + "'");
                    JOptionPane.showMessageDialog(null, "Done Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(190, 300, 120, 30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    String selectedNumber = choice.getSelectedItem();
                    ResultSet resultSet = c.statement.executeQuery("select Room_Number, Time from patient_info where number ='" + selectedNumber + "'");
                    while (resultSet.next()) {
                        Room_no.setText(resultSet.getString("Room_Number"));
                        InTime.setText(resultSet.getString("Time"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(320, 300, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850, 470);
        setLayout(null);
        setLocation(260, 193);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Patient_discharge();
    }
}

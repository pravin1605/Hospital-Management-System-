package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1263, 500);
        panel.setBackground(new Color(224, 247, 250)); // Peaceful light blue
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1263, 150);
        panel1.setBackground(new Color(200, 230, 201)); // Peaceful light green
        add(panel1);

        // Image icon
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/portrait-3d-male-doctor.jpg"));
        Image i1 = image1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(1050, 0, 150, 150);
        panel1.add(label);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("icon/3135.jpg"));
        Image i2 = image2.getImage().getScaledInstance(350, 150, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon2);
        label1.setBounds(750, 0, 350, 150);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30, 15, 150, 30);
        btn1.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 150, 30);
        btn2.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 150, 30);
        btn3.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Information");
        btn4.setBounds(200, 15, 150, 30);
        btn4.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient INFO");
        btn5.setBounds(200, 58, 150, 30);
        btn5.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(200, 100, 150, 30);
        btn6.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(370, 15, 150, 30);
        btn7.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btn8 = new JButton("Ambulance");
        btn8.setBounds(370, 58, 150, 30);
        btn8.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(370, 100, 150, 30);
        btn9.setBackground(new Color(129, 212, 250)); // Peaceful light blue
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(540, 15, 150, 30);
        btn10.setBackground(new Color(246, 215, 118)); // Slightly different color for emphasis
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(1950, 1100);
        getContentPane().setBackground(new Color(253, 245, 230)); // Light cream background
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}

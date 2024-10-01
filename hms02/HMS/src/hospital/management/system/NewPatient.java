package hospital.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2, r3;
    JButton b1, b2;
    JLabel date;
    Choice c1;

    NewPatient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 460);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient_2764517.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelHeadName = new JLabel("New Patient Form");
        labelHeadName.setBounds(118, 11, 260, 53);
        labelHeadName.setFont(new Font("Segoe UI", Font.BOLD, 24));
        labelHeadName.setForeground(Color.WHITE);
        panel.add(labelHeadName);

        JLabel labelID = new JLabel("ID");
        labelID.setBounds(35, 76, 200, 15);
        labelID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"Aadhar card", "Voter Id", "Driving Licence"});
        comboBox.setBounds(210, 73, 150, 25);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("ID Number");
        labelNumber.setBounds(35, 111, 200, 15);
        labelNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(210, 111, 150, 25);
        textFieldNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("Patient Name");
        labelName.setBounds(35, 151, 200, 15);
        labelName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        textName = new JTextField();
        textName.setBounds(210, 151, 150, 25);
        textName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(35, 191, 200, 15);
        labelGender.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(60, 100, 130));
        r1.setBounds(210, 191, 80, 25);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(60, 100, 130));
        r2.setBounds(290, 191, 80, 25);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        r3.setForeground(Color.WHITE);
        r3.setBackground(new Color(60, 100, 130));
        r3.setBounds(370, 191, 80, 25);
        panel.add(r3);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        genderGroup.add(r3);

        JLabel labelDisease = new JLabel("Disease");
        labelDisease.setBounds(35, 231, 200, 15);
        labelDisease.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(210, 231, 150, 25);
        textFieldDisease.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room");
        labelRoom.setBounds(35, 271, 150, 15);
        labelRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(210, 271, 150, 25);
        c1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.WHITE);
        panel.add(c1);

        JLabel labelDate = new JLabel("Date");
        labelDate.setBounds(35, 311, 200, 15);
        labelDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(210, 311, 250, 25);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposit");
        labelDeposite.setBounds(35, 351, 200, 15);
        labelDeposite.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(210, 351, 150, 25);
        textFieldDeposite.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100, 410, 120, 30);
        b1.setBackground(new Color(0, 102, 204));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setBorder(new LineBorder(Color.WHITE));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 410, 120, 30);
        b2.setBackground(new Color(0, 102, 204));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setBorder(new LineBorder(Color.WHITE));
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850, 470);
        setLayout(null);
        setLocation(260, 193);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            } else if (r3.isSelected()) {
                radioBTN = "Other";
            } else {
                // Optional: Handle the case where no radio button is selected
                radioBTN = "None";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                String q = "insert into patient_info values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + s4 + "' )";
                String q1 = "update room set Availability = 'Occupied' Where room_no= '" + s6 + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewPatient();
    }
}

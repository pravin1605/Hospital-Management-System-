package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 440);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/3135.jpg"));
        Image i1 = image1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 200, 200, 200);
        panel.add(label);

        table = new JTable();
        table.setBounds(10, 60, 500, 300);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(new Color(60, 100, 130));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12, 20, 80, 30);
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140, 20, 100, 30);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(260, 20, 80, 30);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(380, 20, 100, 30);
        label4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(10, 380, 120, 40);
        back.setBackground(new Color(0, 102, 204));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850, 450);
        setLayout(null);
        setLocation(260, 193);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Room();
    }
}

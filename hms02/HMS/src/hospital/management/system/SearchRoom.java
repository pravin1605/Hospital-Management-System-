package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;
    JScrollPane scrollPane;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 440);
        panel.setBackground(new Color(60, 100, 130));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Search For Room");
        title.setBounds(250, 11, 186, 31);
        title.setForeground(Color.white);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(title);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(70, 70, 80, 20);
        statusLabel.setForeground(Color.white);
        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(statusLabel);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBackground(Color.white);
        table.setForeground(new Color(60, 100, 130));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(new Color(60, 100, 130));

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 150, 820, 230);
        panel.add(scrollPane);

        loadInitialData();

        JLabel roomnoLabel = new JLabel("Room Number");
        roomnoLabel.setBounds(23, 120, 150, 20);
        roomnoLabel.setForeground(Color.white);
        roomnoLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(roomnoLabel);

        JLabel availableLabel = new JLabel("Availability");
        availableLabel.setBounds(175, 120, 150, 20);
        availableLabel.setForeground(Color.white);
        availableLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(availableLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(358, 120, 150, 20);
        priceLabel.setForeground(Color.white);
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(priceLabel);

        JLabel bedLabel = new JLabel("Bed Type");
        bedLabel.setBounds(500, 120, 150, 20);
        bedLabel.setForeground(Color.white);
        bedLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(bedLabel);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(200, 400, 120, 30);
        searchButton.setBackground(new Color(0, 102, 204));
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRooms();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(380, 400, 120, 30);
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850, 453);
        setLayout(null);
        setLocation(260, 193);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadInitialData() {
        try {
            conn c = new conn();
            String query = "SELECT * FROM room";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchRooms() {
        String status = choice.getSelectedItem();
        String query = "SELECT * FROM room WHERE Availability = '" + status + "'";
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}

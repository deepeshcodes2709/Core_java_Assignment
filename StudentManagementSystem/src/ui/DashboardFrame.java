package ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    JButton btnAdd, btnView, btnUpdate, btnDelete, btnLogout;

    public DashboardFrame() {

        setTitle("Dashboard");

        setSize(400,400);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd = new JButton("Add Student");
        btnAdd.setBounds(100,40,180,35);
        add(btnAdd);
        btnAdd.addActionListener(e->{

            new AddStudentFrame();

        });

        btnView = new JButton("View Students");
        btnView.setBounds(100,90,180,35);
        add(btnView);
        btnView.addActionListener(e->{

            new ViewStudentFrame();

        });

        btnUpdate = new JButton("Update Student");
        btnUpdate.setBounds(100,140,180,35);
        add(btnUpdate);
        btnUpdate.addActionListener(e -> {

            new UpdateStudentFrame();

        });

        btnDelete = new JButton("Delete Student");
        btnDelete.setBounds(100,190,180,35);
        add(btnDelete);
        btnDelete.addActionListener(e -> {

            new DeleteStudentFrame();

        });

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(100,240,180,35);
        add(btnLogout);
        btnLogout.addActionListener(e -> {

            dispose();

            new LoginFrame();

        });

        btnLogout.addActionListener(e->{

            dispose();

            new LoginFrame();

        });

        setVisible(true);

    }

}
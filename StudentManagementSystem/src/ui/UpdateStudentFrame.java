package ui;

import javax.swing.*;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

public class UpdateStudentFrame extends JFrame {

    JLabel lblId, lblName, lblEmail, lblPassword;

    JTextField txtId, txtName, txtEmail;

    JPasswordField txtPassword;

    JButton btnUpdate, btnClear;

    public UpdateStudentFrame() {

        setTitle("Update Student");
        setSize(450,420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblId = new JLabel("Student ID");
        lblId.setBounds(40,40,100,25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150,40,200,25);
        add(txtId);

        lblName = new JLabel("Name");
        lblName.setBounds(40,90,100,25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150,90,200,25);
        add(txtName);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(40,140,100,25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150,140,200,25);
        add(txtEmail);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(40,190,100,25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150,190,200,25);
        add(txtPassword);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(70,280,120,35);
        add(btnUpdate);

        btnClear = new JButton("Clear");
        btnClear.setBounds(220,280,120,35);
        add(btnClear);

        btnUpdate.addActionListener(e -> {

            try {

                Student s = new Student();

                s.setId(Integer.parseInt(txtId.getText()));
                s.setName(txtName.getText());
                s.setEmail(txtEmail.getText());
                s.setPassword(String.valueOf(txtPassword.getPassword()));

                StudentDao dao = new StudentDaoImpl();

                if (dao.updateStudent(s)) {

                    JOptionPane.showMessageDialog(this,
                            "Student Updated Successfully");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Student ID Not Found");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());

            }

        });

        btnClear.addActionListener(e -> {

            txtId.setText("");
            txtName.setText("");
            txtEmail.setText("");
            txtPassword.setText("");

        });

        setVisible(true);

    }

}
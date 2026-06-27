package ui;

import javax.swing.*;

import dao.StudentDao;
import dao.StudentDaoImpl;
import exception.InvalidInputException;
import model.Student;

public class SignUpFrame extends JFrame {

    JLabel lblTitle, lblName, lblEmail, lblPassword;

    JTextField txtName, txtEmail;

    JPasswordField txtPassword;

    JButton btnRegister, btnClear;

    public SignUpFrame() {

        setTitle("Student Registration");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        lblTitle = new JLabel("Student Registration");
        lblTitle.setBounds(160, 20, 200, 30);
        add(lblTitle);

        // Name
        lblName = new JLabel("Name");
        lblName.setBounds(50, 80, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(170, 80, 220, 25);
        add(txtName);

        // Email
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 130, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(170, 130, 220, 25);
        add(txtEmail);

        // Password
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 180, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 180, 220, 25);
        add(txtPassword);

        // Register Button
        btnRegister = new JButton("Register");
        btnRegister.setBounds(80, 260, 130, 35);
        add(btnRegister);

        // Clear Button
        btnClear = new JButton("Clear");
        btnClear.setBounds(250, 260, 130, 35);
        add(btnClear);

        // Register Button Action
        btnRegister.addActionListener(e -> {

            try {

                String name = txtName.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());

                // Validation
                if (name.isEmpty())
                    throw new InvalidInputException("Name cannot be empty");

                if (!email.contains("@"))
                    throw new InvalidInputException("Invalid Email");

                if (password.length() < 8)
                    throw new InvalidInputException("Password must contain at least 8 characters");

                Student student = new Student();

                student.setName(name);
                student.setEmail(email);
                student.setPassword(password);

                StudentDao dao = new StudentDaoImpl();

                boolean status = dao.registerStudent(student);

                if (status) {

                    JOptionPane.showMessageDialog(this,
                            "Registration Successful!");

                    txtName.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Registration Failed!");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());

            }

        });

        // Clear Button Action
        btnClear.addActionListener(e -> {

            txtName.setText("");
            txtEmail.setText("");
            txtPassword.setText("");

        });

        setVisible(true);
    }

}
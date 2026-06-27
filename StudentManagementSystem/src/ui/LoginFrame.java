package ui;

import javax.swing.*;

import dao.StudentDao;
import dao.StudentDaoImpl;
import exception.AuthenticationFailedException;

public class LoginFrame extends JFrame {

    JLabel lblTitle, lblEmail, lblPassword;

    JTextField txtEmail;

    JPasswordField txtPassword;

    JButton btnLogin, btnClear;

    public LoginFrame() {

        setTitle("Student Login");
        setSize(450, 320);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitle = new JLabel("Student Login");
        lblTitle.setBounds(170, 20, 150, 30);
        add(lblTitle);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 80, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 80, 220, 25);
        add(txtEmail);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 130, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 130, 220, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(70, 200, 120, 35);
        add(btnLogin);

        btnClear = new JButton("Clear");
        btnClear.setBounds(230, 200, 120, 35);
        add(btnClear);

        // Login Button

        btnLogin.addActionListener(e -> {

            try {

                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());

                StudentDao dao = new StudentDaoImpl();

                if (dao.loginStudent(email, password)) {

                    JOptionPane.showMessageDialog(this,
                            "Login Successful");

                    dispose();

                    new DashboardFrame();

                }

            } catch (AuthenticationFailedException ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());

            }

        });

        btnClear.addActionListener(e -> {

            txtEmail.setText("");
            txtPassword.setText("");

        });

        setVisible(true);

    }

}
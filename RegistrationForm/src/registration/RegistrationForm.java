package registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener {

    JLabel lblTitle, lblName, lblEmail, lblMobile, lblGender, lblAddress, lblUsername, lblPassword;

    JTextField txtName, txtEmail, txtMobile, txtUsername;

    JPasswordField txtPassword;

    JTextArea txtAddress;

    JRadioButton rbMale, rbFemale;

    ButtonGroup bg;

    JButton btnRegister, btnClear;

    public RegistrationForm() {

        setTitle("Student Registration Form");
        setSize(550, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitle = new JLabel("Student Registration Form");
        lblTitle.setBounds(150, 20, 250, 30);
        add(lblTitle);

        lblName = new JLabel("Full Name");
        lblName.setBounds(50, 70, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(170, 70, 250, 25);
        add(txtName);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 110, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(170, 110, 250, 25);
        add(txtEmail);

        lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(50, 150, 100, 25);
        add(lblMobile);

        txtMobile = new JTextField();
        txtMobile.setBounds(170, 150, 250, 25);
        add(txtMobile);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(50, 190, 100, 25);
        add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(170, 190, 80, 25);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(260, 190, 100, 25);
        add(rbFemale);

        bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        lblAddress = new JLabel("Address");
        lblAddress.setBounds(50, 230, 100, 25);
        add(lblAddress);

        txtAddress = new JTextArea();
        txtAddress.setBounds(170, 230, 250, 70);
        add(txtAddress);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 330, 100, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(170, 330, 250, 25);
        add(txtUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 370, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 370, 250, 25);
        add(txtPassword);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(120, 450, 120, 35);
        add(btnRegister);

        btnClear = new JButton("Clear");
        btnClear.setBounds(280, 450, 120, 35);
        add(btnClear);

        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegister) {

            String name = txtName.getText();
            String email = txtEmail.getText();
            String mobile = txtMobile.getText();
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String address = txtAddress.getText();

            String gender = "";

            if (rbMale.isSelected())
                gender = "Male";
            else if (rbFemale.isSelected())
                gender = "Female";

            if (name.isEmpty() || email.isEmpty() || mobile.isEmpty()
                    || username.isEmpty() || password.isEmpty()
                    || address.isEmpty() || gender.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            if (!Validation.isValidEmail(email)) {

                JOptionPane.showMessageDialog(this, "Invalid Email");
                return;

            }

            if (!Validation.isValidMobile(mobile)) {

                JOptionPane.showMessageDialog(this, "Mobile Number must contain exactly 10 digits.");
                return;

            }

            if (!Validation.isValidPassword(password)) {

                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters.");
                return;

            }

            String message = "Registration Details\n\n";

            message += "Full Name : " + name + "\n";
            message += "Email : " + email + "\n";
            message += "Mobile : " + mobile + "\n";
            message += "Gender : " + gender + "\n";
            message += "Address : " + address + "\n";
            message += "Username : " + username;

            JOptionPane.showMessageDialog(this, message);

            JOptionPane.showMessageDialog(this, "Registration Successful!");

        }

        if (e.getSource() == btnClear) {

            txtName.setText("");
            txtEmail.setText("");
            txtMobile.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
            txtAddress.setText("");

            bg.clearSelection();

        }

    }

}
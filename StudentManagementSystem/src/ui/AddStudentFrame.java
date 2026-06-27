package ui;

import javax.swing.*;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

public class AddStudentFrame extends JFrame {

    JLabel lblName, lblEmail, lblPassword;

    JTextField txtName, txtEmail;

    JPasswordField txtPassword;

    JButton btnAdd, btnClear;

    public AddStudentFrame() {

        setTitle("Add Student");
        setSize(450,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblName = new JLabel("Name");
        lblName.setBounds(40,50,100,25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150,50,200,25);
        add(txtName);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(40,100,100,25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150,100,200,25);
        add(txtEmail);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(40,150,100,25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150,150,200,25);
        add(txtPassword);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(70,230,120,35);
        add(btnAdd);

        btnClear = new JButton("Clear");
        btnClear.setBounds(220,230,120,35);
        add(btnClear);

        btnAdd.addActionListener(e->{

            try{

                Student s = new Student();

                s.setName(txtName.getText());
                s.setEmail(txtEmail.getText());
                s.setPassword(String.valueOf(txtPassword.getPassword()));

                StudentDao dao = new StudentDaoImpl();

                if(dao.addStudent(s)){

                    JOptionPane.showMessageDialog(this,"Student Added Successfully");

                    txtName.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");

                }

            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(this,ex.getMessage());

            }

        });

        btnClear.addActionListener(e->{

            txtName.setText("");
            txtEmail.setText("");
            txtPassword.setText("");

        });

        setVisible(true);

    }

}
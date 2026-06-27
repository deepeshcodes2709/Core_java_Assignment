package ui;

import javax.swing.*;

import dao.StudentDao;
import dao.StudentDaoImpl;

public class DeleteStudentFrame extends JFrame {

    JLabel lblId;

    JTextField txtId;

    JButton btnDelete, btnClear;

    public DeleteStudentFrame() {

        setTitle("Delete Student");
        setSize(400,250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblId = new JLabel("Student ID");
        lblId.setBounds(40,50,100,25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150,50,180,25);
        add(txtId);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(60,120,110,35);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(200,120,110,35);
        add(btnClear);

        btnDelete.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtId.getText());

                StudentDao dao = new StudentDaoImpl();

                if (dao.deleteStudent(id)) {

                    JOptionPane.showMessageDialog(this,
                            "Student Deleted Successfully");

                    txtId.setText("");

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

        });

        setVisible(true);

    }

}
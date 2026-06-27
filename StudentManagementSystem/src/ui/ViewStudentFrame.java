package ui;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewStudentFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewStudentFrame() {

        setTitle("View Students");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Password");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        add(sp);

        try {

            StudentDao dao = new StudentDaoImpl();

            List<Student> list = dao.getAllStudents();

            for(Student s : list){

                model.addRow(new Object[]{

                        s.getId(),
                        s.getName(),
                        s.getEmail(),
                        s.getPassword()

                });

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,e.getMessage());

        }

        setVisible(true);

    }

}
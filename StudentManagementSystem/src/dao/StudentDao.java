package dao;

import java.util.List;
import model.Student;

public interface StudentDao {

    boolean registerStudent(Student student) throws Exception;

    boolean loginStudent(String email, String password) throws Exception;

    boolean addStudent(Student student) throws Exception;

    boolean updateStudent(Student student) throws Exception;

    boolean deleteStudent(int id) throws Exception;

    List<Student> getAllStudents() throws Exception;
}
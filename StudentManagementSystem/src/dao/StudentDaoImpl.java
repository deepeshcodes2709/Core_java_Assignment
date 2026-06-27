package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import exception.AuthenticationFailedException;
import model.Student;

public class StudentDaoImpl implements StudentDao{

    // Register
	public boolean registerStudent(Student student) throws Exception {

	    Connection con = DBConnection.getConnection();

	    String sql = "INSERT INTO students(name,email,password) VALUES(?,?,?)";

	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, student.getName());
	    ps.setString(2, student.getEmail());
	    ps.setString(3, student.getPassword());

	    int rows = ps.executeUpdate();

	    con.close();

	    return rows > 0;
	}

    // Login
	@Override
	public boolean loginStudent(String email, String password)
	        throws Exception, AuthenticationFailedException {

	    Connection con = DBConnection.getConnection();

	    String sql = "SELECT * FROM students WHERE email=? AND password=?";

	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, email);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) {
	        con.close();
	        return true;
	    }

	    con.close();

	    throw new AuthenticationFailedException("Invalid Email or Password");
	}
	
    // Add
	public boolean addStudent(Student student) throws Exception {

	    return registerStudent(student);

	}

    // Display
	public List<Student> getAllStudents() throws Exception {

	    List<Student> list = new ArrayList<>();

	    Connection con = DBConnection.getConnection();

	    String sql = "SELECT * FROM students";

	    PreparedStatement ps = con.prepareStatement(sql);

	    ResultSet rs = ps.executeQuery();

	    while(rs.next()){

	        Student s = new Student();

	        s.setId(rs.getInt("id"));
	        s.setName(rs.getString("name"));
	        s.setEmail(rs.getString("email"));
	        s.setPassword(rs.getString("password"));

	        list.add(s);

	    }

	    con.close();

	    return list;

	}
	
    // Update
	public boolean updateStudent(Student student) throws Exception {

	    Connection con = DBConnection.getConnection();

	    String sql = "UPDATE students SET name=?,email=?,password=? WHERE id=?";

	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, student.getName());
	    ps.setString(2, student.getEmail());
	    ps.setString(3, student.getPassword());
	    ps.setInt(4, student.getId());

	    int rows = ps.executeUpdate();

	    con.close();

	    return rows > 0;
	}

    // Delete
	public boolean deleteStudent(int id) throws Exception {

	    Connection con = DBConnection.getConnection();

	    String sql = "DELETE FROM students WHERE id=?";

	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setInt(1, id);

	    int rows = ps.executeUpdate();

	    con.close();

	    return rows > 0;

	}

}
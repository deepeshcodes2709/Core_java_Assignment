package EmployeeManagement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	public Connection con;

	public EmployeeDAOImpl() throws Exception {
		con = DBUtil.getConnection();
	}

	public void close() throws Exception {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(Employee e) throws Exception {
		String sql = "INSERT INTO Employee VALUES(?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, e.getempId());
			stmt.setString(2, e.getempName());
			stmt.setString(3, e.getdepartment());
			stmt.setDouble(4, e.getsalary());

			int obj = stmt.executeUpdate();

		}
	}


	public void update(Employee e) throws Exception{
		String sql =
		        "UPDATE employee SET empName=?, department=?, salary=? WHERE empId=?";

		    try(PreparedStatement stmt =
		            con.prepareStatement(sql)) {

		        stmt.setString(1, e.getempName());

		        stmt.setString(2, e.getdepartment());

		        stmt.setDouble(3, e.getsalary());

		        stmt.setInt(4, e.getempId());

		        int rows = stmt.executeUpdate();

		        if(rows > 0) {
		            System.out.println("Employee Updated Successfully");
		        }
		        else {
		            System.out.println("Employee Not Found");
		        }

		    }
	}
		    	
		public	void delete(int empId) throws Exception{

		        String sql = "DELETE FROM employee WHERE empId=?";

		        try(PreparedStatement stmt =  con.prepareStatement(sql)) {

		            stmt.setInt(1, empId);

		            int rows = stmt.executeUpdate();

		            if(rows > 0) {
		                System.out.println("Employee Deleted Successfully");
		            }
		            else {
		                System.out.println("Employee Not Found");
		            }
		        }
		    }
		
		public void search(int empId) throws Exception{
			String sql = "SELECT * FROM employee WHERE empId = ?";
			
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setInt(1, empId);

		       

		        ResultSet rs = stmt.executeQuery();

		        if(rs.next()) {

		            Employee e = new Employee(
		                    rs.getInt("empId"),
		                    rs.getString("empName"),
		                    rs.getString("department"),
		                    rs.getDouble("salary")
		            );

		           System.out.println(e);
		        }
		}
			
			public List<Employee> displayAll() throws Exception {

			    List<Employee> list = new ArrayList<>();

			    String sql = "SELECT * FROM employee";

			    try (Statement stmt = con.createStatement()) {

			        try(ResultSet rs = stmt.executeQuery(sql)){

			        while (rs.next()) {

			            Employee e = new Employee(
			                    rs.getInt("empId"),
			                    rs.getString("empName"),
			                    rs.getString("department"),
			                    rs.getDouble("salary")
			            );

			            list.add(e);
			        }
			    }

			    return list;
			}
	}
}

	



package in.soft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.soft.entity.Employee;
import in.soft.factory.ConnectionFactory;

public class EmpDaoImpl implements EmpDao {

	Connection con = ConnectionFactory.getConnection();

	// ADD EMPLOYEE
	@Override
	public String addEmployee(Employee e) {
		String status = "fail"; // default value

		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO employee(name,email,salary) VALUES(?,?,?)");

			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setDouble(3, e.getSalary());

			int count = ps.executeUpdate();

			if (count > 0) {
				status = "success";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status; // ✅ NEVER NULL
	}

	// VIEW ALL EMPLOYEES

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> list = new ArrayList<>();

		try {

			String query = "SELECT * FROM employee";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee e = new Employee();

				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getDouble("salary"));

				list.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// DELETE EMPLOYEE

	@Override
	public String deleteEmployee(int id) {

		String status = "fail";

		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id=?");

			ps.setInt(1, id);

			int count = ps.executeUpdate();

			if (count > 0) {
				status = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String updateEmployee(Employee e) {

		String status = "fail";

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE employee SET name=?, email=?, salary=? WHERE id=?");

			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getId());

			int count = ps.executeUpdate();

			if (count > 0) {
				status = "success";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public Employee searchEmployee(int id) {
		Employee e = null;

		try {
			PreparedStatement ps = con.prepareStatement("select * from employee where id= ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				e = new Employee();

				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getDouble("salary"));

			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return e;
	}

}

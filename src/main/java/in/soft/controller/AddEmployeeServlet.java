package in.soft.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import in.soft.entity.Employee;
import in.soft.factory.ServiceFactory;
import in.soft.services.EmpService;


@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		  try {
	            String name = req.getParameter("name");
	            String email = req.getParameter("email");
	            double salary = Double.parseDouble(req.getParameter("salary"));  //Converts String to double   (HTML always sends String) 

	            Employee e = new Employee();
	            
	            e.setName(name);
	            e.setEmail(email);
	            e.setSalary(salary);

	            EmpService service = ServiceFactory.getEmpService();
	            
	            String status = service.addEmployee(e);
	            
	            System.out.println("Status"+status);

	            if ("success".equals(status)) {
	               
	                RequestDispatcher rs = req.getRequestDispatcher("/success.html");
	                rs.forward(req, res);
	            } else {
	       
	                
	                RequestDispatcher rs = req.getRequestDispatcher("/fail.html");
	                rs.forward(req, res);
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            
	            RequestDispatcher rs = req.getRequestDispatcher("/fail.html");
                rs.forward(req, res);
	        }
		
	
	}

}

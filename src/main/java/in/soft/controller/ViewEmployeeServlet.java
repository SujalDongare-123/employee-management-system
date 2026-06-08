package in.soft.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import in.soft.entity.Employee;
import in.soft.factory.ServiceFactory;
import in.soft.services.EmpService;

@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
        	
            EmpService service = ServiceFactory.getEmpService();
            List<Employee> list = service.getAllEmployees();

            req.setAttribute("data", list);
            req.getRequestDispatcher("display.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
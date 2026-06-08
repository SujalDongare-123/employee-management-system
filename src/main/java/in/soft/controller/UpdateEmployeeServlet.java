package in.soft.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import in.soft.entity.Employee;
import in.soft.factory.ServiceFactory;
import in.soft.services.EmpService;


@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            double salary = Double.parseDouble(req.getParameter("salary"));

            Employee e = new Employee();
            e.setId(id);
            e.setName(name);
            e.setEmail(email);
            e.setSalary(salary);

            EmpService service = ServiceFactory.getEmpService();
            String status = service.updateEmployee(e);

            System.out.println("Update Status: " + status);

            if ("success".equals(status)) {
                res.sendRedirect("success.html");
            } else {
                res.sendRedirect("fail.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("fail.html");
        }
    }
}
package in.soft.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.soft.entity.Employee;
import in.soft.factory.ServiceFactory;
import in.soft.services.EmpService;


@WebServlet("/search")
public class SearchEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    req.getParameter("id"));

            EmpService service =ServiceFactory.getEmpService();

            Employee emp =service.searchEmployee(id);
                    

            List<Employee> list =new ArrayList<>();

            if(emp != null) {
                list.add(emp);
            }

            req.setAttribute("data", list);

            req.getRequestDispatcher("display.jsp")
               .forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("fail.html");
        }
    }
}
package in.soft.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import in.soft.factory.ServiceFactory;
import in.soft.services.EmpService;

@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            EmpService service = ServiceFactory.getEmpService();
            String status = service.deleteEmployee(id);

            if (status.equals("success")) {
                res.sendRedirect("view");
            } else {
                res.sendRedirect("fail.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("fail.html");
        }
    }
}
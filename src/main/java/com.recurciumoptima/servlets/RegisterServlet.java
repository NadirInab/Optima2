package com.recurciumoptima.servlets;

import com.recurciumoptima.module.Employee;
import com.recurciumoptima.services.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private EmployeeService employeeService= new EmployeeService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String hashedPw = BCrypt.hashpw(password , BCrypt.gensalt());
        Employee employee= new Employee(fName,sName,userName,email,hashedPw,position);
        employeeService.addEmlpoyee(employee);
        response.sendRedirect("login.jsp");
    }

    public void destroy() {
    }
}
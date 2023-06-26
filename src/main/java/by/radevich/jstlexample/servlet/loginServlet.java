package by.radevich.jstlexample.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var password = req.getParameter("password");
        req.setAttribute("names", Arrays.asList("Pasha","Misha","Natasha","Tom"));
        Map<String,String> errors = new HashMap<>();//мэпка с ошибками
        if (login == null || login.length()==0){
            errors.put("login", "login cant be null");

        }if (password == null|| password.length()==0){
            errors.put("password","password cant be null");
        }
        if (errors.size()>0){
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("Success.jsp").forward(req,resp);
        }
    }
}

package com.sellandrent.web;

import com.sellandrent.model_tier.Customer;
import com.sellandrent.service_tier.CustomerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String sifre = request.getParameter("sifre");

        Customer customer = customerService.getCustomerByEmail(email);

        
        if (customer != null && customer.getPassword().equals(sifre)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", customer);
            response.sendRedirect("user-panel.jsp"); 
        } else {
            // Giriş başarısızsa kullanıcıya hata mesajı göster
            request.setAttribute("loginError", "Geçersiz e-posta veya şifre.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }
}
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String email = request.getParameter("email");
        String telefon = request.getParameter("telefon");
        String sifre = request.getParameter("sifre");

        Customer yeniMusteri = new Customer();
        yeniMusteri.setName(ad);
        yeniMusteri.setSurname(soyad);
        yeniMusteri.setEmail(email);
        yeniMusteri.setPhone(telefon);
        yeniMusteri.setPassword(sifre); 

        if(!customerService.addCustomer(yeniMusteri)) {
        	HttpSession session = request.getSession(); // Yeni bir oturum oluştur veya mevcut oturumu al
            session.setAttribute("loggedInUser", yeniMusteri); // Kullanıcı bilgilerini oturuma kaydet
        	response.sendRedirect("user-panel.jsp");
        }
        else {
        	request.setAttribute("errorMessage", "Kayıt işlemi başarısız oldu.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
    }

    @Override
    public void destroy() {
        
    }
}
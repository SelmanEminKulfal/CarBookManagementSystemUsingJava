package com.sellandrent.web;

import com.sellandrent.model_tier.Rent;
import com.sellandrent.service_tier.RentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rents")
public class RentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RentService rentService;

    @Override
    public void init() throws ServletException {
        rentService = new RentService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rent> rents = rentService.getAllRents();
        request.setAttribute("rents", rents);
        request.getRequestDispatcher("rents.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        
    }
}
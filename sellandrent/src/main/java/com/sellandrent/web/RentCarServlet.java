package com.sellandrent.web;

import com.sellandrent.model_tier.Vehicle;
import com.sellandrent.service_tier.VehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rent-a-car")
public class RentCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        vehicleService = new VehicleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> availableVehicles = vehicleService.getAllVehicles(); 
        request.setAttribute("availableVehicles", availableVehicles);
        request.getRequestDispatcher("rent-a-car.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        
    }
}
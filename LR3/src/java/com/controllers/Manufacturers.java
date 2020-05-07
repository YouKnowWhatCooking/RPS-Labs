package com.controllers;

import com.beans.ManufacturerBeanLocal;
import com.entity.Manufacturer;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

public class Manufacturers extends HttpServlet{
    @EJB
    ManufacturerBeanLocal manBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            List< Manufacturer> manufacturers = manBean.findAll();
            request.setAttribute("manufacturers", manufacturers);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Manufacturers.jsp");
            requestDispatcher.forward(request, response);
        }catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }
}

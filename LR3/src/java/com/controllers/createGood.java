package com.controllers;

import com.beans.GoodBeanLocal;
import com.beans.ManufacturerBeanLocal;
import com.entity.Good;
import com.entity.Manufacturer;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

public class createGood extends HttpServlet{
    @EJB
    GoodBeanLocal goodBean;
    @EJB
    ManufacturerBeanLocal manBean;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            List<Manufacturer> manufacturers = manBean.findAll();
            request.setAttribute("manufacturers ", manufacturers);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("createGood.jsp");
            requestDispatcher.forward(request, response);
        }catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Good good = new Good();
       good.setTitle(request.getParameter("title"));
       Manufacturer man = manBean.find(Integer.parseInt(request.getParameter("manufacturer")));
       good.setManufacturer(man);
       goodBean.create(good);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
       requestDispatcher.forward(request, response);
    }
}


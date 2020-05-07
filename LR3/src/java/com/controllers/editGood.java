package com.controllers;

import com.beans.GoodBeanLocal;
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

public class editGood extends HttpServlet{
    @EJB
    GoodBeanLocal goodBean;
    @EJB
    ManufacturerBeanLocal manBean;
    
    Good good;
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        good = goodBean.find(id);
        request.setAttribute("good", good);
        List<Manufacturer> manufacturer = manBean.findAll();
        request.setAttribute("manufacturers", manufacturers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editGood.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        good.setTitle(request.getParameter("title"));       
        Manufacturer man = manufacturerBean.find(Integer.parseInt(request.getParameter("manufacturer")));
        good.setManufacturer(sp);
        goodBean.edit(good);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}

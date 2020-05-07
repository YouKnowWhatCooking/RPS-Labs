package com.controllers;

import com.beans.GoodBeanLocal;
import com.entity.Good;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

public class Goods extends HttpServlet{
    @EJB
    GoodBeanLocal goodBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            List<Good> goods = goodBean.findAll();
            request.setAttribute("goods", goods);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Goods.jsp");
            requestDispatcher.forward(request, response);
        }catch (IOException | ServletException e) { 
            e.getMessage(); 
        }  
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Good good = goodBean.find(id);
        goodBean.remove(good);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}

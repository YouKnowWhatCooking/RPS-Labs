package com.servlet;

import com.dao.GoodDAO;
import com.models.Good;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
    @EJB
    private GoodDAO goodDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Good good = goodDAO.getGoodById(id);
            request.setAttribute("good", good);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("updatePage.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Good good = goodDAO.getGoodById(id);
        good.setTitle(request.getParameter("title"));
        good.setAmount(Integer.parseInt(request.getParameter("amount")));
        good.setDescription(request.getParameter("description"));
        goodDAO.updateGood(good);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}

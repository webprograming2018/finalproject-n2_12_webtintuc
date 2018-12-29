package com.controller;

import com.dao.NewDAO;
import com.model.New;
import com.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/view")
public class NewController extends HttpServlet {

    private NewDAO userDAO = new NewDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("user");
        if(user != null){
            try {
                if(request.getParameter("action")!=null && request.getParameter("action").equalsIgnoreCase("delete")){
                	userDAO.delete(Integer.parseInt(request.getParameter("id")));
                    response.sendRedirect("/view");
                }
                ArrayList<New> list = userDAO.search("");
//                System.out.print(list);
                request.setAttribute("piList",list);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/view.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("search")){
            String txt_name = request.getParameter("pid");
            if(txt_name.equals("") || txt_name == null){
                response.sendRedirect(request.getContextPath()+"/view");
            }else{
                ArrayList<New> list = userDAO.search(txt_name);

                request.setAttribute("piList",list);
                request.getRequestDispatcher("/view.jsp").forward(request, response);
            }
        }
      
    }

}


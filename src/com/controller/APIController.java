package com.controller;

import com.dao.NewDAO;
import com.google.gson.Gson;
import com.model.ApiNew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api")
public class APIController extends HttpServlet {
    NewDAO newDAO = new NewDAO();
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("tab.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null){
            if(action.equalsIgnoreCase("add")){
                String title = req.getParameter("title");
                String abstract1 = req.getParameter("abstract");
                String url = req.getParameter("short-url");
                String image = req.getParameter("image");
                ApiNew  apiNew = new ApiNew(image, title, abstract1, url, 1);
                ApiNew check = newDAO.getApNews(apiNew.getTitle());
                if(check == null ){
                    if(newDAO.insertApiNew(apiNew))
                        resp.getWriter().write("true");
                    else resp.getWriter().write("false");
                } else {
                    if(check.getStatus() == 0){
                        newDAO.updateApiNews(check.getId(), 1);
                        resp.getWriter().write("true");
                    }else
                        resp.getWriter().write("exits");
                }
            }
            if(action.equalsIgnoreCase("cancel")){
                String id = req.getParameter("id");
                if(newDAO.updateApiNews(Integer.parseInt(id), 0)){
                    resp.getWriter().write("true");
                } else {
                    resp.getWriter().write("false");
                }
            }
            if(action.equalsIgnoreCase("load")){
                List<ApiNew> list = newDAO.load();
                resp.getWriter().write(gson.toJson(list));
            }
        }
    }
}

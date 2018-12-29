package com.controller;

import com.dao.CommentDAO;
import com.dao.NewDAO;
import com.model.ApiNew;
import com.model.Comment;
import com.model.New;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    NewDAO newDAO = new NewDAO();
    CommentDAO commentDAO = new CommentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
        String currentPage = req.getParameter("page");
        Integer page;
        if(currentPage==null || currentPage.equalsIgnoreCase("")){
            page = 1;
        }else {
            page = Integer.parseInt(currentPage);
        }
        
        ArrayList<New> list = newDAO.getAll(page);
        
        ArrayList<New> hots = newDAO.getHots();
        Integer size = newDAO.getCount();
        String cateid = req.getParameter("category");
        if(cateid !=null){
        	list = newDAO.getAllByCategory(Integer.parseInt(cateid));
        	size = list.size();
        }
        List<ApiNew> api = newDAO.load();
        req.setAttribute("list",list);
        req.setAttribute("size",size);
        req.setAttribute("hots",hots);
        req.setAttribute("api",api);
        String userId = (String) session.getAttribute("currentUser");
        List<Comment> listComment = commentDAO.getCommentByUser(userId);
        Boolean c = false;
        if(listComment != null && listComment.size() > 0){
        	c = true;
        	req.setAttribute("listC", listComment);
        	
        }
        req.setAttribute("notification", c);
        req.getRequestDispatcher("client/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void createCustomUser(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        Boolean newP = false;
        if (cookies != null) {
            Cookie cookie = getCookie(cookies);
            if(cookie != null){
                //lần 2
                newP = true;
            }else {
                //lần đầu
            }

        }
        if(newP == false){
        	String uid = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date().getTime());
            String value = "uid_"+uid;
            Cookie CustomUser = new Cookie("user", value);
            CustomUser.setMaxAge(60 * 60 * 24);
            resp.addCookie(CustomUser);
        }
        //req.setAttribute("new-product", newP);
    }
    public Cookie getCookie(Cookie[] cookies){
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if(c.getName().equalsIgnoreCase("user")){
                cookie = c;
                break;
            }
        }
        return cookie;
    }
}

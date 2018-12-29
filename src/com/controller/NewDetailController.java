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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/detail")
public class NewDetailController extends HttpServlet {
    NewDAO newDAO = new NewDAO();
    CommentDAO commentDAO = new CommentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
        String id = req.getParameter("id");
        New news = newDAO.getNewsID(Integer.parseInt(id));
        req.setAttribute("news", news);
        ArrayList<New> hots = newDAO.getHots();
        req.setAttribute("hots",hots);
        List<ApiNew> api = newDAO.load();
        req.setAttribute("api",api);
        //cookie
        createCustomUser(req, resp);
        List<Comment> list = commentDAO.getAllComment(Integer.parseInt(id));
        req.setAttribute("listcom", list);
        String userId = (String) session.getAttribute("currentUser");
        /*System.out.println(userId);*/
        List<Comment> listComment = commentDAO.getCommentByUser(userId);
        Boolean c = false;
        if(listComment != null && listComment.size() > 0){
        	c = true;
        	req.setAttribute("listC", listComment);
        	
        }
        req.setAttribute("notification", c);
        req.getRequestDispatcher("client/single-post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String action = req.getParameter("action");
    	if(action.equalsIgnoreCase("add-comment")){
    		String userId = getCookie(req.getCookies()).getValue();
        	String name = req.getParameter("name");
        	Integer idnew = Integer.parseInt(req.getParameter("id-new"));
        	String connet = req.getParameter("content");
        	Comment comment = new Comment(name, idnew, userId, new Date(new java.util.Date().getTime()), connet);
        	commentDAO.insertComment(comment);
        	resp.sendRedirect("/detail?id="+idnew);
    	}
    	
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
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", "uid_"+uid);
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

package com.controller;

import com.dao.CategoryDAO;
import com.dao.NewDAO;
import com.model.New;
import com.model.Admin;
import com.model.Category;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/create")
public class CreateController extends HttpServlet {
	NewDAO newDao = new NewDAO();
	CategoryDAO cateDao = new CategoryDAO();
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("user");
        String idd = request.getParameter("id");
        if(!idd.equalsIgnoreCase("nulll")) {
        	Integer id = Integer.parseInt(idd);

				New new1 = newDao.getNewsID(id);
                System.out.println(new1.getTypeOfNew());
				request.setAttribute("news", new1);

        	
        }else {
        	request.setAttribute("news", null);
        }
        ArrayList<Category> list = cateDao.getAll();
        request.setAttribute("cates", list);
        request.getRequestDispatcher("create.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("update")){
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            HashMap<String, String> map = new HashMap<String, String>();
            if (isMultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");
                try {
                    List<FileItem> fileItems = upload.parseRequest(request);
                    for (FileItem item : fileItems) {
                        String key = item.getFieldName();
                        if (!item.isFormField()) {
                            String filename = item.getName();
                            if(!filename.equalsIgnoreCase("")){
                                String pathFile = "C:/upload" + File.separator + filename;
                                item.write(new File(pathFile));
                            }
                            map.put(key, filename);
                        }else{
                            String value = item.getString("UTF-8");
                            map.put(key, value);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            New news = new New();
            if(map.get("id") == null || map.get("id").equalsIgnoreCase("")){
                news.setID(null);
            }else {
                news.setID(Integer.parseInt(map.get("id")));
                
                
            }
            if(map.get("image")=="" || map.get("image")==null){
            	New new1 = newDao.getNewsID(Integer.parseInt(map.get("id")));
            	news.setImage(new1.getImage());
            }
            	
            else news.setImage(map.get("image"));
            news.setName(map.get("name"));
            news.setAuth(map.get("auth"));
            news.setCategory_id(Integer.parseInt(map.get("category_id")));
            news.setContent(map.get("content"));
            
            news.setSort_content(map.get("short_content"));
            news.setTypeOfNew(Integer.parseInt(map.get("type_of_news")));



            java.util.Date date = null;
            try {
                date = sdf1.parse(map.get("exp"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date exp = new Date(date.getTime());
            news.setExp(exp);

            java.util.Date date1 = new java.util.Date();
            news.setCreateAt(new Date(date1.getTime()));

            System.out.println(news);
            if(news.getID() == null) {
                newDao.insertNew(news);
            }
            else newDao.updateOld(news);
            response.sendRedirect("/view");
        }
    }

    }


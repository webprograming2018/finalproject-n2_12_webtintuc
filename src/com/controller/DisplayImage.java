package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/image")
public class DisplayImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String fileName = req.getParameter("name");
            FileInputStream fis = new FileInputStream(new File("C:/upload/"+fileName));
            BufferedInputStream bis = new BufferedInputStream(fis);
            resp.setContentType("image/*");
            BufferedOutputStream output = new BufferedOutputStream(resp.getOutputStream());
            for (int data; (data = bis.read()) > -1;) {
                output.write(data);
            }
            bis.close();
            fis.close();
        }
        catch(IOException e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

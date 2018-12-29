package com.dao;

import com.model.Comment;
import com.model.New;
import com.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb = new ConnectDB();
    public CommentDAO() {
    }
    public ArrayList<New> getAll(Integer page) {
        ArrayList<New> list = new ArrayList();
        String sql = "SELECT n.id, n.auth,n.image, n.short_content, n.`name`, category.`name_cate` FROM news n, category where n.category_id=category.id AND TIMESTAMPDIFF(DAY, NOW(), n.exps) >=0 order by n.id desc limit ?, 6";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, (page-1)*6);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String name_cate = rs.getString("name_cate");
                String short_content = rs.getString("short_content");
                String auth = rs.getString("auth");
                String image = rs.getString("image");

                New ne = new New(id, name, short_content, image, auth, name_cate);
                list.add(ne);
            }
        } catch (Exception e) {

            System.out.println(e);
        }
        //connectdb.closeConnect();
        return list;
    }
    public boolean insertComment(Comment com) {
        String sql = "INSERT INTO `db_bai3`.`comments` (`news_id`, `user_id`,`content`, create_at, `name`) VALUES (?,?,?,?,?)";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, com.getNewId());
            stmt.setString(2, com.getUserId());
            stmt.setString(3, com.getContent());
            stmt.setDate(4, com.getCreateAt());
            stmt.setString(5, com.getName());
           
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Comment> getCommentByUser(String id) {
        String sql = "SELECT comments.*,news.`name` as title FROM comments,news WHERE user_id !=? AND comments.news_id=news.id";
        List<Comment> list = new ArrayList<Comment>();
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	
                Comment news = new Comment();
                news.setName(rs.getString("name"));
                news.setContent(rs.getString("content"));
                news.setNewId(rs.getInt("news_id"));
                news.setTitle(rs.getString("title"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Comment> getAllComment(int id) {
        String sql = "SELECT * FROM comments where news_id = ?";
        List<Comment> list = new ArrayList<Comment>();
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
                Comment news = new Comment();
                news.setName(rs.getString("name"));
                news.setContent(rs.getString("content"));
                news.setNewId(rs.getInt("news_id"));
                news.setCreateAt(rs.getDate("create_at"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public New getNewsID(Integer id) {
        String sql = "SELECT * FROM news WHERE id=?";
        New news = null;
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                news = new New();
                Integer id1 = rs.getInt("id");
                String name = rs.getString("name");
                String short_content = rs.getString("short_content");
                String auth = rs.getString("auth");
                String image = rs.getString("image");
                /*String name_cate = rs.getString("name_cate");*/
                String content = rs.getString("content");
                Integer category_id = rs.getInt("category_id");
                Date createat = rs.getDate("create_at");
                Date exp = rs.getDate("exps");
                Integer type = rs.getInt("type_of_news");
                news = new New(id1, name, category_id, content, short_content, image, auth, type, createat, exp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }
}

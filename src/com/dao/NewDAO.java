package com.dao;

import com.model.ApiNew;
import com.model.Category;
import com.model.New;
import com.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb = new ConnectDB();
    public NewDAO() {
    }
    public ArrayList<New> search(String text) {
        ArrayList<New> list = new ArrayList();
        String sql = "SELECT news.id, news.auth,news.image, news.short_content, news.`name`, category.`name_cate` FROM news, category where news.category_id=category.id order by news.id desc";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
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
    public ArrayList<New> getAllByCategory(Integer id1) {
        ArrayList<New> list = new ArrayList();
        String sql = "SELECT n.id, n.auth,n.image, n.short_content, n.`name`, category.`name_cate` FROM news n, category where n.category_id=category.id and n.category_id=? AND TIMESTAMPDIFF(DAY, NOW(), n.exps) >=0 order by n.id desc";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, id1);
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
    public ArrayList<New> getHots() {
        ArrayList<New> list = new ArrayList();
        String sql = "SELECT * FROM news where type_of_news = 1 AND TIMESTAMPDIFF(DAY, NOW(), news.exps) >=0";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                New ne = new New();
                ne.setID(rs.getInt("id"));
                ne.setName(rs.getString("name"));
                list.add(ne);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<Category> getCate() {
        ArrayList<Category> list = new ArrayList();
        String sql = "SELECT * From category";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setName(rs.getString("name_cate"));
                cate.setId(rs.getInt("id"));
                list.add(cate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Integer getCount() {
        ArrayList<New> list = new ArrayList();
        String sql = "SELECT COUNT(1) FROM news n, category where n.category_id=category.id AND TIMESTAMPDIFF(DAY, NOW(), n.exps)";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return 0;
    }
    public boolean insertNew(New new1) {
        String sql = "INSERT INTO `db_bai3`.`news` (`name`, `category_id`, `content`,`auth`,`image`,`short_content`, create_at, exps, type_of_news) VALUES (?, ?, ?,?,?,?,?,?,?);";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setString(1, new1.getName());
            stmt.setInt(2, new1.getCategory_id());
            stmt.setString(3, new1.getContent());
            stmt.setString(4, new1.getAuth());
            stmt.setString(5, new1.getImage());
            stmt.setString(6, new1.getShort_content());
            stmt.setDate(7, new1.getCreateAt());
            stmt.setDate(8, new1.getExp());
            stmt.setInt(9, new1.getTypeOfNew());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOld(New user) {
        String sql = "UPDATE `db_bai3`.`news` SET `name`=?, `category_id`=?, `content`=?, `auth`=?, `image`=?,`short_content`=?, exps =?, type_of_news=? WHERE `id`=?";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getCategory_id());
            stmt.setString(3, user.getContent());
            stmt.setString(4, user.getAuth());
            stmt.setString(5, user.getImage());
            stmt.setString(6, user.getShort_content());
            stmt.setInt(9, user.getID());
            stmt.setDate(7, user.getExp());
            stmt.setInt(8, user.getTypeOfNew());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Integer id) throws SQLException {
        String sql = "DELETE FROM `db_bai3`.`news` WHERE `id`=?";
        stmt = ConnectDB.openConnect().prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
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
    public ApiNew getApNews(String title){
        ApiNew news = null;
        String sql = "SELECT * FROM api_news WHERE title= ?";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setString(1, title);
            rs = stmt.executeQuery();

            if (rs.next()) {
                news = new ApiNew();
                news.setId(rs.getInt("id"));
                news.setImage(rs.getString("image"));
                news.setShort_content(rs.getString("short_content"));
                news.setUrl(rs.getString("url"));
                news.setTitle(rs.getString("title"));
                news.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }
    public List<ApiNew> load(){
        List<ApiNew> list = new ArrayList<ApiNew>();
        String sql = "SELECT * FROM api_news WHERE status= 1";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ApiNew news = new ApiNew();
                news.setId(rs.getInt("id"));
                news.setImage(rs.getString("image"));
                news.setShort_content(rs.getString("short_content"));
                news.setUrl(rs.getString("url"));
                news.setTitle(rs.getString("title"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean updateApiNews(Integer id, Integer status) {
        String sql = "UPDATE `db_bai3`.`api_news` SET status = ? WHERE `id`=?";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setInt(1, status);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean insertApiNew(ApiNew new1) {
        String sql = "INSERT INTO `db_bai3`.`api_news` (image, title, short_content, url, status) VALUES (?, ?, ?,?,?);";
        try {
            stmt = ConnectDB.openConnect().prepareStatement(sql);
            stmt.setString(1, new1.getImage());
            stmt.setString(2, new1.getTitle());
            stmt.setString(3, new1.getShort_content());
            stmt.setString(4, new1.getUrl());
            stmt.setInt(5, new1.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

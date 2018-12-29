package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Category;
import com.util.ConnectDB;

public class CategoryDAO {
	public ArrayList<Category> getAll(){
		ArrayList<Category> list = new ArrayList<Category>();
		try {
			Connection connection = ConnectDB.openConnect();
			String sql = "SELECT * FROM category";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name_cate"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

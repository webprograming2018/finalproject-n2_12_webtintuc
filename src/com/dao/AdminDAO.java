package com.dao;

import com.model.Admin;
import com.util.ConnectDB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public boolean checkLogin(Admin admin){
        String sql = "SELECT COUNT(*) as count FROM admin where username = ? and password = ?";
        try {
            PreparedStatement st = ConnectDB.openConnect().prepareStatement(sql);
            st.setString(1, admin.getUsername());
            st.setString(2, getmd5(admin.getPassword()));
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                if(rs.getInt("count") == 1){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Admin getAdmin(String username){
        String sql = "SELECT * FROM admin where username = ?";
        try {
            PreparedStatement st = ConnectDB.openConnect().prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Admin u = new Admin(rs.getString("username"), rs.getString("password"), "");
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    public String getmd5(String s) {
    	MessageDigest md = null;
    	try {
    		md = MessageDigest.getInstance("MD5");
    	} catch (NoSuchAlgorithmException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        byte[] messageDigest = md.digest(s.getBytes());
        return convertByteToHex(messageDigest); 
	}
    public String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
          sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
      }
}

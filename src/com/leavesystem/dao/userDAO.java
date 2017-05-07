package com.leavesystem.dao;

import com.leavesystem.beans.*;
import com.leavesystem.db.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class userDAO {

	public static void add(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql ="insert into tbl_user (user_id,full_name,password,gender,role) values (?,?,?,?,?)";
		try{
			conn= DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getPassword());
			ps.executeUpdate();
			
		}catch(SQLException e){
			
			e.printStackTrace();
			throw new SQLException("failed add user");
		}finally{
			DBUtils.close(null, ps, conn);			
		}
		
		
	}
	
	public static User findbyUserid(String userId) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql ="SELECT user_id,full_name,password,gender,role FROM leavesystem.tbl_user where user_id=?";
		try{
			conn= DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserid(rs.getString(1));
				user.setFullname(rs.getString(2));
				user.setPassword(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setRole(rs.getString(5));		
			}       		
		}catch(SQLException e){
			
			e.printStackTrace();
			throw new SQLException("failed to find user by id");
		}finally{
			DBUtils.close(rs, ps, conn);			
		}
		return user;
		
	}
	public static boolean checkUser(String userID,String pass) 
    {
     boolean st =false;
     Connection conn = null;
     PreparedStatement ps = null;
     String sql = "select * from leavesystem.tbl_user where user_id= ? and password = ?";
     try{
        conn =DBUtils.getConnection();
        ps =conn.prepareStatement(sql);
        ps.setString(1, userID);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
         System.out.println(e.getMessage());
     }
        return st;                 
 }   

}

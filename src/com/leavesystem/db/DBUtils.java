package com.leavesystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {

	    
	     public static String URL;
	   
	     public static String USERNAME;
	   
	     public static String PASSWORD;
	   
	     public static String DRIVER;
	     
	     private static ResourceBundle rb = ResourceBundle.getBundle("com.leavesystem.db.db-config");
	     
	     public static Connection getConnection() {
	    	 
	    	  URL = rb.getString("db.url");
	    	  USERNAME = rb.getString("db.username");
	    	  PASSWORD = rb.getString("db.password");
	    	  DRIVER = rb.getString("db.driver");
	    	  
	    	          Connection conn = null;
	    	          try {
	    	        	  Class.forName(DRIVER);
	    	              conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	    	          } catch (SQLException e) {
	    	              e.printStackTrace();
	    	              System.out.println("Failed in getting connection");
	    	          }catch(ClassNotFoundException e){
	    	        	  e.printStackTrace();
	    	        	  System.out.println("Driver class not found");
	    	          }
	    	          
	    	          return conn;
	    	      }
	     
	     public static void close(ResultSet rs, Statement stat,Connection conn){
	    	             try {
	    	                 if(rs!=null) rs.close();
	    	                 if(stat!=null) stat.close();
	    	                 if(conn!=null) conn.close();
	    	             } catch (SQLException e) {
	    	                  e.printStackTrace();
	    	              }
	    	     }
}

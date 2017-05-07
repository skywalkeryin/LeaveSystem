package com.leavesystem.beans;

public class User {
	 
	   public String  userid;
	   public String password;
	   public String  fullname;
	   public String  gender;
	   public String role;

	  
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User( String userid, String password, String fullname, String gender, String role) {
		super();
		
		this.userid = userid;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isNull(){
		if(this.userid ==null &&		
		this.fullname == null 
		){
			return true;
		}else{
			return false;
		}
	}



}

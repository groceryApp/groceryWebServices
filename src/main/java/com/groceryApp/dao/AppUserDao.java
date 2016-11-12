package com.groceryApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.groceryApp.entity.AppUser;

public class AppUserDao {

	DatabaseDao dao = null;
	
	public AppUserDao(){
		dao = new DatabaseDao();
	}

	public boolean signUp(AppUser user){
		Connection con = null;
		try{
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date dt = format.parse(user.getDob());
			con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getFirstname());
			ps.setString(3,user.getLastname());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getRole());
			ps.setString(6,user.getEmail());
			ps.setString(7,user.getPhone());
			ps.setString(8,user.getAddress());
			ps.setDate(9, new java.sql.Date(dt.getTime()));
			return ps.executeUpdate() == 1 ? true : false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public static void main(String[] args) {
		Date dt = new Date();
		AppUser a = new AppUser("1001357754",
				"surendra",
				"vanteddu",
				"password",
				 "customer",
				"surendranaidu04@gmail.com",
				"9090909090",
				"arlington",
				 "08/24/1993");
		if(new AppUserDao().signUp(a)){
			System.out.println("added");
		}else{
			System.out.println("no");
		}
		
	}
	
}

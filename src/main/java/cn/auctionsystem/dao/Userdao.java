package cn.auctionsystem.dao;

import java.sql.Connection;
import com.auctionsystem.constants.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.auctionsystem.model.User;

public class Userdao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public Userdao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		
		User user = null;
		
		try {
			
			//"select * from user where email = "+ email +" and password = "+password;
			//we are not writing in the above way to avoid SQL injection
			
			query = "select * from user where email=? and password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			
			if(rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getInt("role"));
			}
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	
	public void addRepresentative(String name, String email, String password) {
		
		int role = Constants.UserConstants.getREPRESENTATIVE();
		
		query = String.format("INSERT INTO user (name, email, password, role) VALUES ('%s', '%s', '%s', %d)", name, email, password, role);
		try {
			pst = this.con.prepareStatement(query);
//			
//			pst.setString(1, name);
//			pst.setString(2, email);
//			pst.setString(3, password);
//			pst.setInt(4, role);
//			
			System.out.println(query);
			pst.executeUpdate(query);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}

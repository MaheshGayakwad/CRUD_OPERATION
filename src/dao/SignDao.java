package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.SignUpBO;



public class SignDao {

	
	
	
public static Connection getConnection() {
		
		Connection con = null;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Crud" , "root" , "Mahesh10");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return con;
	}
	
	public static int registerUser(SignUpBO si) {
		int status = 0;
		
		try {
			
			Connection con = SignDao.getConnection();
			
			String sql = "insert into registered(name,email,phone,password,city,country) values(?,?,?,?,?,?)";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(1, si.getName());
			ps.setString(2, si.getEmail());
			ps.setString(3, si.getPhone());
			ps.setString(4, si.getPassword());
			ps.setString(5, si.getCity());
			ps.setString(6, si.getCountry());
			
			status = ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return status;
	}
	
	
	
	
	
	public static ArrayList<SignUpBO> showUsers() {
		
		
		
		
		ArrayList<SignUpBO> al = new ArrayList<SignUpBO>();
		
		
		try {
			
			
			
			Connection con = SignDao.getConnection();
			
			String sql = "Select * from registered";
			
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SignUpBO obj = new SignUpBO();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setPhone(rs.getString(4));
				obj.setPassword(rs.getString(5));
				obj.setCity(rs.getString(6));
				obj.setCountry(rs.getString(7));
				
				al.add(obj);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return al;
	}
	
	
	
	
	
	public static SignUpBO getEmployeebyId(int id) {
		
		
		
	
		SignUpBO obj = new SignUpBO();
		
		try {
			
			
			
			Connection con = SignDao.getConnection();
			
			String sql = "Select * from registered where id = ?";
			
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setPhone(rs.getString(4));
				obj.setPassword(rs.getString(5));
				obj.setCity(rs.getString(6));
				obj.setCountry(rs.getString(7));
			
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return obj;
	}
	
	
	
	
	public static int update(SignUpBO e) {
		
		int status = 1;
		
		
		try {
			
			Connection con = SignDao.getConnection();
			
			
			String sql = "update registered set name = ? , email = ? , phone = ? , password = ? , city = ? ,country = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPhone());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getCity());
			ps.setString(6, e.getCountry());
			ps.setInt(7, e.getId());
			
			
			status = ps.executeUpdate();
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
		return status;
		
	}
	
	
	public static int delete(int id) {
		
		int status = 0;
		
		
		try {
			
			Connection con = SignDao.getConnection();
			
			String sql = "Delete from registered where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return status;
	}
	
	
	
}

	
	
	
	
	


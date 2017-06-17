package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Userinfo;
import com.util.JdbcUtil;

public class UserinfoDao {
	
	public  List<Userinfo> findUserinfos(){
		System.out.println("UserinfoDao.findUserinfos");
		List<Userinfo> userinfos= new ArrayList<Userinfo>();
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select * from userinfo");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Userinfo userinfo= new Userinfo();
				userinfo.setUid(resultSet.getInt("uid"));
				userinfo.setUserinfoname(resultSet.getString("userinfoname"));
				userinfo.setSex(resultSet.getString("sex"));
				userinfo.setAge(resultSet.getInt("age"));
				userinfo.setPhone(resultSet.getString("phone"));
				userinfo.setSchool(resultSet.getString("school"));
				userinfos.add(userinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
		return userinfos;
	}
	
	public  void addUserinfo(Userinfo userinfo){
		System.out.println("UserinfoDao.addUserinfo");
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("insert into userinfo values(null,?,?,?,?,?)");
			preparedStatement.setString(1, userinfo.getUserinfoname());
			preparedStatement.setString(2, userinfo.getSex());
			preparedStatement.setInt(3, userinfo.getAge());
			preparedStatement.setString(4, userinfo.getPhone());
			preparedStatement.setString(5, userinfo.getSchool());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
	}
	
	public  Userinfo findById(String uid){
		System.out.println("UserinfoDao.findById");
		Userinfo userinfo= null;
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select * from userinfo where uid=?");
			preparedStatement.setInt(1, Integer.parseInt(uid));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userinfo= new Userinfo();
				userinfo.setUid(resultSet.getInt("uid"));
				userinfo.setUserinfoname(resultSet.getString("userinfoname"));
				userinfo.setSex(resultSet.getString("sex"));
				userinfo.setAge(resultSet.getInt("age"));
				userinfo.setPhone(resultSet.getString("phone"));
				userinfo.setSchool(resultSet.getString("school"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
		
		return userinfo;
	}
	
	public  void update(Userinfo userinfo){
		System.out.println("UserinfoDao.update");
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("update userinfo set userinfoname=?,sex=?,age=?,phone=?,school=? where uid=?");
			preparedStatement.setString(1, userinfo.getUserinfoname());
			preparedStatement.setString(2, userinfo.getSex());
			preparedStatement.setInt(3, userinfo.getAge());
			preparedStatement.setString(4, userinfo.getPhone());
			preparedStatement.setString(5, userinfo.getSchool());
			preparedStatement.setInt(6, userinfo.getUid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
		
	}
	
	public void delete(String uid){
		System.out.println("UserinfoDao.delete");
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("delete from userinfo where uid=?");
			preparedStatement.setInt(1, Integer.parseInt(uid));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
	}
	
}

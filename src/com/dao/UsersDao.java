package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.domain.Users;
import com.util.JdbcUtil;

public class UsersDao {
	
	public  Users findUsersByNameAndPass(String username,String password){
		System.out.println("UsersDao.findUsersByNameAndPass");
		Users users= null;
		Connection connection= JdbcUtil.getConnection();
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("select * from users where username=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				users= new Users();
				users.setId(resultSet.getInt("id"));
				users.setUsername(resultSet.getString("username"));
				users.setPassword(resultSet.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(connection);
		}
		
		return users;
	}
	
	public void insertUsers(Users users){
		System.out.println("UsersDao.insertUsers");
		
		Connection connection= JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("insert into users values(null,?,?)");
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(connection);
		}
	}
}

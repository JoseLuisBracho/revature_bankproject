package com.dutybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutybank.dao.LogInCrudDAO;
import com.dutybank.dao.dbutil.PostgresqlConnection;
import com.dutybank.exception.BusinessException;
import com.dutybank.model.UserLogIn;

public class LogInCrudDAOImpl implements LogInCrudDAO {

	@Override
	public UserLogIn retrieveUser(String email) throws BusinessException {
		// TODO Auto-generated method stub
		UserLogIn user = null;
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select login_id, email, password, creation_date, user_type from dutybank.login where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				user = new UserLogIn();
				user.setLogin_id(resultSet.getInt("login_id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setCreation_date(resultSet.getDate("creation_date"));
				user.setUser_type(resultSet.getString("user_type"));
				
			} else {
				throw new BusinessException("Some Internal Error Occurred!");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Some exception retrieving user login data has occurred");
		}
		
		return user;
	}

	@Override
	public int updateUserData(int user_id, String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createLogin(UserLogIn user) throws BusinessException {
		// TODO Auto-generated method stub
		int lg = 0;
		
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "insert into dutybank.login (email, password, user_type) values(?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUser_type());

			
			lg = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some internal error has occurred while creating data");
		}
		

		return lg;
	}

	@Override
	public List<UserLogIn> retriveAllUsers() throws BusinessException {
		// TODO Auto-generated method stub
		UserLogIn bankLogin = null;
		List<UserLogIn> bankLoginList = new ArrayList<>();
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select login_id, email, password, creation_date, user_type from dutybank.login";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				bankLogin = new UserLogIn();
				bankLogin.setLogin_id(resultSet.getInt("login_id"));
				bankLogin.setEmail(resultSet.getString("email"));
				bankLogin.setPassword(resultSet.getString("password"));
				bankLogin.setCreation_date(resultSet.getDate("creation_date"));
				bankLogin.setUser_type(resultSet.getString("user_type"));

				bankLoginList.add(bankLogin);
			} 
			
			if (bankLoginList.size() == 0) {
				throw new BusinessException("There is not data to retrieve");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some Error occurred retrieving data for logins");
		}
		
		return bankLoginList;
	}



}

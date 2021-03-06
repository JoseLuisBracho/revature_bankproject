package com.dutybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.dbutil.PostgresqlConnection;
import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankClient;

public class ClientCrudDAOImpl implements ClientCrudDAO {

	@Override
	public BankClient retreiveClient(int login_id) throws BusinessException {
		// TODO Auto-generated method stub
		BankClient client = null;
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select user_id, first_name, last_name, legalid, gender, contact_number,"
					+ "date_birth, address, nationality, salary from dutybank.users where login_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, login_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				client = new BankClient();
				client.setClientid(resultSet.getInt("user_id"));
				client.setClientname(resultSet.getString("first_name"));
				client.setClientlastname(resultSet.getString("last_name"));
				client.setClientdocument(resultSet.getString("legalid"));
				client.setClientgender(resultSet.getString("gender"));
				client.setClientcontact(resultSet.getLong("contact_number"));
				client.setClientdob(resultSet.getDate("date_birth"));
				client.setClientaddress(resultSet.getString("address"));
				client.setClientnationality(resultSet.getString("nationality"));
				client.setClientsalary(resultSet.getDouble("salary"));
				
			} else {
				throw new BusinessException("Some Internal Error Occurred!");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Some exception retrieving tha data has occurred in client");
		}
		
		return client;
	}

	@Override
	public double viewBalance(int accountid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankAccount postTranfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount acceptTranfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createClient(BankClient client) throws BusinessException {
		// TODO Auto-generated method stub
		int cl = 0;
		
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "insert into dutybank.users (first_name, last_name, legalid, gender, contact_number, "
					+ "date_birth, address, nationality, salary, login_id) values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, client.getClientname());
			preparedStatement.setString(2, client.getClientlastname());
			preparedStatement.setString(3, client.getClientdocument());
			preparedStatement.setString(4, client.getClientgender());
			preparedStatement.setLong(5, client.getClientcontact());
			preparedStatement.setDate(6, new java.sql.Date(client.getClientdob().getTime()));
			preparedStatement.setString(7, client.getClientaddress());
			preparedStatement.setString(8, client.getClientnationality());
			preparedStatement.setDouble(9, client.getClientsalary());
			preparedStatement.setInt(10, client.getClientloginid());
			
			cl = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some internal error has occurred while fetching data");
		}
		

		return cl;
	}

	@Override
	public List<BankClient> getAllClients() throws BusinessException {
		// TODO Auto-generated method stub
		List<BankClient> bankClientList = new ArrayList<>();
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select user_id, first_name, last_name, legalid, gender, contact_number, "
					+ "date_birth, address, nationality, salary from dutybank.users";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				BankClient bankClient = new BankClient();
				bankClient.setClientid(resultSet.getInt("user_id"));
				bankClient.setClientname(resultSet.getString("first_name"));
				bankClient.setClientlastname(resultSet.getString("last_name"));
				bankClient.setClientdocument(resultSet.getString("legalid"));
				bankClient.setClientgender(resultSet.getString("gender"));
				bankClient.setClientcontact(resultSet.getLong("contact_number"));
				bankClient.setClientdob(resultSet.getDate("date_birth"));
				bankClient.setClientaddress(resultSet.getString("address"));
				bankClient.setClientnationality(resultSet.getString("nationality"));
				bankClient.setClientsalary(resultSet.getDouble("salary"));
	

				bankClientList.add(bankClient);
			} 
			
			if (bankClientList.size() == 0) {
				throw new BusinessException("There is not data to retrieve");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some Error ocurred retrieving data for clients");
		}
		
		return bankClientList;
	}



}

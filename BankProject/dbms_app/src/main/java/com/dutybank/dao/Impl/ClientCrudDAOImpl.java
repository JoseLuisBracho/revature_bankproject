package com.dutybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.dbutil.PostgresqlConnection;
import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankTransaction;

public class ClientCrudDAOImpl implements ClientCrudDAO {

	@Override
	public int createNewAccount(BankAccount account) throws BusinessException {
		// TODO Auto-generated method stub
		int conn = 0;
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "insert into dutybank.accounts (account_id, account_type, user_id, balance, interest_rate, open_date) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account.getAccountid());
			preparedStatement.setString(2, account.getAccounttype());
			preparedStatement.setInt(3, account.getClientid());
			preparedStatement.setDouble(4, account.getAccountbalance());
			preparedStatement.setDouble(5, account.getAccountrate());
			preparedStatement.setDate(6, new java.sql.Date(account.getAccountopen().getTime()));
			
			conn = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Internal Error Ocurred...");
		}
		return conn;
	}

	@Override
	public double viewBalance(int accountid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankAccount makeDeposit(BankTransaction t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount makeWithdraw(BankTransaction t) {
		// TODO Auto-generated method stub
		return null;
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

}

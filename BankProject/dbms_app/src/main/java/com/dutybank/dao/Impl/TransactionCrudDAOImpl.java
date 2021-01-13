package com.dutybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutybank.dao.TransactionCrudDAO;
import com.dutybank.dao.dbutil.PostgresqlConnection;
import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankTransaction;

public class TransactionCrudDAOImpl implements TransactionCrudDAO {

	@Override
	public BankTransaction retrieveTransaction(int account_id) throws BusinessException {
		// TODO Auto-generated method stub
		BankTransaction transaction = null;
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select transaction_id, account_id, transaction_type, amount, transaction_date from dutybank.transactions where account_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				transaction = new BankTransaction();
				transaction.setTransactionid(resultSet.getInt("transaction_id"));
				transaction.setAccountid(resultSet.getInt("account_id"));
				transaction.setTransactiontype(resultSet.getString("transaction_type"));
				transaction.setTransactionamount(resultSet.getDouble("amount"));
				transaction.setTransactiondate(resultSet.getDate("transaction_date"));
				
			} else {
				throw new BusinessException("Some Internal Error Occurred!");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Some exception has occurred while fetching transactions");
		}
		return transaction;
	}

	@Override
	public int createTransaction(BankTransaction transaction) throws BusinessException {
		// TODO Auto-generated method stub
		int tran = 0;
		
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "insert into dutybank.transactions (account_id, transaction_type, amount, transaction_date) values(?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transaction.getAccountid());
			preparedStatement.setString(2, transaction.getTransactiontype());
			preparedStatement.setDouble(3, transaction.getTransactionamount());
			preparedStatement.setDate(4, new java.sql.Date(transaction.getTransactiondate().getTime()));

			
			tran = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some internal error has occurred while inserting data");
		}
		

		return tran;
	}

	@Override
	public List<BankTransaction> getAllTransactions() throws BusinessException {
		// TODO Auto-generated method stub
		BankTransaction bankTransaction = null;
		List<BankTransaction> bankTransactionList = new ArrayList<>();
		Connection connection;

		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select transaction_id, account_id, transaction_type, amount, transaction_date from dutybank.transactionss";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				bankTransaction = new BankTransaction();
				bankTransaction.setTransactionid(resultSet.getInt("transaction_id"));
				bankTransaction.setAccountid(resultSet.getInt("account_id"));
				bankTransaction.setTransactiontype(resultSet.getString("transaction_type"));
				bankTransaction.setTransactionamount(resultSet.getDouble("amount"));
				bankTransaction.setTransactiondate(resultSet.getDate("transaction_date"));

				bankTransactionList.add(bankTransaction);
			} 
			
			if (bankTransactionList.size() == 0) {
				throw new BusinessException("There is not data to retrieve");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some Error ocurred retrieving data for transactions");
		}
		
		return bankTransactionList;
	}

	@Override
	public List<BankTransaction> getAllTransactionsById(int account_id) throws BusinessException {
		// TODO Auto-generated method stub
		List<BankTransaction> bankTransactionList = new ArrayList<>();
		BankTransaction transaction = null;
		Connection connection;
		try {
			connection = PostgresqlConnection.getConnection();
			String sql = "select transaction_id, account_id, transaction_type, amount, transaction_date from dutybank.transactions where account_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				transaction = new BankTransaction();
				transaction.setTransactionid(resultSet.getInt("transaction_id"));
				transaction.setAccountid(resultSet.getInt("account_id"));
				transaction.setTransactiontype(resultSet.getString("transaction_type"));
				transaction.setTransactionamount(resultSet.getDouble("amount"));
				transaction.setTransactiondate(resultSet.getDate("transaction_date"));

				
				bankTransactionList.add(transaction);

				
			} 
			
			if (bankTransactionList.size() == 0) {
				throw new BusinessException("No data for accounts");
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Some exception retrieving tha data has occurred in transactions");
		}
		return bankTransactionList;
	}



}

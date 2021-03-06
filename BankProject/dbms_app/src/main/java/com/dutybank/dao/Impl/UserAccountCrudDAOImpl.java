package com.dutybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dutybank.dao.UserAccountCrudDAO;
import com.dutybank.dao.dbutil.PostgresqlConnection;
import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankUserAccount;

public class UserAccountCrudDAOImpl implements UserAccountCrudDAO {

	@Override
	public int createUserAccount(BankUserAccount userAccount) throws BusinessException {
		// TODO Auto-generated method stub
		int ua = 0;
		
		try {
			Connection connection = PostgresqlConnection.getConnection();
			String sql = "insert into dutybank.users_accounts (user_id, account_id) values(?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userAccount.getClientid());
			preparedStatement.setInt(2, userAccount.getAccountid());

			
			ua = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Some internal error has occurred while inserting data");
		}
		

		return ua;
	}

}

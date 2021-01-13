package com.dutybank.logic.Impl;

import java.sql.SQLException;

import com.dutybank.dao.AccountCrudDAO;
import com.dutybank.dao.Impl.AccountCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.AccountCrudLogic;
import com.dutybank.model.BankAccount;

public class AccountCrudLogicImpl implements AccountCrudLogic {

	@Override
	public BankAccount retrieveAccount(int user_id) throws BusinessException {
		// TODO Auto-generated method stub
		BankAccount account = null;
		AccountCrudDAO daoAccount = new AccountCrudDAOImpl();
		
		account = daoAccount.retrieveAccount(user_id);
		
		if (account!=null) {
			return account;
		} else {
			throw new BusinessException("Invalid account...");
		}
	}

	@Override
	public int createAccount(BankAccount account) throws ClassNotFoundException, SQLException, BusinessException {
		// TODO Auto-generated method stub
		int ac = 0;
		AccountCrudDAO daoAccount = new AccountCrudDAOImpl();
		
		if (account!=null) {
			ac = daoAccount.createAccount(account);
		}
		
		return ac;
	}

}

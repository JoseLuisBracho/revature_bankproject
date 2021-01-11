package com.dutybank.logic.Impl;

import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.LogInCrudDAO;
import com.dutybank.dao.Impl.ClientCrudDAOImpl;
import com.dutybank.dao.Impl.LogInCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.ClientCrudLogic;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankTransaction;
import com.dutybank.model.UserLogIn;

public class ClientCrudLogicImpl implements ClientCrudLogic {

	@Override
	public int createNewAccount(BankAccount account) throws BusinessException {
		// TODO Auto-generated method stub
		int acc = 0;
		ClientCrudDAO dao = new ClientCrudDAOImpl();
		if (account!=null) {
			acc = dao.createNewAccount(account);
		} else {
			throw new BusinessException("Invalid account, try again");
		}

		return acc;
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

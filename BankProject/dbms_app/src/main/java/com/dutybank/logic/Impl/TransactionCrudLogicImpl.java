package com.dutybank.logic.Impl;

import com.dutybank.dao.TransactionCrudDAO;
import com.dutybank.dao.Impl.TransactionCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.TransactionCrudLogic;
import com.dutybank.model.BankTransaction;

public class TransactionCrudLogicImpl implements TransactionCrudLogic {

	@Override
	public BankTransaction retrieveTransaction(int account_id) throws BusinessException {
		// TODO Auto-generated method stub
		BankTransaction transaction = null;
		TransactionCrudDAO daoTransaction = new TransactionCrudDAOImpl();
		
		transaction = daoTransaction.retrieveTransaction(account_id);
		
		if (transaction!=null) {
			return transaction;
		} else {
			throw new BusinessException("Invalid transactions...");
		}
	}

	@Override
	public int createTransaction(BankTransaction transaction) throws BusinessException {
		// TODO Auto-generated method stub
		int tran = 0;
		TransactionCrudDAO daoTransaction = new TransactionCrudDAOImpl();
		
		if (transaction!=null) {
			tran = daoTransaction.createTransaction(transaction);
		}
		
		return tran;
	}

	
}

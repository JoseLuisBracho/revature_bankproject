package com.dutybank.dao;

import java.util.List;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankTransaction;

public interface TransactionCrudDAO {
	
	public BankTransaction retrieveTransaction(int account_id) throws BusinessException;
	public int createTransaction(BankTransaction transaction) throws BusinessException;
	public List<BankTransaction> getAllTransactions() throws BusinessException;
	public List<BankTransaction> getAllTransactionsById(int account_id) throws BusinessException;
	
}

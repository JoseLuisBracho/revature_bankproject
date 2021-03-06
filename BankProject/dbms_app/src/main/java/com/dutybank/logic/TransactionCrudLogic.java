package com.dutybank.logic;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankTransaction;

public interface TransactionCrudLogic {
	public BankTransaction retrieveTransaction(int account_id) throws BusinessException;
	public int createTransaction(BankTransaction transaction) throws BusinessException;

}

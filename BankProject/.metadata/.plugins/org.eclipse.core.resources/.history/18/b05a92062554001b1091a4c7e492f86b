package com.dutybank.dao;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankTransaction;

public interface ClientCrudDAO {
	public int createNewAccount(BankAccount account) throws BusinessException;
	public double viewBalance(int accountid);
	public BankAccount makeDeposit(BankTransaction t);
	public BankAccount makeWithdraw(BankTransaction t);
	public BankAccount postTranfer();
	public BankAccount acceptTranfer();

}

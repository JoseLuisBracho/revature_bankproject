package com.dutybank.logic;

import java.sql.SQLException;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;

public interface AccountCrudLogic {
	
	public BankAccount retrieveAccount(int user_id) throws BusinessException;
	public int createAccount(BankAccount account) throws ClassNotFoundException, SQLException, BusinessException;

}

package com.dutybank.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;

public interface AccountCrudDAO {
	
	public BankAccount retrieveAccount(int user_id) throws BusinessException;
	public int createAccount(BankAccount account) throws ClassNotFoundException, SQLException, BusinessException;
	public int updateAccountBalance(int account_id, double balance) throws BusinessException;
	public Map<String, String> viewAnAccount(String legalid) throws BusinessException;
	public List<BankAccount> getAllAccountsById(int user_id) throws BusinessException;

}

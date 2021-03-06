package com.dutybank.logic;

import java.util.List;
import java.util.Map;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankClient;
import com.dutybank.model.BankUserAccount;
import com.dutybank.model.UserLogIn;

public interface OfficerCrudLogic {
	
	public int createClient(BankClient client) throws BusinessException;
	public Map<String, String> viewClientAccount(String legalid) throws BusinessException;
	public void viewAllTransaction() throws BusinessException;
	public void approveNewAccount(boolean active);
	public int createLogin(UserLogIn user) throws BusinessException;
	public int createUserAccount(BankUserAccount userAccount) throws BusinessException;
	public List<BankAccount> getAllAccounts() throws BusinessException;

}

package com.dutybank.dao;

import java.util.List;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankClient;

public interface ClientCrudDAO {

	public BankClient retreiveClient(int login_id) throws BusinessException;
	public double viewBalance(int accountid);
	public BankAccount postTranfer();
	public BankAccount acceptTranfer();
	public int createClient(BankClient client) throws BusinessException;
	public List<BankClient> getAllClients() throws BusinessException;

}

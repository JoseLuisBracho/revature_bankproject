package com.dutybank.logic.Impl;

import org.apache.log4j.Logger;

import com.dutybank.dao.AccountCrudDAO;
import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.TransactionCrudDAO;
import com.dutybank.dao.Impl.AccountCrudDAOImpl;
import com.dutybank.dao.Impl.ClientCrudDAOImpl;
import com.dutybank.dao.Impl.TransactionCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.ClientCrudLogic;
import com.dutybank.model.BankClient;
import com.dutybank.model.BankTransaction;

public class ClientCrudLogicImpl implements ClientCrudLogic {
	
	private static Logger log=Logger.getLogger(ClientCrudLogicImpl.class);

	@Override
	public BankClient retreiveClient(int login_id) throws BusinessException {
		// TODO Auto-generated method stub
		BankClient client = null;
		ClientCrudDAO daoClient = new ClientCrudDAOImpl();
		
		client = daoClient.retreiveClient(login_id);
		
		if (client!=null) {
			return client;
		} else {
			throw new BusinessException("Invalid client...");
		}
	}

	@Override
	public double viewBalance(int accountid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makeDeposit(int clientid, BankTransaction transaction) throws BusinessException {
		// TODO Auto-generated method stub
		AccountCrudDAO daoAccDep = new AccountCrudDAOImpl();
		TransactionCrudDAO daoTranDep = new TransactionCrudDAOImpl();
		
		boolean activeAccount = daoAccDep.retrieveAccount(clientid).isAccountactive();
		
		if (activeAccount == true) {
			if (transaction!=null && transaction.getTransactionamount() > 0) {
				daoTranDep.createTransaction(transaction);
			} else {
				throw new BusinessException("The amount to deposit must be not negative");
			}
			
			int accountId = daoAccDep.retrieveAccount(clientid).getAccountid();
			
			double balance = daoAccDep.retrieveAccount(clientid).getAccountbalance() + transaction.getTransactionamount();
			
			daoAccDep.updateAccountBalance(accountId, balance);
			
		} else {log.info("This account is not active, please contact a bank officer");}
		
		
		
	}

	@Override
	public void makeWithdraw(int clientid, BankTransaction transaction) throws BusinessException {
		// TODO Auto-generated method stub
		AccountCrudDAO daoAccWith = new AccountCrudDAOImpl();
		TransactionCrudDAO daoTranWith = new TransactionCrudDAOImpl();
		
		int accountId = daoAccWith.retrieveAccount(clientid).getAccountid();
		
		boolean activeAccount = daoAccWith.retrieveAccount(clientid).isAccountactive(); //////////
		
		if (activeAccount == true) {
			if (transaction.getTransactionamount() <= daoAccWith.retrieveAccount(clientid).getAccountbalance()) {
				
				if (transaction!=null && transaction.getTransactionamount() > 0) {
	
						daoTranWith.createTransaction(transaction);
	
				} else {
					throw new BusinessException("The amount to deposit must be not negative");
				}
				
				double balance = daoAccWith.retrieveAccount(clientid).getAccountbalance() - transaction.getTransactionamount();
			
				daoAccWith.updateAccountBalance(accountId, balance);
				
			} else {
				throw new BusinessException("The amount to withdraw is greater than your balance");
			}
			
		} else {log.info("This account is not active, please contact a bank officer");}
		
	}

	@Override
	public BankTransaction postTranfer(String email, double money) {
		// TODO Auto-generated method stub
		return null;
	}




}

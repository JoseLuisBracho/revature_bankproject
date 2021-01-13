package com.dutybank.logic.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.dutybank.dao.AccountCrudDAO;
import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.LogInCrudDAO;
import com.dutybank.dao.TransactionCrudDAO;
import com.dutybank.dao.UserAccountCrudDAO;
import com.dutybank.dao.Impl.AccountCrudDAOImpl;
import com.dutybank.dao.Impl.ClientCrudDAOImpl;
import com.dutybank.dao.Impl.LogInCrudDAOImpl;
import com.dutybank.dao.Impl.TransactionCrudDAOImpl;
import com.dutybank.dao.Impl.UserAccountCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.OfficerCrudLogic;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankClient;
import com.dutybank.model.BankTransaction;
import com.dutybank.model.BankUserAccount;
import com.dutybank.model.UserLogIn;

public class OfficerCrudLogicImpl implements OfficerCrudLogic {
	
	private static Logger log=Logger.getLogger(OfficerCrudLogicImpl.class);

	@Override
	public int createClient(BankClient client) throws BusinessException {
		// TODO Auto-generated method stub
		int cl = 0;
		ClientCrudDAO daoClient = new ClientCrudDAOImpl();
		
		if (client!=null) {
			cl = daoClient.createClient(client);
		}
		
		return cl;
	}

	@Override
	public Map<String, String> viewClientAccount(String legalid) throws BusinessException {
		// TODO Auto-generated method stub
		Map<String, String> viewAccMap = new LinkedHashMap<>();
		AccountCrudDAO daoViewAcc = new AccountCrudDAOImpl();
		
		if (legalid!=null) {
			
			viewAccMap = daoViewAcc.viewAnAccount(legalid);
		}
		return viewAccMap;
	}

	@Override
	public void approveNewAccount(boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createLogin(UserLogIn user) throws BusinessException {
		// TODO Auto-generated method stub
		int ac = 0;
		LogInCrudDAO daoLogin = new LogInCrudDAOImpl();
		
		if (user!=null) {
			ac = daoLogin.createLogin(user);
		}
		
		return ac;
	}

	@Override
	public int createUserAccount(BankUserAccount userAccount) throws BusinessException {
		// TODO Auto-generated method stub
		int ua = 0;
		UserAccountCrudDAO daoUserAccount = new UserAccountCrudDAOImpl();
		
		if (userAccount!=null) {
			ua = daoUserAccount.createUserAccount(userAccount);
		}
		
		return ua;
	}

	@Override
	public List<BankAccount> getAllAccounts() throws BusinessException {
		// TODO Auto-generated method stub
		List<BankAccount> allAccountList = new ArrayList<>();
		
		return allAccountList;
	}

	@Override
	public void viewAllTransaction() throws BusinessException {
		// TODO Auto-generated method stub
		BankClient bankClient = new BankClient();
		// BankAccount bankAccount = new BankAccount();
		List<BankAccount> bankAccounts = new ArrayList<>();
		List<BankTransaction> bankTransactions = new ArrayList<>();
		List<UserLogIn> bankLogins = new ArrayList<>();
		
		ClientCrudDAO daoClients = new ClientCrudDAOImpl();
		LogInCrudDAO daoLogins = new LogInCrudDAOImpl();
		AccountCrudDAO daoAccounts = new AccountCrudDAOImpl();
		TransactionCrudDAO daoTransactions = new TransactionCrudDAOImpl();
		
		//bankClients = daoClients.getAllClients();
		bankLogins = daoLogins.retriveAllUsers();
		
		
		List<UserLogIn> allClients = bankLogins.stream().filter(user->user.getUser_type().equals("client")).collect(Collectors.toList());
		
		log.debug("*********** All clients *************");
		for (UserLogIn userLogIn : allClients) {
			log.debug(userLogIn);
		}
		
		if (allClients.size()>0) {
			for (UserLogIn cl: allClients) {
				bankClient = daoClients.retreiveClient(cl.getLogin_id());
				log.debug("\n************** Account ************");
				bankAccounts = daoAccounts.getAllAccountsById(bankClient.getClientid());
				log.debug(bankAccounts);
				
				if (bankAccounts.size()>0) {
					for (BankAccount ba : bankAccounts) {
						log.debug(ba);
						log.debug("\n************** Transactions ************");
						bankTransactions = daoTransactions.getAllTransactionsById(ba.getAccountid());
						
						if (bankTransactions.size()>0) {
							for (BankTransaction bt : bankTransactions) {
								log.debug(bt);
							}
						} else {log.debug("No transaction for this account");}
					} 
					
				} else {log.debug("No accounts for this client");}
				
			}
		} else {log.debug("No clients in this bank");}
		
	}


}

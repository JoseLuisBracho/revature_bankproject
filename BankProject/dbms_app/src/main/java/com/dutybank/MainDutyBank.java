package com.dutybank;

import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dutybank.dao.ClientCrudDAO;
import com.dutybank.dao.Impl.ClientCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.ClientCrudLogic;
import com.dutybank.logic.LogInCrudLogic;
import com.dutybank.logic.Impl.ClientCrudLogicImpl;
import com.dutybank.logic.Impl.LogInCrudLogicImpl;
import com.dutybank.model.BankAccount;
import com.dutybank.model.UserLogIn;
import com.dutybank.utils.MenusDutyBank;

public class MainDutyBank {
	
	private static Logger log=Logger.getLogger(MainDutyBank.class);;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LogInCrudLogic logica = new LogInCrudLogicImpl();
		
		ClientCrudLogic logic = new ClientCrudLogicImpl();
		
		ClientCrudDAO daoLogic = new ClientCrudDAOImpl();
		
		int enter = 0;
		login.menuShow();
		
		//************************************************************************* LEVEL 0 ********************************************************************
		do {
			log.debug("Please type your option");
			try {
				enter = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.debug("Only a number between 1 - 3 is allowed, please try again");
				login.menuShow();
			}
			
			switch (enter) {
			case 1:
					log.debug("Enter your email");
					String email = sc.nextLine();
					log.debug("Enter your password");
					String password = sc.nextLine();
					
					try {
						UserLogIn user = logica.retrieveUser(email);
						
						if (user!=null) {
							log.info("User found with " + email + " details of the client are :");
							log.info(user);
						}
						
						client.menuShow();
						
						int entclient = 0;
						//********************************************************** LEVEL 1 *********************************************************************
						do {
							log.debug("\nPlease enter your choice");
							try {
								entclient = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.error("Only a number between 1 - 7 is allowed, please try again");
								client.menuShow();
							}
							
							switch (entclient) {
							case 1:
								int accountid = 0;
								String accounttype = "";
								int clientid = 0;
								double accountbalance = 0.0;
								double accountrate = 0.0;
								Date accountopen;
								
								log.debug("Enter Account Id");
								try {
									accountid = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.error("Only an integer is allowed, please try again");
								}
								log.debug("Enter the account type you want");
								accounttype = sc.nextLine();
								clientid = user.getUser_id();
								log.debug("Enter the amount you want deposit");
								try {
									accountbalance = Double.parseDouble(sc.nextLine());
								} catch (NumberFormatException e) {
									log.error("Only an numeric is allowed, please try again");
								}
								if (accounttype.toLowerCase().equals("savings")) {
									accountrate = 0.0375;
								} else {
									accountrate = 0.0;
								}
								accountopen = new Date();
								
								BankAccount newaccount = new BankAccount(accountid, accounttype, clientid, accountbalance, accountrate, accountopen);
								log.debug("New account: " +newaccount);
								
									if (daoLogic.createNewAccount(newaccount)!=0) {
										log.info("Account created successfully");
									} else {
										throw new BusinessException("Something wrong creating an account");
									}
								
								break;

							default:
								break;
							}
							
						} while (entclient!=7); 
						
						
					} catch (BusinessException e) {
						log.error(e.getMessage());
						login.menuShow();
					}
					
					enter = 3;
					
				break;

			case 2:
				log.debug("Working in this option");
				break;
			
			case 3:
				log.debug("Thank you for visiting us!");
				break;
				
			default:
				break;
			}
			
		} while (enter!=3);

		
		sc.close();
		
		
		
		
		
		
		
		
		
		
//		
//		switch (entclient) {
//		case 1:
//			do {
//				client.menuShow();
//				System.out.println("Please choose your option");
//				entclient = Integer.parseInt(sc.nextLine());
//				System.out.println("you pressed"+entclient);
//			} while (entclient!=7);
//			
//			
//			break;
//			
//		case 2:
//			officer.menuShow();
//			
//			break;
//			
//
//		default:
//			System.out.println("Invalid Menu Option...Please try again");
//			break;
//		}
	
	}
	
	static MenusDutyBank login = () -> {
		printDb();
		log.debug("\nWelcome to DutyBank Management System");
		log.debug("\n\n********************** LOG IN ****************************");
		log.debug("****************** Select your Option ********************");
		log.debug("\n     1. Log In");
		log.debug("     2. Sign Up");
		log.debug("     3. EXIT");
	};
	
	static MenusDutyBank client = () -> {
		printDb();
		log.debug("\n************* DutyBank Client Options Menu ***************");
		log.debug("\n     1. Open a New Account");
		log.debug("     2. Deposit Money");
		log.debug("     3. Withdraw Money");
		log.debug("     4. View Balance");
		log.debug("     5. Post Money to Transfer");
		log.debug("     6. Accept Money from Transfer");
		log.debug("     7. EXIT");
	};
	
	static MenusDutyBank officer = () -> {
		printDb();
		log.debug("\n******** Welcome to DutyBank Officer Options Menu ********");
		log.debug("\n     1. Approve a New Account");
		log.debug("     2. View an Account");
		log.debug("     3. View All Transactions");
		log.debug("     4. EXIT");
	};
	
 
	static void printDb() {
		log.debug("     DUTY");
		log.debug("     BANK");
	}
	
}

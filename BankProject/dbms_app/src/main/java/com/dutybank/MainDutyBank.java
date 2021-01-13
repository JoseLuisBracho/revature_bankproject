package com.dutybank;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dutybank.dao.UserAccountCrudDAO;
import com.dutybank.dao.Impl.UserAccountCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.AccountCrudLogic;
import com.dutybank.logic.ClientCrudLogic;
import com.dutybank.logic.LogInCrudLogic;
import com.dutybank.logic.OfficerCrudLogic;
import com.dutybank.logic.TransactionCrudLogic;
import com.dutybank.logic.Impl.AccountCrudLogicImpl;
import com.dutybank.logic.Impl.ClientCrudLogicImpl;
import com.dutybank.logic.Impl.LogInCrudLogicImpl;
import com.dutybank.logic.Impl.OfficerCrudLogicImpl;
import com.dutybank.logic.Impl.TransactionCrudLogicImpl;
import com.dutybank.model.BankAccount;
import com.dutybank.model.BankClient;
import com.dutybank.model.BankTransaction;
import com.dutybank.model.BankUserAccount;
import com.dutybank.model.UserLogIn;
import com.dutybank.utils.MenusDutyBank;

public class MainDutyBank {
	
	private static Logger log=Logger.getLogger(MainDutyBank.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LogInCrudLogic logica = new LogInCrudLogicImpl();
		
		ClientCrudLogic logic = new ClientCrudLogicImpl();
		
		AccountCrudLogic accLogic = new AccountCrudLogicImpl();
		
		TransactionCrudLogic tranLogic = new TransactionCrudLogicImpl();
		
		UserAccountCrudDAO daoUserAcc = new UserAccountCrudDAOImpl();
		
		OfficerCrudLogic offLogic = new OfficerCrudLogicImpl();
		
		
		int enter = 0;
		
		//************************************************************************* LEVEL 0 ********************************************************************
		do {
			login.menuShow();
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
					
					int chClient = 0;
					int chOfficer = 0;
					
					try {
						UserLogIn user = logica.retrieveUserLogic(email, password);
														
						if (user.getUser_type().toLowerCase().equals("client") && client!=null) {
							
							BankClient cliente = logic.retreiveClient(user.getLogin_id());
							
							log.info("Hello " + cliente.getClientname());
							log.info("Estimated client, welcome to DutyBank\n");
							
							//********************************************************** LEVEL 1 *********************************************************************
							do {
								client.menuShow();
								log.debug("Please select your option");
								try {
									chClient = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.debug("Only a number between 1 - 3 is allowed, please try again");
									login.menuShow();
								}
							
								switch (chClient) {
								case 1:
									
									log.debug("Enter the amount you want deposit");
									double amountDep = Double.parseDouble(sc.nextLine());
									
									int clientId = cliente.getClientid();
									
									BankAccount accountDep = accLogic.retrieveAccount(clientId);
									
									int accountIdDep = accountDep.getAccountid();
									
									log.debug("your current balance is: " + accountDep.getAccountbalance() + " mangoes\n");
									
									BankTransaction tranDep = new BankTransaction(accountIdDep, "deposit", amountDep, new Date());
									
									if (tranDep!=null) {
										logic.makeDeposit(clientId, tranDep);
									}										
									log.debug("Your deposit is ready");

									break;
									
								case 2:
									log.debug("Enter the amount you want withdraw");
									double amountWith = Double.parseDouble(sc.nextLine());
									
									BankAccount accountWith = accLogic.retrieveAccount(cliente.getClientid());
									
									int accountIdWith = accountWith.getAccountid();
									
									log.debug("your current balance is: " + accountWith.getAccountbalance() + " mangoes\n");
									
									BankTransaction tranWith = new BankTransaction(accountIdWith, "withdraw", amountWith, new Date());
									
									if (tranWith!=null) {
										logic.makeWithdraw(cliente.getClientid(), tranWith);
									}
									
									log.debug("You have withdrawn " + amountWith + " mangoes");

									break;
									
								case 3:
									BankAccount accountBal = accLogic.retrieveAccount(cliente.getClientid());
									
									if (accountBal!=null) {
										log.debug(cliente.getClientname());
										log.debug("your current balance is: " + accountBal.getAccountbalance() + " mangoes\n");
									}			 
									
									break;
									
								case 4:
									log.debug("Amount to tranfer");
									double amountTranf = Double.parseDouble(sc.nextLine());
									log.debug("Receiver email: ");
									String recEmail = sc.nextLine();
									
									BankAccount accountPost = accLogic.retrieveAccount(cliente.getClientid());
									
									int accountIdPost = accountPost.getAccountid();
									
									BankTransaction tranPost = new BankTransaction(accountIdPost, "transfer posted", amountTranf, new Date());
									
									if (tranPost!=null) {
										logic.makeWithdraw(cliente.getClientid(), tranPost);
									}
									
									UserLogIn userRec = logica.getClientByEmail(recEmail);
									
									BankClient clientRec = logic.retreiveClient(userRec.getLogin_id());
									
									BankAccount accountRec = accLogic.retrieveAccount(clientRec.getClientid());
									
									BankTransaction tranTran = new BankTransaction(accountRec.getAccountid(), "transfer received", amountTranf, new Date());
									
									if (tranTran!=null) {
										logic.makeDeposit(clientRec.getClientid(), tranTran);
									}
									
									log.debug("You have sent " + amountTranf + " to "+ recEmail);
									
									break;
									
								case 5:
									log.info("This facility is Still under construction, soon will be up, Sorry");
									log.debug("accept money from transfer");
									break;
									
								case 6:
									log.debug("Bye!");
									break;
	
								default:
									break;
								}
								
							} while (chClient!=6);
							
						} else {
							
							//********************************************************** LEVEL 1 *********************************************************************			
							do {
								log.info("Welcome to DutyBank officer");
								officer.menuShow();

								log.debug("Please type your option");
								try {
									chOfficer = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.debug("Only a number between 1 - 3 is allowed, please try again");
									login.menuShow();
								}
								
								switch (chOfficer) {
								case 1:
									log.debug("Enter client first name");
									String name = sc.nextLine();
									log.debug("Enter client last name");
									String lastName = sc.nextLine();
									log.debug("Enter client legal id");
									String legalid = sc.nextLine();
									log.debug("Gender - Male/Female");
									String gender = sc.nextLine();
									log.debug("Enter client contact number");
									Long contactNumber = Long.parseLong(sc.nextLine());
									
									log.debug("Enter client Birthday (MM-dd-yyyy)");
									String dateBirth = sc.nextLine();
									SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
									Date dateB = null;
									sdf.setLenient(false);
									try {
										dateB = sdf.parse(dateBirth);
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										log.error("Invalid date format");
									}
																		
									log.debug("Enter client address");
									String address = sc.nextLine();
									log.debug("Enter client nationality");
									String nationality = sc.nextLine();
									log.debug("Monthly salary?");
									Double salary = Double.parseDouble(sc.nextLine());
									
									log.debug("Enter your email");
									String newEmail = sc.nextLine();
									log.debug("Enter your password");
									String newPassword = sc.nextLine();
									log.debug("Type of user client/officer");
									String clientType = sc.nextLine();
									
									UserLogIn newUser = new UserLogIn(newEmail, newPassword, new Date(), clientType);
									
									if (offLogic.createLogin(newUser)!=0) {
										log.info("User Login created successfully\n");
									}
									
									int clientLogin = logica.retrieveUserLogic(newEmail, newPassword).getLogin_id();
									
									BankClient client = new BankClient(name, lastName, legalid, gender, dateB, address, nationality, salary, contactNumber, clientLogin);
									
									if (offLogic.createClient(client)!=0) {
										log.info("Client profile created successfully!\n");
									}
									
									int clientid = logic.retreiveClient(clientLogin).getClientid(); 
									
									log.debug("Type of account - checks/savings");
									String accounttype = sc.nextLine();
									
									log.debug("Insert the initial balance");
									Double initBalance = Double.parseDouble(sc.nextLine());
									
									double intRate = 0.0;
									if (accounttype.toLowerCase().equals("savings")) {
										intRate = 0.0375;
									} else {intRate = 0.0;}
									
									log.debug("Activate account now or later ? true/false");
									boolean active = Boolean.parseBoolean(sc.nextLine());
									
									BankAccount newAccount = new BankAccount(accounttype, clientid, initBalance, intRate, new Date(), active);
									
									try {
										if (accLogic.createAccount(newAccount)!=0) {
											log.info("Client profile created successfully!\n");
										}
									} catch (ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										log.info(e.getMessage());;
									}
													
									if (active == true) {
										
										log.debug("New client account created\n");
										
										BankAccount newAccounta = accLogic.retrieveAccount(clientid);
										
										int accountid = newAccounta.getAccountid(); 
										
										BankTransaction firstBalance = new BankTransaction(accountid, "deposit", initBalance, new Date());
										
										BankUserAccount userAccount = new BankUserAccount(clientid, accountid);
										
										if (tranLogic.createTransaction(firstBalance)!=0) {
											daoUserAcc.createUserAccount(userAccount);
											log.info("Your new account was accredited " + initBalance + " mangoes!");
										}	
									} else {log.info("Please, wait while officers check your information....\n");}
										
									
									break;
									
								case 2:
									log.info("This facility is Still under construction, soon will be up, Sorry");
									log.debug("approve an account");
									break;
									
								case 3:

									log.debug("Enter client legal id");
									String legalidForViewAcc = sc.nextLine();
									
									Map<String, String> accountMap = offLogic.viewClientAccount(legalidForViewAcc);
									
									log.debug("viewing account for legalid "+legalidForViewAcc);
									for(Entry<String, String> e : accountMap.entrySet()) {
										log.debug("Field : "+ e.getKey() +" Value : "+ e.getValue());
									}
																
									break;
									
								case 4:
									
									log.debug("Viewing all DutyBank transactions");
									
									offLogic.viewAllTransaction();
									
									break;
									
								case 5:
									log.debug("adios");
									break;
	
								default:
									break;
								}
								
							} while (chOfficer!=5);
							
						}
						
						//********************************************************** LEVEL 1 *********************************************************************
						
					} catch (BusinessException e) {
						log.error(e.getMessage());
						login.menuShow();
					}
								
				break;
			
			case 2:
				log.debug("Thank you for visiting us!");
				break;
				
			default:
				break;
			}
			
		} while (enter!=2);

		
		sc.close();
	
	}
	
	static MenusDutyBank login = () -> {
		printDb();
		log.debug("\nWelcome to DutyBank Management System");
		log.debug("\n\n********************** LOG IN ****************************");
		log.debug("****************** Select your Option ********************");
		log.debug("\n     1. Log In");
		log.debug("     2. EXIT");
	};
	
	static MenusDutyBank client = () -> {
		printDb();
		log.debug("\n************* DutyBank Client Options Menu ***************");
		log.debug("\n     1. Deposit Money");
		log.debug("     2. Withdraw Money");
		log.debug("     3. View Balance");
		log.debug("     4. Post Money to Transfer");
		log.debug("     5. Accept Money from Transfer");
		log.debug("     6. EXIT");
	};
	
	static MenusDutyBank officer = () -> {
		printDb();
		log.debug("\n******** Welcome to DutyBank Officer Options Menu ********");
		log.debug("\n     1. Open a New Client Account");
		log.debug("     2. Approve a New Account");
		log.debug("     3. View an Account");
		log.debug("     4. View All Transactions");
		log.debug("     5. EXIT");
	};
	
 
	static void printDb() {
		log.debug("     DUTY");
		log.debug("     BANK");
	}
	
}

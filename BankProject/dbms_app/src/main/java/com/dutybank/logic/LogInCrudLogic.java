package com.dutybank.logic;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.UserLogIn;

public interface LogInCrudLogic {
	
	public UserLogIn retrieveUserLogic(String email, String password) throws BusinessException; 
	public int updateUserData(int user_id, String email, String password);
	public void deleteUser(int user_id); 
	public UserLogIn getClientByEmail(String email) throws BusinessException;

}

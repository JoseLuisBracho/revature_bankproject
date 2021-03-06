package com.dutybank.dao;

import java.util.List;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.UserLogIn;

public interface LogInCrudDAO {
	
	public UserLogIn retrieveUser(String email) throws BusinessException; // Log in
	public int updateUserData(int user_id, String email, String password); // Update user data
	public void deleteUser(int user_id); // Delete a user review cause no apply to a user, it's for an bank officer
	public int createLogin(UserLogIn user) throws BusinessException;
	public List<UserLogIn> retriveAllUsers() throws BusinessException;

}

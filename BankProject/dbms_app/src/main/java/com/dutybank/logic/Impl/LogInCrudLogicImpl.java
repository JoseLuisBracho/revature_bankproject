package com.dutybank.logic.Impl;

import com.dutybank.dao.LogInCrudDAO;
import com.dutybank.dao.Impl.LogInCrudDAOImpl;
import com.dutybank.exception.BusinessException;
import com.dutybank.logic.LogInCrudLogic;
import com.dutybank.model.UserLogIn;

public class LogInCrudLogicImpl implements LogInCrudLogic {

	@Override
	public UserLogIn retrieveUserLogic(String email, String password) throws BusinessException {
		// TODO Auto-generated method stub
		UserLogIn user = null;
		LogInCrudDAO dao = new LogInCrudDAOImpl();
		if (email!=null && email.matches("[0-9a-zA-Z]{2,45}@[0-9a-zA-Z]{2,45}.[a-zA-Z]{3}")) {
			user = dao.retrieveUser(email);
		} else {
			throw new BusinessException("Invalid email address, try again");
		}
		
		if (password!=null && password.equals(user.getPassword())) {
			return user;
		} else {
			throw new BusinessException("Invalid password, try again");
		}
	}

	@Override
	public int updateUserData(int user_id, String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserLogIn getClientByEmail(String email) throws BusinessException {
		// TODO Auto-generated method stub
		UserLogIn user = null;
		LogInCrudDAO dao = new LogInCrudDAOImpl();
		if (email!=null && email.matches("[0-9a-zA-Z]{2,45}@[0-9a-zA-Z]{2,45}.[a-zA-Z]{3}")) {
			user = dao.retrieveUser(email);
		} else {
			throw new BusinessException("Invalid email address, try again");
		}
		
			return user;

	}


}

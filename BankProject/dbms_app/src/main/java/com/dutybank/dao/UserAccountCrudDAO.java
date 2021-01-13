package com.dutybank.dao;

import com.dutybank.exception.BusinessException;
import com.dutybank.model.BankUserAccount;

public interface UserAccountCrudDAO {
	public int createUserAccount(BankUserAccount userAccount) throws BusinessException;

}

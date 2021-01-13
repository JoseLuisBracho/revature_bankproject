package com.dutybank.logic.Impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dutybank.exception.BusinessException;
import com.dutybank.logic.Impl.OfficerCrudLogicImpl;

class OfficerCrudLogicImplTest {
	
	OfficerCrudLogicImpl officer = new OfficerCrudLogicImpl();
	
	
	@Test
	void testCreateClientForNull() throws BusinessException {
		assertNotNull(officer.createClient(null));
	}
	

}

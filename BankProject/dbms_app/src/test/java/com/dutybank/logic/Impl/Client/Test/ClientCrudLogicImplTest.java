package com.dutybank.logic.Impl.Client.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dutybank.exception.BusinessException;
import com.dutybank.logic.Impl.ClientCrudLogicImpl;
import com.dutybank.model.BankClient;

class ClientCrudLogicImplTest {
	
	int client_id = 3;
	ClientCrudLogicImpl oClient = new ClientCrudLogicImpl();

	@Test
	void testRetreiveClientForEquals() {
		String dob = "12-13-1989";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date clientdob = null;
		sdf.setLenient(false);
		try {
			clientdob = sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BankClient actualClient = new BankClient(7,"carmen", "pereira", "52463245", "Female", clientdob, "WHT", "WHT", 1363.3, 5658452221L, 7);
		try {
			assertEquals(actualClient, oClient.retreiveClient(client_id));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

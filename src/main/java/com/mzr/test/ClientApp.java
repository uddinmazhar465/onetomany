package com.mzr.test;

import com.mzr.dto.OToMDAO;
import com.mzr.dto.OToMDAOFactory;

public class ClientApp {

	public static void main(String[] args) {
		OToMDAO dao = OToMDAOFactory.getInstance();
		//dao.saveData();
		dao.loadData();
		//dao.addNewPhoneNumberToExistingUser();
		//dao.deleteUserWithPhoneNumber();
		//dao.deleteOnePhoneNumberOfAUser();
		//dao.deleteAllPhoneNumberOfAUser();
	}
}

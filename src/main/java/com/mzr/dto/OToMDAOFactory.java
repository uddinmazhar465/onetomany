package com.mzr.dto;

public class OToMDAOFactory {
	public static OToMDAO getInstance() {
		return new OToMDAOImpl();
	}

}

package com.mzr.dto;

public interface OToMDAO {
	public void saveData();
	public void loadData();
	public void addNewPhoneNumberToExistingUser();
	public void deleteUserWithPhoneNumber();
	public void deleteOnePhoneNumberOfAUser();
	public void deleteAllPhoneNumberOfAUser();
	public void transferPhoneNumberFromOneUserToAnotherUser();
	public void changePhoneNumberProviderForExistingUser();

}

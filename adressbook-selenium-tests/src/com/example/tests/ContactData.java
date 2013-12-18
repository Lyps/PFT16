package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhoneFirst;
	public String mobilePhone;
	public String workPhone;
	public String mailFirst;
	public String mailSecond;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String groupForContact;
	public String addressSecond;
	public String homePhoneSecond;

	public ContactData() {		
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhoneFirst, String mobilePhone, String workPhone,
			String mailFirst, String mailSecond, String birthDay,
			String birthMonth, String birthYear, String groupForContact,
			String addressSecond, String homePhoneSecond) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhoneFirst = homePhoneFirst;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.mailFirst = mailFirst;
		this.mailSecond = mailSecond;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.groupForContact = groupForContact;
		this.addressSecond = addressSecond;
		this.homePhoneSecond = homePhoneSecond;
	}
}
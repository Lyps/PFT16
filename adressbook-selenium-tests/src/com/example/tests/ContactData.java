package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address;
	private String homePhoneFirst;
	private String mobilePhone;
	private String workPhone;
	private String mailFirst;
	private String mailSecond;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String groupForContact;
	private String addressSecond;
	private String homePhoneSecond;

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


	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}	
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withHomePhoneFirst(String homePhoneFirst) {
		this.homePhoneFirst = homePhoneFirst;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}
	
	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}
	
	public ContactData withMailFirst(String mailFirst) {
		this.mailFirst = mailFirst;
		return this;
	}
	
	public ContactData withMailSecond(String mailSecond) {
		this.mailSecond = mailSecond;
		return this;
	}	
	
	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}
	
	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}
	
	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	
	
	public ContactData withGroupForContact(String groupForContact) {
		this.groupForContact = groupForContact;
		return this;
	}
	
	
	public ContactData withAddressSecond(String addressSecond) {
		this.addressSecond = addressSecond;
		return this;
	}
	
	public ContactData withHomePhoneSecond(String homePhoneSecond) {
		this.homePhoneSecond = homePhoneSecond;
		return this;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhoneFirst() {
		return homePhoneFirst;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getMailFirst() {
		return mailFirst;
	}

	public String getMailSecond() {
		return mailSecond;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}
	
	public String getGroupForContact() {
		return groupForContact;
	}	

	public String getAddressSecond() {
		return addressSecond;
	}

	public String getHomePhoneSecond() {
		return homePhoneSecond;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result	+ ((idContact == null) ? 0 : idContact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", homePhoneFirst=" + homePhoneFirst
				+ ", mobilePhone=" + mobilePhone + ", workPhone=" + workPhone
				+ ", mailFirst=" + mailFirst + ", mailSecond=" + mailSecond
				+ ", birthDay=" + birthDay + ", birthMonth=" + birthMonth
				+ ", birthYear=" + birthYear + ", groupForContact="
				+ groupForContact + ", addressSecond=" + addressSecond
				+ ", homePhoneSecond=" + homePhoneSecond + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		int result = 0;
		int resultLastName = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (resultLastName != 0)
			return resultLastName;
		int resultFirstName = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (resultFirstName != 0)
			return resultFirstName;
		return result;
	}
	
}	
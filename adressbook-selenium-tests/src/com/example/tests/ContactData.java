package com.example.tests;

public class ContactData implements Comparable<ContactData>{
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
	public String firstPlusLastName;	

	public ContactData() {		
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhoneFirst, String mobilePhone, String workPhone,
			String mailFirst, String mailSecond, String birthDay,
			String birthMonth, String birthYear, String groupForContact,
			String addressSecond, String homePhoneSecond, 
			String firstPlusLastName) {
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
		this.firstPlusLastName = firstPlusLastName;		
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
		if (firstPlusLastName == null) {
			if (other.firstPlusLastName != null)
				return false;
		} else if (!firstPlusLastName.equals(other.firstPlusLastName))
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
				+ ", homePhoneSecond=" + homePhoneSecond + ", firstPlusLastName=" 
				+ firstPlusLastName + "]";
	}

	@Override
	public int compareTo(ContactData other) {		
		return this.firstPlusLastName.toLowerCase().compareTo(other.firstPlusLastName.toLowerCase());
	}	
	
}
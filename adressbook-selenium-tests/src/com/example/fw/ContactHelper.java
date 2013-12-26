package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.homePhoneFirst);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.mailFirst);
	    type(By.name("email2"), contact.mailSecond);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
        //selectByText(By.name("new_group"), contact.groupForContact);
	    type(By.name("address2"), contact.addressSecond);
	    type(By.name("phone2"), contact.homePhoneSecond);
	}

	public void initNewContact() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));	
	}
	
	public void selectContactByEdit(int index) {
		//click(By.xpath("//input[@name='selected[]'][" + index +"]"));
		driver.get(manager.baseUrl + "/addressbookv4.1.4/edit.php?id=" + index);
	}
	
	public void submitContactModification() {
		click(By.name("update"));
		
	}
	
}

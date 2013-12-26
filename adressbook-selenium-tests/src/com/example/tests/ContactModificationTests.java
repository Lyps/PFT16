package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().selectContactByEdit(6);
		ContactData contact = new ContactData();
		contact.firstName = "new first name";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}

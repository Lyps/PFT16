package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewContact();
    ContactData contact = new ContactData();
    contact.firstName = "First Name";
	contact.lastName = "Last Name";
	contact.address = "Address 1";
	contact.homePhoneFirst = "111-111-1";
	contact.mobilePhone = "22-222-22";
	contact.workPhone = "333-333-3";
	contact.mailFirst = "mail1@mail1.ls";
	contact.mailSecond = "mail2@mail2.ls";
	contact.birthDay = "1";
	contact.birthMonth = "January";
	contact.birthYear = "1990";
	contact.groupForContact = "group 1";
	contact.addressSecond = "Address 2";
	contact.homePhoneSecond = "123-456-7";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  
}

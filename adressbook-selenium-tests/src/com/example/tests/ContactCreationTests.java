package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContact();
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
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContact();
    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    submitContactCreation();
    returnToHomePage();
  }
  
}

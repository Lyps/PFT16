package com.example.fw;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData>contacts = new SortedListOf<ContactData>();		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (int i = 0; i < rows.size(); i++) {
				WebElement row = rows.get(i);
				String firstName = row.findElement(By.xpath("./td[3]")).getText();	
				String lastName = row.findElement(By.xpath("./td[2]")).getText();
				if (firstName == null)
					firstName = "";
				if (lastName == null)
					lastName = "";	
				//String homePhoneFirst = row.findElement(By.xpath("./td[5]")).getText();		
				contacts.add(new ContactData()											
											.withFirstName(firstName)
											.withLastName(lastName)											
		  									.withAddress("")
		  									.withHomePhoneFirst("")
		  									.withMobilePhone("")
		  									.withWorkPhone("")
		  									.withMailFirst("")
		  									.withMailSecond("")
		  									.withBirthDay("")
		  									.withBirthMonth("")
		  									.withBirthYear("")
		  									.withGroupForContact("") 
		  									.withAddressSecond("")
		  									.withHomePhoneSecond("")
		  									.withAddressSecond(""));
		}
		return contacts;
	}
	
	
	/*
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getUiContacts() {
		if (cachedContacts == null)
			rebuildCacheContacts();
		return cachedContacts;
	}
			
	private void rebuildCacheContacts() {
		cachedContacts = new SortedListOf<ContactData>();		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (int i = 0; i < rows.size(); i++) {
				WebElement row = rows.get(i);
				String firstName = row.findElement(By.xpath("./td[3]")).getText();	
				String lastName = row.findElement(By.xpath("./td[2]")).getText();
				if (firstName == null)
					firstName = "";
				if (lastName == null)
					lastName = "";	
				//String homePhoneFirst = row.findElement(By.xpath("./td[5]")).getText();	длд			
				cachedContacts.add(new ContactData()											
											.withFirstName(firstName)
											.withLastName(lastName)											
		  									.withAddress("")
		  									.withHomePhoneFirst("")
		  									.withMobilePhone("")
		  									.withWorkPhone("")
		  									.withMailFirst("")
		  									.withMailSecond("")
		  									.withBirthDay("")
		  									.withBirthMonth("")
		  									.withBirthYear("")
		  									.withGroupForContact("") 
		  									.withAddressSecond("")
		  									.withHomePhoneSecond("")
		  									.withAddressSecond(""));
		}
	}
	*/
	
	public ContactHelper createContact(ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
    	initNewContact();    
		fillContactForm(contact,CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	//rebuildCacheContacts();
    	manager.getModel().addContact(contact);
		return this;		
	}	

	public ContactHelper contactModify(ContactData contact, int index, boolean formType) {
		manager.navigateTo().mainPage();
		selectContactByEdit(index);
		fillContactForm(contact,MODIFICATION);
		submitContactModification();
		returnToHomePage();
		//rebuildCacheContacts();
		manager.getModel().removeContact(index).addContact(contact);
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		selectContactByEdit(index);
		submitContactDeletion();
		returnToHomePage();		
		//rebuildCacheContacts();
		manager.getModel().removeContact(index);
		return this;
	}

//---------------------------------------------------------------------------

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHomePhoneFirst());
	    type(By.name("mobile"), contact.getMobilePhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getMailFirst());
	    type(By.name("email2"), contact.getMailSecond());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
        if (formType == CREATION) {
        	// selectByText(By.name("new_group"), contact.getGroupForContact()); или "group 1"
        } else {
        	//if (driver.findElements(By.name("new_group")).size() != 0) {
        	  if (isElementPresent()) {
        		throw new Error("group selector exists in contact modification form");
        	}
        }	    
	    type(By.name("address2"), contact.getAddressSecond());
	    type(By.name("phone2"), contact.getHomePhoneSecond());	   
	    return this;
	}

	public ContactHelper initNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		//cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper selectContactByEdit(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));		
		return this;	
	}
	
	public ContactHelper submitContactModification() {
		click(By.name("update"));
		//cachedContacts = null;
		return this;
	}
	
	private ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		//cachedContacts = null;
		return this;
	}
	
	public boolean isElementPresent() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			return driver.findElements(By.name("new_group")).size() > 0;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

}

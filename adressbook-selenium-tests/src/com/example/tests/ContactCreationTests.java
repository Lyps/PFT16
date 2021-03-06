package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {
	
	@DataProvider	
	public Iterator<Object[]>	contactsFromFile() throws IOException {
		  return wrapContactsDataForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	
	@Test (dataProvider  = "contactsFromFile")	
  //@Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    // save old state
	SortedListOf<ContactData> oldList = app.getModel().getContacts();
		    
    //actions
    app.getContactHelper().createContact(contact,CREATION);
    
    // save new state
    //SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    SortedListOf<ContactData> newList = app.getModel().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
    if (wantToCheck()) {
    	if ("yes".equals(app.getProperty("check.db"))) {
    		 assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
    	}
        
    	if ("yes".equals(app.getProperty("check.ui"))) {
    		assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
    	}
    }    
    
  }

}

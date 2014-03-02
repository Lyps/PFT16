package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.navigateTo().mainPage();
		
	    // save old state
		SortedListOf<ContactData> oldList = app.getModel().getContacts(); 
				    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getContactHelper().deleteContact(index);  			
	    		    
	    // save new state
		//SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		SortedListOf<ContactData> newList = app.getModel().getContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	    
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

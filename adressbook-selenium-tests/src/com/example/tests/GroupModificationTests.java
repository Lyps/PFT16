package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
	    // save old state
	    SortedListOf<GroupData> oldList = app.getModel().getGroups();
	    		    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().createModify(group,index);
			
		// save new state
	    //SortedListOf<GroupData > newList = app.getGroupHelper().getGroups(); //bla
	    SortedListOf<GroupData> newList = app.getModel().getGroups();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    
	    if (wantToCheck()) {
	    	if ("yes".equals(app.getProperty("check.db"))) {
	    	   	assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	    	}
	        
	    	if ("yes".equals(app.getProperty("check.ui"))) {
	    	   	assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
	    	}
	    }
	    
	}
}

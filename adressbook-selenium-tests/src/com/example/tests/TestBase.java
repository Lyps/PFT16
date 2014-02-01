package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
	    app.stop();
	  }
	
	  @DataProvider	
	  public Iterator<Object[]>	randomValidGroupGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 3; i++) {
			  GroupData group = new GroupData()
			  	.withGroupname(generateRandomString())
			  	.withHeader(generateRandomString())
			  	.withFooter(generateRandomString());
			  list.add(new Object[]{group});	  
		  }
		  return list.iterator();
	  }
	  
	  @DataProvider	
	  public Iterator<Object[]> randomValidContactGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		 for (int i = 0; i <3; i++) {
			  ContactData contact = new ContactData()
			  	.withFirstName(generateRandomString())
			  	.withLastName(generateRandomString())
			  	.withAddress(generateRandomString())
			  	.withHomePhoneFirst(generateRandomString())
			  	.withMobilePhone(generateRandomString())
			  	.withWorkPhone(generateRandomString())
			  	.withMailFirst(generateRandomString())
			  	.withMailSecond(generateRandomString())
			  	.withBirthDay("1")
			  	.withBirthMonth("May")
			  	.withBirthYear("1987")
			  	.withGroupForContact("-") 
			  	.withAddressSecond(generateRandomString())
			  	.withHomePhoneSecond(generateRandomString())
			  	.withAddressSecond(generateRandomString());		
			  list.add(new Object[]{contact});
		  }
		  return list.iterator();
	  }
	  
	  public String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			 return ""; 
		  } else {
			  return "test" + rnd.nextInt(); 
		  }	  
	  }	  

}


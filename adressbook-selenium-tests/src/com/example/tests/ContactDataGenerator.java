package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>;");
			return;
		}	
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remote it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts,file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts,file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," 
					     + contact.getHomePhoneFirst() + "," + contact.getMobilePhone() + ","
					     + contact.getWorkPhone() + "," + contact.getMailFirst() + "," + contact.getMailSecond() + ","
					     + contact.getBirthDay() + "," + contact.getBirthMonth() + "," + contact.getBirthYear() + ","
					     + contact.getGroupForContact() + "," + contact.getAddressSecond() + "," + contact.getHomePhoneSecond() 
					     + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			  ContactData contact = new ContactData()
			  	.withFirstName(part[0])
			  	.withLastName(part[1])
			  	.withAddress(part[2])
			  	.withHomePhoneFirst(part[3])
			  	.withMobilePhone(part[4])
			  	.withWorkPhone(part[5])
			  	.withMailFirst(part[6])
			  	.withMailSecond(part[7])
			  	.withBirthDay(part[8])
			  	.withBirthMonth(part[9])
			  	.withBirthYear(part[10])
			  	.withGroupForContact(part[11]) 
			  	.withAddressSecond(part[12])
			  	.withHomePhoneSecond(part[13])
			  	.withAddressSecond(part[14]);				
			  list.add(contact);			
			line = bufferedReader.readLine();	
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
			  List<ContactData> list = new ArrayList<ContactData>();
			  for (int i = 0; i < 3; i++) {
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
				  list.add(contact);	  
			  }
			  return list;
	}
	
	public static String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			 return ""; 
		  } else {
			  return "test" + rnd.nextInt(); 
		  }	  
	}
}

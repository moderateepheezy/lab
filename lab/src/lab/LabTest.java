import java.util.*;

public class LabTest {
	private static int phoneNumStart = 710223221;
	private static int startAge = 18;
	private static int ctr = 0;

	public static void main(String args[]) throws Exception {
		// Create an array of students
		Person[] contacts = new Person[30];

		contacts[0] = createContact("Michael");
		contacts[1] = createContact("Cory");
		contacts[2] = createContact("Michelle");
		contacts[3] = createContact("Zachary");
		contacts[4] = createContact("Julian");
		contacts[5] = createContact("Maxine");
		contacts[6] = createContact("Steve");
		contacts[7] = createContact("Annette");
		contacts[8] = createContact("Frank");
		contacts[9] = createContact("Nick");

		contacts[10] = createContact("James");
		contacts[11] = createContact("Cotton");
		contacts[12] = createContact("LeBron");
		contacts[13] = createContact("Jake");
		contacts[14] = createContact("Roger");
		contacts[15] = createContact("Billy");
		contacts[16] = createContact("Robert");
		contacts[17] = createContact("Garret");
		contacts[18] = createContact("Aaron");
		contacts[19] = createContact("Rebecca");

		contacts[20] = createContact("Claire");
		contacts[21] = createContact("Holly");
		contacts[22] = createContact("Julie");
		contacts[23] = createContact("Sarah");
		contacts[24] = createContact("Kelly");
		contacts[25] = createContact("Jennifer");
		contacts[26] = createContact("Jane");
		contacts[27] = createContact("Susan");
		contacts[28] = createContact("Samantha");
		contacts[29] = new Person("Terry", "714223321", 18);
		// contacts[29] = createContact("Terry");

		// Initialize the contact list
		ContactList contactList = new ContactList(contacts);
		// run the first test

		contactList.getGroup("Favorites").addContact(contacts[28]);
		contactList.getGroup("Favorites").addContact(contacts[10]);
		contactList.getGroup("Favorites").addContact(contacts[7]);

		contactList.getGroup("Family").addContact(contacts[7]);
		contactList.getGroup("Family").addContact(contacts[17]);

		contactList.getGroup("Business").addContact(contacts[19]);
		contactList.getGroup("Business").addContact(contacts[8]);
		contactList.getGroup("Business").addContact(contacts[4]);
		contactList.getGroup("Business").addContact(contacts[22]);
		contactList.getGroup("Business").addContact(contacts[25]);

		contactList.getGroup("Friends").addContact(contacts[18]);
		contactList.getGroup("Friends").addContact(contacts[19]);
		contactList.getGroup("Friends").addContact(contacts[20]);
		contactList.getGroup("Friends").addContact(contacts[21]);
		contactList.getGroup("Friends").addContact(contacts[22]);
		contactList.getGroup("Friends").addContact(contacts[23]);

		// create a new contact list with 2 additional groups

		// create some new contact groups
		ContactGroup[] contactGroups = new ContactGroup[2];

		// create a contact group for a group of footballers
		Person[] footballers = new Person[10];
		for (int i = 0; i < footballers.length; i++) {
			footballers[i] = contacts[i * 2];
		}
		contactGroups[0] = new ContactGroup("Football Team", footballers, false);

		// create a contact group for a dance team
		Person[] danceTeam = new Person[5];
		for (int i = 0; i < danceTeam.length; i++) {
			danceTeam[i] = contacts[i * 3];
		}
		contactGroups[1] = new ContactGroup("Dance Team", danceTeam, true, 10);

		// create a new contactlist for more tests

		contactList = new ContactList(contacts, contactGroups);

		contactList.getGroup("Favorites").addContact(contacts[28]);
		contactList.getGroup("Favorites").addContact(contacts[10]);
		contactList.getGroup("Favorites").addContact(contacts[7]);

		contactList.getGroup("Family").addContact(contacts[7]);
		contactList.getGroup("Family").addContact(contacts[17]);

		contactList.getGroup("Business").addContact(contacts[19]);
		contactList.getGroup("Business").addContact(contacts[8]);
		contactList.getGroup("Business").addContact(contacts[4]);
		contactList.getGroup("Business").addContact(contacts[22]);
		contactList.getGroup("Business").addContact(contacts[25]);
		contactList.getGroup("Business").setTakeCalls(false);

		contactList.getGroup("Friends").addContact(contacts[18]);
		contactList.getGroup("Friends").addContact(contacts[19]);
		contactList.getGroup("Friends").addContact(contacts[20]);
		contactList.getGroup("Friends").addContact(contacts[21]);
		contactList.getGroup("Friends").addContact(contacts[22]);
		contactList.getGroup("Friends").addContact(contacts[23]);
		// run second test
		test1(contactList);
		test2(contactList, contacts);
		test3(contactList);

	}
	private static void test1(ContactList cl) {// tests 1-813
		checkBool(Person.sameAge(cl.getContacts()[0], cl.getContacts()[29]),
				true);
		for (int i = 0; i < 29; i++) {
			for (int j = 0; j < 29; j++) {
				if (i != j && j != i) {
					checkBool(Person.sameAge(cl.getContacts()[i], cl
							.getContacts()[j]), false);
					/*
					 * if(Person.sameAge(cl.getContacts()[i],cl.getContacts()[j])
					 * ){ System.out.println(cl.getContacts()[i].getAge());
					 * System.out.println(i+" "+j);
					 * System.out.println(cl.getContacts()[j].getAge());
					 * System.out.println();
					 */
				}
			}
		}

		for (int i = 0; i < 30; i++) {// tests 814-843
			cl.getContacts()[i].dial();
			checkInt(cl.getContacts()[i].timesDialed(), 1);
		}
		checkInt(Person.totalDials(), 30);// test 844
		cl.getGroup("Favorites").setTakeCalls(false);
		checkBool(cl.getGroup("Favorites").canCall(), false);// test 845
		cl.getGroup("Favorites").setTakeCalls(true);
		checkBool(cl.getGroup("Favorites").canCall(), true);// test 846
		ContactGroup.doNotTakeCalls(cl.getGroups());
		for (int i = 0; i < cl.getGroups().length; i++) {// tests 847-852
			checkBool(cl.getGroups()[i].canCall(), false);
		}
		checkInt(cl.getGroup("Football Team").getContacts().length, 100);// test
																			// 853
		checkInt(cl.getGroup("Dance Team").getContacts().length, 10);// test 854

	}
	private static void test2(ContactList cl, Person[] contacts) {
		checkStr(cl.getContacts()[2].getName(), ("Michelle"));//test 855
		checkStr(cl.getContacts()[25].getName(), ("Jennifer"));//test 856
		checkInt(cl.getContacts()[10].getAge(), 28);//test 857
		checkInt(cl.getGroups().length, 6);//test 858
		checkInt(fullValues(cl.getGroup("Friends").getContacts()), 6);//test 859
		checkInt(fullValues(cl.getGroup("Family").getContacts()), 2);//test 860
		cl.getGroup("Family").addContact(contacts[2]);
		checkInt(fullValues(cl.getGroup("Family").getContacts()), 3);//test 861
		checkStr(cl.getGroup("Favorites").getContacts()[1].getName(), "James");//test 862
		checkStr(cl.getGroup("Friends").getContacts()[4].getName(), "Julie");//test 863
		checkInt(cl.groupsOfContact(contacts[10]).length, 2);//test 864
		checkInt(cl.groupsOfContact(contacts[7]).length, 2);//test 865
		checkBool(cl.getGroup("Business").canCall(), false);//test 866
		checkBool(cl.getGroup("Family").contactInGroup(contacts[2]), true);//test 867
		checkBool(cl.getGroup("Friends").contactInGroup(contacts[10]), false);//test 868
		checkStr(cl.getContacts()[3].getPhoneNumber(), "710223224");//test 869
		cl.getContacts()[3].birthday();
		checkInt(cl.getContacts()[3].getAge(), 22);//test 870
	}

	private static void test3(ContactList cl) {
		checkInt((int) cl.getGroup("Favorites").getAverageAge(), 33);//test 871
		checkInt((int) cl.getGroup("Football Team").getAverageAge(), 27);//test 872

		Person[] faves = cl.getGroup("Favorites").getContacts();
		for (int loop = 0; loop < faves.length; loop++) {
			if (faves[loop] == null) {
				break;
			}
			faves[loop].birthday();
		}

		checkInt((int) cl.getGroup("Favorites").getAverageAge(), 34);//test 873
	}

	

	private static void checkBool(boolean calc, boolean expected) {
		ctr++;
		if (calc != expected) {
			System.out.print("Test " + ctr + ": ");
			System.out.println("FAILED");
		}
	}

	private static void checkInt(int calc, int expected) {
		ctr++;
		if (calc != expected) {
			System.out.print("Test " + ctr + ": ");
			System.out.println("FAILED");
		}
	}

	private static void checkStr(String calc, String expected) {
		ctr++;
		if (!calc.equals(expected)) {
			System.out.print("Test " + ctr + ": ");
			System.out.println("FAILED");
		}
	}

	private static Person createContact(String name) {
		return new Person(name, (phoneNumStart++) + "", startAge++);
	}
	public static int fullValues(Person[] getContacts){
		for (int i=0; i<getContacts.length;i++){
		if (getContacts[i]==null){
			return i;
		}
	}
		return getContacts.length;
}
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author AH-FEEZ
 */
public class ContactGroup {

    private String name;
    private Person[] contacts;
    private boolean takeCalls;
    private static int maxContacts = 100;

    public ContactGroup(String name, Person[] contacts, boolean takeCalls) {
        this.name = name;
        this.contacts = contacts;
        this.takeCalls = takeCalls;
    }

    public ContactGroup(String name, Person[] contacts, boolean takeCalls, int maxContacts) {
        this.name = name;
        this.contacts = contacts;
        this.takeCalls = takeCalls;
        this.maxContacts = maxContacts;
    }

    public String getName() {
        return name;
    }

    public Person[] getContacts() {
        return contacts;
    }

    public boolean canCall() {
        return takeCalls;
    }

    public static int getMaxContacts() {
        return maxContacts;
    }
    
    public double getAverageAge(){
        return 
    }
    
    public void addContact(Person p){
        
    }
    
}

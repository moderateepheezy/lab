/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author valchukzy
 */
public class Person {

    String name;
    String phoneNumber;
    int age;
    private int dial;
    private static int totaldialed = 0;

    Person(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.dial = 0;
    }

    public int getAge() {
        return age;
    }

    public long getDial() {
        return dial;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void birthday() {
        this.age += 1;
    }

    public boolean sameAge(Person p1, Person p2) {
        if (p1.age == p2.age) {
            return true;
        } else {
            return false;
        }
    }

    public void dial() {
        System.out.println("Dialing " + this.name + " ");
        this.dial += 1;
        Person.totaldialed += 1;
    }

    public int timesDialed() {
        return this.dial;
    }

    public int totalDials() {
        return Person.totaldialed;
    }
}
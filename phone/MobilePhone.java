package challenge.phone;

import java.util.ArrayList;
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber){
        myNumber = phoneNumber;
        myContacts = new ArrayList<>();
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(Contact e : myContacts){
            if (e.getName().equals(contactName))
                return myContacts.indexOf(e);
        }
        return -1;
    }
    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0) {
            System.out.println("challenge.phone.Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int contactFoundIndex = findContact(oldContact);

        if(contactFoundIndex < 0){
            System.out.printf("%s, was not found%n", oldContact.getName());
            return false;
        }
        if(findContact(newContact.getName()) != -1){
            System.out.printf("contact with name: %s%n already exists.", newContact.getName());
            return false;
        }
        myContacts.set(contactFoundIndex, newContact);
        System.out.printf("%s, was replaced with %s%n", oldContact.getName(), newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int contactFoundIndex = findContact(contact);

        if (contactFoundIndex < 0){
            System.out.printf("%s, was not found%n", contact.getName());
            return false;
        }

        myContacts.remove(contactFoundIndex);
        System.out.printf("%s, was deleted%n", contact.getName());
        return true;
    }

    public Contact queryContact(String name){
        int index = findContact(name);

        if (index >= 0)
            return myContacts.get(index);

        return null;
    }

    public void printContacts() {
        System.out.println("challenge.phone.Contact List:");
        for (Contact c : myContacts)
            System.out.printf("%d. %s -> %s%n",myContacts.indexOf(c), c.getName(), c.getPhoneNumber());
    }
}


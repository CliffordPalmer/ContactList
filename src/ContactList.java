import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance variables
    private ArrayList<Person> contacts;
    private Scanner input;
    // Constructor
    public ContactList(){
        contacts = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // Getters and Setters
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person contact){
        contacts.add(contact);
    }

    // Prints all contacts in order
    public void printContacts(){
        for(Person person: contacts) {
            System.out.println(person);
        }
    }

    // Sorts contact list by first name, last name, or phone number
    public void sort(int sortBy){

        // Bubble sort
        for(int i = 0; i < contacts.size() - 1; i++){
            for(int j = 0; j < contacts.size() - i - 1; j++){
                // First name sort
                if(sortBy == 0) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        Person r = contacts.remove(j + 1);
                        contacts.add(j, r);
                    }
                }
                // Last name sort
                else if(sortBy == 1){
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        Person r = contacts.remove(j + 1);
                        contacts.add(j, r);
                    }
                }
                // Phone number sort
                else if (sortBy == 2){
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        Person r = contacts.remove(j + 1);
                        contacts.add(j, r);
                    }
                }
            }
        }
    }

    // Search Functions
    public Person searchByFirstName(String firstName){
        for(Person person: contacts){
            if(person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName){
        for(Person person: contacts){
            if(person.getLastName().equals(lastName)){
                return person;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for(Person person: contacts){
            if(person.getPhoneNumber().equals(phoneNumber)){
                return person;
            }
        }
        return null;
    }

    // Prints only Students in the contact list
    public void listStudents(){
        for(Person person: contacts){
            if(person instanceof Student){
                System.out.println(person);
            }
        }
    }

    // Main UI loop
    public void run(){

        // On startup
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please Pick from the following menu options");

        // Forever until exit
        while(true) {
            // Print options
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts by First Name");
            System.out.println("3. List All Contacts by Last Name");
            System.out.println("4. List All Contacts by Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search by First Name");
            System.out.println("7. Search by Last Name");
            System.out.println("8. Search by Phone Number");
            System.out.println("0. Exit");

            // Collect user choice
            int choice = input.nextInt();
            input.nextLine();

            // Add contact
            if (choice == 1) {
                // Collect contact information
                System.out.println("Please select the type of contact to add");
                // Specify type of Person
                System.out.println("1. Student\n2. Parent");
                int contactType = input.nextInt();
                input.nextLine();
                System.out.println("Please fill in the following information:");
                System.out.println("First Name:");
                String firstName = input.nextLine();
                System.out.println("Last Name:");
                String lastName = input.nextLine();
                System.out.println("Phone Number: ");
                String phoneNumber = input.nextLine();

                // Special information for Student
                if (contactType == 1) {
                    System.out.println("Grade:");
                    int grade = input.nextInt();
                    input.nextLine();
                    addContact(new Student(firstName, lastName, phoneNumber, grade));
                }
                // Special information for Parent
                else {
                    System.out.println("Number of Kids");
                    int numberOfKids = input.nextInt();
                    input.nextLine();
                    addContact(new Parent(firstName, lastName, phoneNumber, numberOfKids));
                }

            // Sort by first name & print
            } else if (choice == 2) {
                sort(0);
                printContacts();
            }
            // Sort by last name & print
            else if (choice == 3) {
                sort(1);
                printContacts();
            }
            // Sort by phone number & print
            else if (choice == 4) {
                sort(2);
                printContacts();
            }
            // List all Students only
            else if (choice == 5) {
                sort(0);
                listStudents();
            }
            // Search by first name
            else if (choice == 6) {
                System.out.println("First Name:");
                String firstName = input.nextLine();
                Person result = searchByFirstName(firstName);
                // Notify user if Person does not exist
                if(result == null){
                    System.out.println(firstName + " is not in the list");
                }
                // Print out search result
                else {
                    System.out.println(result);
                }
            }
            // Search by last name
            else if (choice == 7) {
                System.out.println("Last Name:");
                String lastName = input.nextLine();
                Person result = searchByLastName(lastName);
                // Notify user if Person does not exist
                if(result == null){
                    System.out.println(lastName + " is not in the list");
                }
                // Print out search result
                else {
                    System.out.println(result);
                }
            }
            // Search by phone number
            else if (choice == 8) {
                System.out.println("Phone Number");
                String phoneNumber = input.nextLine();
                Person result = searchByPhoneNumber(phoneNumber);
                // Notify user if Person does not exist
                if(result == null){
                    System.out.println(phoneNumber + " is not in the list");
                }
                // Print out search result
                else {
                    System.out.println(result);
                }
            }
            // Exit
            else if (choice == 0) {
                return;
            }
        }

    }

    // Main
    public static void main(String[] args) {
        ContactList c = new ContactList();
        // c.tester();
        c.run();
    }

    // Creates fake people for easy testing
    public void tester(){
        Person kai = new Parent("A", "H", "1234567890", 2);
        Person mike = new Student("B", "G", "3234567890", 11);
        Person clifford = new Person("C", "F", "234567891");
        Person jess = new Student("D", "E", "5234567890", 11);
        addContact(clifford);
        addContact(kai);
        addContact(mike);
        addContact(jess);
    }
}

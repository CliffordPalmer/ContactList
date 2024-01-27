public class Parent extends Person{
    // Parent-specific instance variables
    private int numberOfKids;

    public Parent(String firstName, String lastName, String phoneNumber, int numberOfKids){
        super(firstName, lastName, phoneNumber);
        this.numberOfKids = numberOfKids;
    }

    // Getters and Setters
    public int getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    // Parent specific toString
    public String toString(){
        return super.toString() + " Number of Kids: " + numberOfKids;
    }
}

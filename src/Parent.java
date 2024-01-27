public class Parent extends Person{
    private int numberOfKids;

    public Parent(String firstName, String lastName, String phoneNumber, int numberOfKids){
        super(firstName, lastName, phoneNumber);
        this.numberOfKids = numberOfKids;
    }

    public int getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public String toString(){
        return super.toString() + " Number of Kids: " + numberOfKids;
    }
}

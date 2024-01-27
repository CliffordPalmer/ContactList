public class Student extends Person{
    // Student specific instance variables
    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade){
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getters and setters
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Student specific toString
    public String toString(){
        return super.toString() + " Grade: " + grade;
    }
}

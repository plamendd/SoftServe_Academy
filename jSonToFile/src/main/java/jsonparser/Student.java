package jsonparser;

public class Student {
    private String firstName;
    private String lastName;
    private double rank;

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public double getRank() {
        return rank;
    }

    public Student setRank(double rank) {
        this.rank = rank;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rank=" + rank +
                '}';
    }


}
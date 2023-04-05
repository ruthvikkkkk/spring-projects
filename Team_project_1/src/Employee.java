import java.util.*;

public class Employee {
    private String firstName;
    private String lastName;
    private Date DateOfBirth;
    private double experience;

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setExperience(double experience) {
        experience = experience;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.DateOfBirth.toString();
    }

    public double getExperience() {
        return this.experience;
    }
}

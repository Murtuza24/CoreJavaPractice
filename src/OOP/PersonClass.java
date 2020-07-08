package OOP;

public class PersonClass {
    private String FirstName;
    private String LastName;
    private String Email;
    private String ContactNo;

    public PersonClass(String firstName, String lastName, String email, String contactNo) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNo = contactNo;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }
}

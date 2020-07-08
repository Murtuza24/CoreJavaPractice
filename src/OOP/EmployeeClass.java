package OOP;

public class EmployeeClass extends PersonClass {

    public EmployeeClass(String firstName, String lastName, String email, String contactNo, String employeeType, String employeePosition) {
        super(firstName, lastName, email, contactNo);
        EmployeeType = employeeType;
        EmployeePosition = employeePosition;
    }

    private String EmployeeType;
    private String EmployeePosition;

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String employeeType) {
        EmployeeType = employeeType;
    }

    public String getEmployeePosition() {
        return EmployeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        EmployeePosition = employeePosition;
    }

    public  String getEmployeeDetails(){
        return getFirstName()+" "+getLastName()+" "+ "is a "+getEmployeePosition();
    }
}

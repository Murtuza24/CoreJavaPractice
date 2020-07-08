package OOP;

public class InheritanceClass {
    public static void main(String[] args) {
        EmployeeClass employeeClass = new EmployeeClass("Murtuza", "Bhaiji", "murtuzabhaiji@gmail.com","9876543210",
                "permanent","Software Development Engineer");

        System.out.println(employeeClass.getEmployeeDetails());

    }
}

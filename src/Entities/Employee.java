package Entities;

public class Employee extends User{
    public Employee(String name, String email, String password) throws NullPointerException {
        super(name, email, password, true);
    }
}

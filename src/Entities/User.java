package Entities;

public class User {
    protected String name;
    protected String email;
    protected String password;
    protected boolean isEmployee;

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException{
        if(name.isBlank()){
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NullPointerException{
        if(email.isBlank()){
            throw new NullPointerException();
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NullPointerException{
        if(password.isBlank()){
            throw new NullPointerException();
        }
        this.password = password;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public User(String name, String email, String password, boolean isEmployee) throws NullPointerException{
        setName(name);
        setEmail(email);
        setPassword(password);
        setEmployee(isEmployee);
    }
}

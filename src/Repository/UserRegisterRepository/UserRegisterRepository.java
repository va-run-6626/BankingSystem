package Repository.UserRegisterRepository;

import Database.Query.Query;
import Entities.Customer;
import Entities.Employee;
import Entities.User;
import Repository.UserRegisterRepository.IUserRegisterRepository;

import java.sql.*;


public class UserRegisterRepository implements IUserRegisterRepository, Query {
    private Connection bankingConnection;
    private Connection statementConnection;
    public UserRegisterRepository(Connection bankingConnection, Connection statementConnection){
        this.bankingConnection = bankingConnection;
        this.statementConnection = statementConnection;
    }

    @Override
    public void registerUser(Customer customer) throws SQLException {
       boolean account = registerAccountInDatabase(customer);
       boolean user = registerUserInDatabase(customer);
       CreateStatement(customer);
       boolean entry = initaialEntry(customer);
       if(account && user && entry){
           System.out.println("Customer Registered Successfully!!");
       }else{
           System.out.println("Registration failed!!");
       }
    }

    private boolean initaialEntry(Customer customer) throws SQLException{
        String email = customer.getEmail();
        String addOn = email.substring(0,email.length()-10);
        String tableName = "stmt_"+addOn;
        String query = "INSERT INTO "+tableName+"(transactionType, credit, balance) VALUES('CREDIT',"+customer.getAccount().getBalance()+","+customer.getAccount().getBalance()+")";
        Statement statement = statementConnection.createStatement();
        int affectedRows = statement.executeUpdate(query);
        if(affectedRows > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean registerUserInDatabase(User user) throws SQLException{
        String query = registerUserInfo;
        PreparedStatement registerCustomer = bankingConnection.prepareStatement(query);

        registerCustomer.setString(1,user.getName());
        registerCustomer.setString(2,user.getEmail());
        registerCustomer.setString(3,user.getPassword());
        registerCustomer.setBoolean(4,user.isEmployee());

        int affectedRows = registerCustomer.executeUpdate();
        if(affectedRows > 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean registerAccountInDatabase(Customer customer)throws SQLException{
        String query = registerCustomerAccount;
        PreparedStatement registerCustomer = bankingConnection.prepareStatement(query);

        registerCustomer.setLong(1,customer.getAccount().getAccountNumber());
        registerCustomer.setString(2,customer.getName());
        registerCustomer.setString(3,customer.getEmail());
        registerCustomer.setDouble(4,customer.getAccount().getBalance());
        registerCustomer.setString(5,customer.getAccount().getPin());

        int affectedRows = registerCustomer.executeUpdate();
        if(affectedRows > 0){
            return true;
        }else{
            return false;
        }
    }
    private void CreateStatement(Customer customer)throws SQLException{
        String email = customer.getEmail();
        String addOn = email.substring(0,email.length()-10);
        String tableName = "stmt_"+addOn;
        String query = "CREATE TABLE "+ tableName +"(" +
                "entryNo INT AUTO_INCREMENT PRIMARY KEY," +
                "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "transactionType VARCHAR(255) NOT NULL," +
                "credit DOUBLE," +
                "debit DOUBLE," +
                "balance DOUBLE NOT NULL" +
                ")";
        Statement statement = statementConnection.createStatement();
        statement.execute(query);
    }

    @Override
    public void registerEmployee(Employee employee) throws SQLException {
        boolean user = registerUserInDatabase(employee);
        if(user){
            System.out.println("Employee Registered Successfully!!");
        }else{
            System.out.println("Registration failed!!");
        }
    }

    @Override
    public long generateAccountNumber() throws SQLException{
        Statement statement = bankingConnection.createStatement();
        String query = generateAccountNumber;
        ResultSet resultSet = statement.executeQuery(query);
        if(resultSet.next()){
            long lastAccountNumber = resultSet.getLong("accountNumber");
            return lastAccountNumber+1;
        }else{
            return 1111111;
        }
    }
}

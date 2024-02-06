package Repository.LoginRepository;

import Database.Query.Query;
import Entities.Customer;
import Repository.LoginRepository.ILoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository implements ILoginRepository, Query {
    private Connection connection;
    public LoginRepository(Connection connection){
        this.connection = connection;
    }
    @Override
    public Object[] retrivePass(String email) throws SQLException {
        String query = getPass;
        PreparedStatement retrivePass = this.connection.prepareStatement(query);
        retrivePass.setString(1,email);

        ResultSet resultSet = retrivePass.executeQuery();
        if(resultSet.next()){
            String pass = resultSet.getString("password");
            boolean empCheck = resultSet.getBoolean("isEmployee");
            return new Object[]{pass,empCheck};
        }else{
            return null;
        }
    }

    @Override
    public Customer getCustomer(String email) throws SQLException {
        Object[] fromUser = getCustomerInfoUser(email);
        Object[] fromAccount = getCustomerInfoAccount(email);
        if(fromUser != null && fromAccount != null){
            String name =(String) fromUser[0];
            String mail =(String) fromUser[1];
            String password = (String) fromUser[2];
            long accountNo = (long) fromAccount[0];
            double balance = (double) fromAccount[1];
            String pin = (String) fromAccount[2];
            return new Customer(name,mail,password,accountNo,balance,pin);
        }
        return null;
    }

    private Object[] getCustomerInfoAccount(String email) throws SQLException{
        String query = getCustomerInfoAccount;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            long accountNo = resultSet.getLong("accountNumber");
            double balance = resultSet.getDouble("balance");
            String pin = resultSet.getString("securityPin");
            return new Object[]{accountNo,balance,pin};
        }else{
            return null;
        }
    }

    private Object[] getCustomerInfoUser(String email) throws SQLException{
        String query = getCustomerInfoUser;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            String name = resultSet.getString("name");
            String mail = resultSet.getString("email");
            String password = resultSet.getString("password");
            return new Object[]{name,mail,password};
        }else{
            return null;
        }
    }
}

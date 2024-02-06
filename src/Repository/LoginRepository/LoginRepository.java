package Repository.LoginRepository;

import Database.Query.Query;
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
}

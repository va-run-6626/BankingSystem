package Repository.UserMenuServices;

import Database.Query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusRepository implements IStatusRepository, Query{
    private Connection connection;
    public StatusRepository(Connection connection){
        this.connection = connection;
    }
    @Override
    public Object[] getStatus(String email) throws SQLException {
        String query = getCustomerStatus;
        PreparedStatement status = this.connection.prepareStatement(query);
        status.setString(1,email);

        ResultSet resultSet = status.executeQuery();
        if(resultSet.next()){
            long accountNo = resultSet.getLong("accountNumber");
            String name = resultSet.getString("name");
            String mail = resultSet.getString("email");
            double balance = resultSet.getDouble("balance");

            return new Object[]{accountNo,name,mail,balance};
        }else{
            return null;
        }
    }
}

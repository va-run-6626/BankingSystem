package Repository.EmployeeMenuServicesRepository;

import Database.Query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListUserRepository implements IListUserRepository, Query {
    private Connection connection;
    public ListUserRepository(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Object[]> listUser() throws SQLException {
        String query = listUsers;
        PreparedStatement listUsersStmt = this.connection.prepareStatement(query);

        ResultSet result = listUsersStmt.executeQuery();
        List<Object[]> ans = new ArrayList<>();
        while (result.next()){
            long accountNo = result.getLong("accountNumber");
            String name = result.getString("name");
            String email = result.getString("email");
            double balance = result.getDouble("balance");

            Object[] in = {accountNo,name,email,balance};
            ans.add(in);
        }
        if(!ans.isEmpty()) return ans;
        else return null;
    }
}

package Services.AccountServices;

import Database.Query.Query;
import Repository.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginUserAccountService implements ILogin{
    private Repository repository;
    public LoginUserAccountService(){
        this.repository = new Repository();
    }

    @Override
    public boolean login(String email, String password,boolean isEmployee) {
        try {
            Object[] obj = this.repository.getPassForCheck(email);
            String retPass = (String) obj[0];
            boolean empCheck = (boolean) obj[1];
            if(password.equals(retPass) && empCheck == isEmployee){
                return true;
            }
            return false;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package Services.AccountServices;

import java.sql.SQLException;

public interface ILogin {
    public boolean login(String email, String password,boolean isEmployee);
}

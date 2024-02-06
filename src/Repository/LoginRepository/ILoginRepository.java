package Repository.LoginRepository;

import java.sql.SQLException;

public interface ILoginRepository {
    public Object[] retrivePass(String email)throws SQLException;
}

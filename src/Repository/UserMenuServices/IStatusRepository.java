package Repository.UserMenuServices;

import java.sql.SQLException;

public interface IStatusRepository {
    public Object[] getStatus(String email) throws SQLException;
}

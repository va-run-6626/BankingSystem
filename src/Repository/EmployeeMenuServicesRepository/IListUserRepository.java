package Repository.EmployeeMenuServicesRepository;

import java.sql.SQLException;
import java.util.List;

public interface IListUserRepository {
    public List<Object[]> listUser() throws SQLException;
}

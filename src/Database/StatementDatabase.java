package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatementDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/statements";
    private static final String username = "root";
    private static final String password = "varun";
    private static StatementDatabase statementDatabase = null;
    private Connection connection;
    private StatementDatabase(){
        setConnection();
    }
    private void setConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static synchronized StatementDatabase getInstance(){
        if(statementDatabase == null){
            statementDatabase = new StatementDatabase();
        }
        return statementDatabase;
    }
    public Connection getConnection(){
        return this.connection;
    }
}

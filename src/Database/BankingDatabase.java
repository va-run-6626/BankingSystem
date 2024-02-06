package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankingDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/Banking";
    private static final String username = "root";
    private static final String password = "varun";
    private static BankingDatabase bankingDatabase = null;
    private Connection connection;
    private BankingDatabase(){
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

    public static synchronized BankingDatabase getInstance(){
        if(bankingDatabase == null){
            bankingDatabase = new BankingDatabase();
        }
        return bankingDatabase;
    }
    public Connection getConnection(){
        return this.connection;
    }
}

package Database;

import java.sql.Connection;

public class Database {
    private static  BankingDatabase bankingDatabase = null;
    private static  StatementDatabase statementDatabase = null;

    private static Database database = null;
    private Database(){
        bankingDatabase = BankingDatabase.getInstance();
        statementDatabase = StatementDatabase.getInstance();
    }
    public static synchronized Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

    public Connection getBankingConnection(){
        return bankingDatabase.getConnection();
    }
    public Connection getStatementConnection(){
        return statementDatabase.getConnection();
    }
}

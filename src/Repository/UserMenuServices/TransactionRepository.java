package Repository.UserMenuServices;

import Database.Query.Query;
import Entities.Customer;
import Services.UserServices.CustomerServices.CustomerAccountStatusService.TransactionService;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionRepository implements ITransactionRepository, Query {

     private Connection bankingConnection;
     private Connection statementConnection;
     public TransactionRepository(Connection bankingConnection, Connection statementConnection){
         this.bankingConnection = bankingConnection;
         this.statementConnection = statementConnection;
     }

    @Override
    public boolean credit(double amount, Customer customer) throws SQLException {
        bankingConnection.setAutoCommit(false);
        statementConnection.setAutoCommit(false);
        return false;
    }

    @Override
    public boolean debit(double amount, Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean transfer(double amount, Customer customer) throws SQLException {
        return false;
    }
}

package Database.Query;

public interface Query {
      String registerCustomerAccount = "INSERT INTO accounts(accountNumber,name,email,balance,securityPin) VALUES (?,?,?,?,?)";
      String registerUserInfo = "INSERT INTO user(name, email, password, isEmployee) VALUES (?,?,?,?)";
      String generateAccountNumber = "SELECT accountNumber FROM accounts ORDER BY accountNumber DESC LIMIT 1";
      String getPass = "SELECT password, isEmployee FROM user WHERE email = ?";
      String getCustomerStatus = "SELECT accountNumber, name, email, balance FROM accounts WHERE email = ?";

}

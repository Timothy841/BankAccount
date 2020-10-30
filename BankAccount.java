public class BankAccount{
  private double balance;
  private int accountID;
  private String password;

  public BankAccount(int newaccountID, String newpassword){
    balance = 0;
    accountID = newaccountID;
    password = newpassword;
  }

  public String toString(){
    return ("#"+accountID+"\t$"+balance);
  }

  public double getBalance(){
    return balance;
  }

  public int getAccountID(){
    return accountID;
  }

  public void setPassword(String newPass){
    password = newPass;
  }

  public boolean deposit(double amount){
    if (amount >= 0){
      balance+=amount;
      return true;
    }
    else{
      return false;
    }
  }

  public boolean withdraw(double amount){
    if (amount >= 0 && balance>=amount){
      balance-=amount;
      return true;
    }
    else{
      return false;
    }
  }

  private boolean authenticate(String password){
    return (this.password.equals(password));
  }

  public boolean transferTo(BankAccount other, double amount, String password){
    if (this.authenticate(password) && amount >= 0 && this.withdraw(amount)){
      if (other.deposit(amount)){
        return true;
      }
      else{
        System.out.println("CRITICAL ERROR! $"+amount +
                           " withdrawn from Account #" +  this.getAccountID() +
                           "Failed to add to Account #"+ other.getAccountID());
      }
    }
    return false;
  }
  
}

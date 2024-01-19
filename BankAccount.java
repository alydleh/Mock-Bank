
/**
 * This handles all of the information of the account owner.
 * 
 * @author (Alyda Huerta) 
 * @version (04.19.14)
 */
public class BankAccount
{
    String name="";
    String password="";
    double balance=0.0;
    String accountNumber="";

    /**
     * Constructor for objects of class BankAccount
     */
    public BankAccount(String n, String p, String aN, double b)
    {
        name=n;
        password=p;
        accountNumber=aN;
        balance=b;
        
    }
    public BankAccount(String n)
    {
      name=n; //this is another constructor to create a "default" account when needed for certain checks (passwords match and account exists)
    }
    
    public boolean checkPassword(String p)
    {
        boolean check=true;//checks if the passwords match
    if (password.equals(p))
    {
      check= true;  
    }
    else
    {
        check= false;
    }
    return check;
    }
    
    public void addBalance(double x)//adds money to balance
    {
      balance=balance+x;  
        
    }
    
    public void subtractBalance(double x)//subtracts money from balance
    {
      balance=balance-x;  
    }
    
    public double totalBalance()//gives total balance
    {
     return balance;   
    }
    
    public String getName()//gives the name of the account user
    {
       return name; 
    }

   
}

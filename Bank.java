import java.util.HashMap;
/**
 *This class stores all of the user's account number and and a corresponding
 *BankAccount object that has all of the account's other information
 * 
 * @author (Alyda Huerta) 
 * @version (04.19.14)
 */
public class Bank
{
    HashMap<String,BankAccount> hmap;
    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
      hmap=new HashMap<String,BankAccount>();  //the HashMap use to store the data
    }
    
    public void addAccount(String n, String p, String aN, double b)
    {
      BankAccount bA=new BankAccount(n,p,aN,b);
      hmap.put(aN, bA); //stores the account number as the key and the BankAccount object as the value
    }
    
    public BankAccount accessAccount(String aN, String p)
    {
      if (hmap.containsKey(aN))//if that account does exist, it returns the corresponding BankAccount object
      {
          String password=p;
        BankAccount returnAccount=hmap.get(aN);
        return returnAccount;
        }
        else
        {
            BankAccount noaccount=new BankAccount("no account");//if the account does not exist, it returns a "default" BankAccount object
          return noaccount ;  
        }
    }

}

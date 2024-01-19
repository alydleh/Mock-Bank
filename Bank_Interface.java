import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 * This class handles all of the math and checks for creating and handling an account in the Bank
 * 
 * @author (Alyda Huerta) 
 * @version (05.17.14)
 */
public class Bank_Interface extends JFrame
{
     JTextField f1;
     JTextField f4;
     JTextField f3;
     JPasswordField f2;
     JTextField e1;
     JPasswordField e2;
     JTextField e3;
     JTextField k2;
     JTextField x2;
     Bank bank=new Bank();
     JFrame frame= new JFrame("JOptionPane showMessageDialog");
     String assignedAccountNumber="000010034";
    public Bank_Interface()
    {
        setLayout(new BorderLayout());
       
        //part of the left GUI
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,2));
        JLabel l1= new JLabel("Account Number",10);
        JLabel l2=new JLabel ("Password",10);
        JLabel l3=new JLabel ("Deposit money",10);
        JLabel l4=new JLabel ("Withdraw money",10);
        f1= new JTextField(10);
        f4= new JTextField(10);
        f3= new JTextField(10);
        f2= new JPasswordField(10);
        p.add(l1);
        p.add(f1);
        p.add(l2);
        p.add(f2);
        p.add(l3);
        p.add(f3);
        p.add(l4);
        p.add(f4);

        //total left of GUI (with both labels)
        JPanel t=new JPanel();
        t.setLayout(new BorderLayout());
        JLabel g1= new JLabel("**Transaction**",10);
        JButton g2= new JButton("Make a Transaction");
        t.add(g1,BorderLayout.NORTH);
        t.add(p,BorderLayout.CENTER);
        t.add(g2,BorderLayout.SOUTH);
        
        //part of right GUI
        JPanel q = new JPanel();
        q.setLayout(new GridLayout(3,2));
        JLabel a1=new JLabel("Name",10);
        JLabel a2=new JLabel("Password (must be at least 6 characters!)",10);
        JLabel a3=new JLabel("Initial Balance",10);
        e1=new JTextField(10);
        e2= new JPasswordField(10);
        e3=new JTextField(10);
        q.add(a1);
        q.add(e1);
        q.add(a2);
        q.add(e2);
        q.add(a3);
        q.add(e3);
        
       //total right GUI (with both labels)
        JPanel u=new JPanel();
        JLabel j1= new JLabel("**New Account**",10);
        JButton j2= new JButton("Create an Account");
        u.setLayout(new BorderLayout());
        u.add(j1,BorderLayout.NORTH);
        u.add(q,BorderLayout.CENTER);
        u.add(j2,BorderLayout.SOUTH);
        
        //the whole middle part of GUI 
        JPanel r= new JPanel();
        r.setLayout(new GridLayout(1,2));
        r.add(t);
        r.add(u);
        
        //the top part of GUI with my photo and the title
        JPanel s= new JPanel();
        s.setLayout(new FlowLayout());
        JLabel b1=new JLabel("HELLO! WELCOME TO HUERTA BANKING!",10);
        Icon logo= new ImageIcon("AlydaHuerta");
        JButton button= new JButton("",logo);
        s.add(b1);
        s.add(button);
        s.setSize(100,100);
        
        //bottom left of GUI
        JPanel v=new JPanel();
        v.setLayout(new GridLayout(1,2));
        JLabel k1=new JLabel("Balance",10);
        k2=new JTextField(10);
        v.add(k1);
        v.add(k2);
        
        //bottom right of GUI
        JPanel w=new JPanel();
        w.setLayout(new GridLayout(1,2));
        JLabel x1=new JLabel("Account Number",10);
        x2=new JTextField(10);
        w.add(x1);
        w.add(x2);
        
       //whole bottom of GUI
       JPanel c=new JPanel();
       c.setLayout(new GridLayout(1,2));
       c.add(v);
       c.add(w);
       
        //final layout of GUI; everything together
        add(r,BorderLayout.CENTER);//adds the textfields and labels
        add(s,BorderLayout.NORTH);
        add(c,BorderLayout.SOUTH);
        
       //to make a transaction 
        g2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              String password="";
              for(Character password1:f2.getPassword())//convertss password to a string
              {
               password=password+ password1;  
                }
              String accountNumber=f1.getText();
              String deposit=f3.getText();
              String withdrawal=f4.getText();
              f2.setText("");
              f1.setText("");
              f3.setText("");
              f4.setText("");//sets all textfields to blank
              BankAccount account=bank.accessAccount(accountNumber,password);
              //to check if the password matches after a user attempts to log in
              if(account.checkPassword(password)==false)
              {
                  if (!(account.getName()).equals("no account"))//to check that there is an account but passwords don't match
                  {
                  JOptionPane.showMessageDialog(frame,"The password you entered is incorrect. Please enter the correct password");
                }
            }
              if(account.checkPassword(password)==true) 
              {
                   double balanceAdded=Double.parseDouble(deposit);
                    double balanceWithdrawn=Double.parseDouble(withdrawal);
                    if (balanceAdded>=0&&balanceWithdrawn>=0)//to make sure the user doesn't use negative money
                    {
                   account.addBalance(balanceAdded);
                   double total0=account.totalBalance();
                   if ((total0-balanceWithdrawn)<0)//so that the user cannot withdraw more money than is available
                   {
                      JOptionPane.showMessageDialog(frame,"You do not have enough money to withdraw this amount"); 
                      double total=account.totalBalance();
                      k2.setText(""+total); 
                    }
                    else
                    {
                   account.subtractBalance(balanceWithdrawn);
                   double total=account.totalBalance();
                   k2.setText(""+total); 
                }
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Sorry, negative money cannot be added or withdrawn"); 
            }
                   
                   
                
                }
               if ((account.getName()).equals("no account"))//default account created with name "no account" when there is not an account
               {
                 JOptionPane.showMessageDialog(frame, "There is no account with the entered account number"); 
                }
               
              
            }
        });
        
            j2.addActionListener(new ActionListener()//to create a new account
        {
            public void actionPerformed(ActionEvent e)
            {
              String password="";
              for(Character password1:e2.getPassword())
              {
               password=password+ password1;  
                }
                if (password.length()>=6)//checks to make sure the password is at least 6 characters long
                {
              String name=e1.getText();
              String balance=e3.getText();
              double balance1=Double.parseDouble(balance);
              e2.setText("");
              e1.setText("");
              e3.setText("");
              bank.addAccount(name,password,assignedAccountNumber,balance1);//adds the new account to a HashMap in other class
              x2.setText(assignedAccountNumber);
              assignedAccountNumber=""+(Integer.parseInt(assignedAccountNumber)+14365);//so that each user gets a unique number
            }
            else
            {
              JOptionPane.showMessageDialog(frame, "Your password must be at least 6 characters long!");   
              e2.setText("");
            }
              
              
            }
        });
        
     
    
}
}
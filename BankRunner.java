import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class runs the bank program
 * 
 * @author (Alyda Huerta) 
 * @version (04.19.14)
 */
public class BankRunner
{
   public static void main (String [] args)
   {
       Bank_Interface c = new Bank_Interface();
       c.pack();
       c.setVisible(true);
    }
}
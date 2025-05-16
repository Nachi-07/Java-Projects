package javaprojects;
import java.util.*;
import javax.swing.*;

 class Account{
	private double balance;
	private final String pin = "0707";
	
	Account(double balance){
		this.balance=balance;
	}
	
	public boolean verifyPin() {
        JPasswordField pf = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, pf, " Welcome to HDFC BANK ATM \n Enter Your PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String enteredPin = new String(pf.getPassword()); // Convert char[] to String
            
            if (enteredPin.equals(pin)) {
                return true; // Correct PIN
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect PIN! Try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operation Cancelled.");
        }
        return false;
    }

	public void checkBalance() {
		System.out.println("your current balance is $"+ balance);
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Amount deposited sucessfully $"+ amount);
			
		}else {
			System.out.println("invalid option! Please enter the positive number");
			
		}
	}
	public void withdraw(double amount) {
		if(amount>0 && amount<= balance) {
			balance-=amount;
			System.out.println("Amount withdrawn Sucessfully $" + amount);
		} else if(amount > balance){
			System.out.println("Insufficient balance!");
			
		}else {
			System.out.println("Invalid option! Please enter the positive number");
		}
	}
 }

public class AtmP{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Account acc = new Account(1000);
		System.out.println("        Welcome to HDFC BANK ATM         ");
		System.out.println("              OUR SERVICES                      ");
		System.out.println("===============================================================");
		
		
		
		if (!acc.verifyPin()) {
	            sc.close();
	            return;
		}
		System.out.println("Pin is accessed");
		while(true) {
			System.out.println("\n===== ATM Menu =====");
		System.out.println("1. Check Balance💻");
		System.out.println("2. Deposit💵");
		System.out.println("3. Withdrawl💰💰");
		System.out.println("4. Exit");
		System.out.println("Enter the option: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			acc.checkBalance();
			break;
		case 2:
			System.out.println("Enter the deposit amount");
			double depositamount = sc.nextDouble();
			acc.deposit(depositamount);
			break;
		case 3:
			System.out.println("Enter the withdrawl amount");
			double withdrawamount = sc.nextDouble();
			acc.withdraw(withdrawamount);
			break;
		case 4:
			System.out.println("Transaction Completed Successfully🙏");
			sc.close();
			return;
		default:
			System.out.println("Invalid Choice! Please try again.");
		}
		
			
		

		}
		}
	
}

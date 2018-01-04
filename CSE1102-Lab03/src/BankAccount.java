import java.util.*;



public class BankAccount {
	private int balance = 0;
	private String password = "secret";
	
	public void showBalance() {
		System.out.println("The balance is " + getBalance());
	}
	
	public boolean checkPassword() {
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Enter password: ");
		String guess = kbd.nextLine();
		
		if(guess.equals(password)) // not guess == password
		 {
		 System.out.println("Password correct");
		 return true;
		 }
		 else
		 {
		 System.out.println("Password incorrect");
		 return false;
		 }
	}
	
	public void changePassword() {
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);
		
		if(this.checkPassword()) {
			System.out.println("Enter new password: ");
			this.password = kbd.nextLine();
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(this.checkPassword()) {
			this.balance = balance;
		}
	}
	
	

}

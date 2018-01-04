
public class Main {
	public static void main(String args[]) {
		BankAccount ba = new BankAccount();
		
		ba.changePassword();
		
		ba.showBalance();
		
		ba.setBalance(ba.getBalance() + 100);
		ba.showBalance();
	}
}

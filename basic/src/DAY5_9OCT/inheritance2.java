package DAY5_9OCT;

class BankAccount{
	String accountHolder;
	
	BankAccount(String accountHolder){
		
		this.accountHolder= accountHolder;
		
	}
	void displayDetails() {
		System.out.println("AccountHolder :"+accountHolder);
	}
	
}
class SavingAccount extends BankAccount{
	double interestrRate =4.5;
	
	SavingAccount(String accountholder){
		super(accountholder);
	}
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Interest rate :"+ interestrRate+"%");
	}
	
		
	}

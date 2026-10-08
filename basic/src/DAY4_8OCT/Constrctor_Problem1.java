package DAY4_8OCT;

 class coffeWallet{
	 String std_name;
	 double balance;
	 
	 
	 coffeWallet(String std_name,double balance){
		 this.std_name=std_name;
		 this.balance =balance;
	 }
	 
	void add_money(double amount) {
		balance+=amount;
		System.out.println("rs" + amount + " added.");
        System.out.println("Current Balance: rs" + balance);
	}
	
	void purchase(double amount) {
		if(balance>=amount) {
			balance-=amount;
			 System.out.println("Purchase successful");
		     System.out.println("Balance: " + balance);
			
		}
		else {
			System.out.println("balancr is not sufficient");
		}
	}
	 void show() { 
		 System.out.println("student name:"+std_name);
		 System.out.println("balance :"+balance);
		 
	 }
 }

public class Constrctor_Problem1 {
	public static void main(String[] args) {
		coffeWallet  wallet =new coffeWallet("Ankita",500);
		
		wallet.show();
		wallet.add_money(200);
		wallet.purchase(150);
		wallet.purchase(800);
		wallet.show();
	}

}

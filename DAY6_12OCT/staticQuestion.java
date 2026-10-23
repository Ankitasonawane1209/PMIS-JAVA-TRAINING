package DAY6_12OCT;

class UserAccount{
	private String username;
	private static int totalUsers =0;
	
	
	UserAccount(String username){
		this.username = username;
		totalUsers++;
		
	}
		String getUsername() {
			return username;
			
		}
		
		static int getTotalUsers() {
			return totalUsers;
		}
	}
public class staticQuestion{
	public static void main(String[] args) {
		System.out.println("intial user count"+UserAccount.getTotalUsers());
		
		
		UserAccount u1 = new UserAccount("Arav");
		UserAccount u2 = new UserAccount("priya");
		UserAccount u3 = new UserAccount("rohan");
		
		
		 System.out.println("Username: " + u1.getUsername());
	     System.out.println("Username: " + u2.getUsername());
	     System.out.println("Username: " + u3.getUsername());

	        
	        System.out.println("Total registered users: " + UserAccount.getTotalUsers());
	    
	
	}
}
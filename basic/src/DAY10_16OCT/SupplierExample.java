package DAY10_16OCT;


import java.util.Random;
import java.util.function.*;
public class SupplierExample {
public static void main(String[] args) {
	Supplier<String>otpGen = ()->{
		Random random =new Random();
		int number = 100000 +random.nextInt(9000000);
		return String.valueOf(number);
		
	};
	String userOtp =otpGen.get();
	System.out.println("the otp is:"+userOtp);
}
}

package DAY10_16OCT;

//
//consumer<T> :r ->"hello","hi"
//Consumer<T>	.accept()	Takes input and returns nothing
//import java.util.function.Consumer;
//
//
//    public static void main(String[] args) {
//
//        Consumer<String> pr =
//                message -> System.out.println(message);
//
//        pr.accept("hello i love cricket");
//    }
//}
//


import java.util.function.*;
public class ConsumerExample {


	
	    public static void main(String[] args) {

	        Consumer<String> smsNotifier = mobNO -> {
	            System.out.println("Sending the OTP to the ph no.: " + mobNO);
	        };

	        smsNotifier.accept("+91 12345678");
	    }
	}
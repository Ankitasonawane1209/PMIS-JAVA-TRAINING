package DAY10_16OCT;



//Supplier<T> is a built-in functional interface in Java that takes no input and returns a result.
//Its abstract method is .get()

import java.util.function.Supplier;
public class Supplier1 {
public static void main(String[] args) {


	        Supplier<String> message = () -> "Hello, I love cricket";

	        System.out.println(message.get());
	    }
	}	



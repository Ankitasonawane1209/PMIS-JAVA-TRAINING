package DAY10_16OCT;




//import java.util.function.*;
//public class function {
//    public static void main(String[] args) {
//
//        Function<String, Integer> getLength = name -> name.length();
//
//        System.out.println(getLength.apply("Java"));
//        System.out.println(getLength.apply("Ankita"));
//    }
//}


//import java.util.function.*;
//
//public class function {
//	  public static void main(String[] args) {
//		  Function<Integer, Integer> square = n -> n * n;
//
//	        System.out.println(square.apply(5));
//	        System.out.println(square.apply(8));
//	    }
//	
//	  }


import java.util.function.*;

public class function {
    public static void main(String[] args) {

        BiFunction<Double, Double, Double> addition =
                (a, b) -> a + b;

        System.out.println(addition.apply(5.0, 3.0));
        System.out.println(addition.apply(8.0, 2.0));
    }
}
package DAY10_16OCT;


/*
one parameter: a -> a * a
two parameters: (a,b) -> a + b;
(int a, int b) -> a + b

*/

/*Built in function interfaces

Predicate<T> test(t) T -> t/f 1/0

*/
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        Predicate<Integer> isAdult = age -> age >= 18;

        System.out.println(isAdult.test(20));
        System.out.println(isAdult.test(15));
    }
}



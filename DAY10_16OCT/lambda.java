package DAY10_16OCT;


//@FunctionalInterface 
//interface Greeter{
//	void greet (String name);
//}
//
//public class lambda {
// public static void main (String[]args) {
//	 Greeter g =name ->System.out.println("hello,"+name);
//	 g.greet("Bhumi");
// 
// }
//}


//multiple line

@FunctionalInterface
interface Greeter {
    void greet(String name);
}

public class lambda {
    public static void main(String[] args) {

        Greeter g1 = name -> {
            System.out.println("hello," + name);
            System.out.println("welcome");
        };

        g1.greet("Bhumi");
    }
}
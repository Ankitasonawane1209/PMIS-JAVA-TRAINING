package DAY9_15OCT;


class Util {
//	This is the method name.
//It suggests that the value should be printed twice, but the current code prints it only once.
    static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    static <T> T firstOf(T a, T b) {
        return b;
    }
}

public class GenricMethod {
    public static void main(String[] args) {

        Util.printTwice(100);

        System.out.println(Util.firstOf("hi", "hello"));
    }
}

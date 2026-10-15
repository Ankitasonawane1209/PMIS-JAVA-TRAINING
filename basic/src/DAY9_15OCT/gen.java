package DAY9_15OCT;



class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

public class gen {
    public static void main(String[] args) {

        Box<String> box = new Box<>();

        box.set("hello");

        String s = box.get();

        System.out.println(s);
    }
}




/*
1. Compile-time errors detected. Without generics, we can't detect
   compile-time errors, and the code will break while executing (runtime).

2. No manual casting.

3. Reusable code. (One Box class works for any type).

Rules:
1. Mention the wrapper class.
2. Java automatically performs autoboxing and unboxing.
*/

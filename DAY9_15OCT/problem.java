package DAY9_15OCT;


class Locker<T>{
	private T item;
	
	void put(T item) {
		this.item=item;
	}
	T get() {
		return item;
		
	}
	
}
public class problem {
public static void main(String[] args) {
	Locker<String> l1=new Locker();
	l1.put("c++ book");
		System.out.println("The locker has:"+l1.get());
		
		Locker<Integer>intlocker =new Locker<>();
		intlocker.put(1234);
		intlocker.put(8990);
		
		System.out.println("Intlocker has:"+intlocker.get());
}
}

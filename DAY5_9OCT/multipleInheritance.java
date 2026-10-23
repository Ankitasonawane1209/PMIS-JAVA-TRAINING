
package DAY5_9OCT;

interface Mother{
	void message();
}
interface Father{
	void message();
}

class Child implements Mother,Father{
	@Override
	public void message() {
 System.out.println("loving mom nad dad both");
}
public class MultipleInheritance {
public static void main(String[] args) {
	Child c =new Child();
	c.message();
	
	Mother m =new Child();
	m.message();
	
	Father f = new Child();
	 m.message();
}
}
}

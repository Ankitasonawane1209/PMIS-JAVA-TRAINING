package DAY6_12OCT;

public class AbstractDriver {
public static void main(String[] args) {
	
	

	        Shape c = new Circle(0.5);
	        Shape r = new Rectangle(12, 6);

	        c.setColor("Orange");
	        r.setColor("Blue");

	        System.out.printf("%s Circle area is %.2f\n",
	                c.getcolor(), c.calculateArea());

	        System.out.printf("%s rectangle area is %.2f\n",
	                r.getcolor(), r.calculateArea());
	    }
	}
package DAY5_9OCT;




class shape{
	String color="blue";
	
}
class circle extends shape{
	void drawcirecle() {
		System.out.println("Drawing a "+color+" circle");
	}
}

class rectangle extends shape{
	void drawRectangle() {
		System.out.println("Drawing a "+color +" reactangle");
	}
}
public class Hierarchical {
public static void main(String[] args) {
	circle c =new circle();
	rectangle r =new rectangle();
	
	c.drawcirecle();
	r.drawRectangle();
	
}
}

package DAY6_12OCT;

 abstract class Shape1{
 
	 String color;
	 
	 
	void  setColor(String color) {
		this.color=color;
		
	}
	abstract double calculateArea();
	 
}
 class Circle1 extends Shape {
	    double radius;
	
	 
	 Circle1(double radius){
		 this.radius=radius;
	 }
	 
	 @Override
	 double calculateArea() {
		 return Math.PI* radius*radius;
	 }
 }
	 class Reactangle  extends Shape{
		 double length;
		 double width;
	 
	
	 Reactangle(double length,double widgth){
		 this.length=length;
		 this.width=width;
	 }
	 @Override
	 double calculateArea() {
		 return length * width;
	 }
	 }
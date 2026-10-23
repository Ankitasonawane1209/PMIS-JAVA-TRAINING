package DAY6_12OCT;

public class HasRelationDriver3 {
public static void main(String[] args) {


	        // Create a Battery object
	        Battery battery = new Battery(5000);

	        // Create a Camera object
	        Camera camera = new Camera(48);

	        // Create a Phone object and pass Battery and Camera objects
	        Phone phone = new Phone("Samsung", battery, camera);

	        // Call the method
	        phone.snapPicture();
	    }
	}




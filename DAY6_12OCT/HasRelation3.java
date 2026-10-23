package DAY6_12OCT;

class Battery{
	int capacityMaH;
	Battery(int capacitymaH){
		this.capacityMaH=capacitymaH;
	}
	void drain() {
		System.out.println("Battery Used.\nCapacity remaining: "+(capacityMaH-100) +"mAh");
	}
}

class Camera {
	int pix;
	
	Camera(int pix){
		this.pix=pix;
	}
	void takePhoto() {
		System.out.println("click...captured a photo with"+pix+"sensor");
	}
}

class Phone{
	String brand;
	Battery battery;
	Camera camera;
	
	
	Phone(String brand,Battery battery,Camera camera){
		this.brand=brand;
		this.battery=battery;
		this.camera=camera;
		
	}
	void snapPicture() {
		System.out.println("["+ brand +"]" +" is active");
		camera.takePhoto();
		battery.drain();
		
	}
}
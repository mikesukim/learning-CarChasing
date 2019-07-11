import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class RobberCar extends Car {
	
	int xRatio;
	int yRatio;
	boolean isCaptured;
	boolean isEscaped;
	static int capturedCarCount;
	static int escapedCarCount;
	
	RobberCar()
	{
		super("RobberCar", 5000, new Engine("RobberCarEngine",20,200),"red-car.jpg");
		this.fillUp();
		xRatio = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		yRatio = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
	}
	
	public void updateState (int widthIn, int heightIn) {
		this.drive(4, xRatio, yRatio);
		
		if (this.isEscaped != true) {
			if (this.getX() > widthIn || this.getX() < 0) {
				this.isEscaped = true;
				escapedCarCount++;
			}
			else if(this.getY() > heightIn || this.getY() < 0) {
				this.isEscaped = true;
				escapedCarCount++;
			}	
		}	
	}
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
	public void captured() {
		super.setImage("jail.jpg");
		this.xRatio = 0;
		this.yRatio = 0;
		if (!this.isCaptured()){
			capturedCarCount ++;
			isCaptured = true;
		}
		
	}
	public boolean isCaptured() {
		if (isCaptured) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasEscaped() {
		if (isEscaped) {
			return true;
		}
		else {
			return false;
		}
	}
}

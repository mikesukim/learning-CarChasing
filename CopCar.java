import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class CopCar extends Car {
	
	static int xRatio;
	static int yRatio;
	
	CopCar()
	{
		super("CopCar", 5000, new Engine("CopCarEngine",30,100),"cop-car.jpg");	
		this.fillUp();
		xRatio = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		yRatio = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
	}
	
	public void updateState (int widthIn, int heightIn) {
		this.drive(2, xRatio, yRatio);
		
		if (this.getX() > widthIn || this.getX() < 0) {
			xRatio = -xRatio;
		}
		else if(this.getY() > heightIn || this.getY() < 0) {
			yRatio = -yRatio;
		}
	}
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
}

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;


class Sprite
{
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }
	
	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	public void updateState (int widthIn, int heightIn) {
		
	}
	public boolean overlaps(Sprite s) {
		
//		if(((this.locationX < s.locationX)&&(s.locationX < this.locationX + 60))||((this.locationX < s.locationX + 60)&&(s.locationX + 60 < this.locationX + 60))){
//			if(((this.locationY < s.locationY)&&(s.locationY < this.locationY + 60))||((this.locationY < s.locationY + 60)&&(s.locationY + 60 < this.locationY + 60))) {
//				return true;
//			}
//		}
//		return false;
		
		Rectangle imageBound = new Rectangle();
		Rectangle imageSBound = new Rectangle();
		imageBound.setBounds(this.locationX, this.locationY, 60, 60);
		imageSBound.setBounds(s.locationX, s.locationY, 60, 60);
		
		if (imageBound.intersects(imageSBound)){
			return true;
		}
		else {
			return false;
		}
		
	}
}
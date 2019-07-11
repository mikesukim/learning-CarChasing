
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements MouseListener,KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
     
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Gets here is left mouse button was clicked
			try {
				model.addSpriteAt(e.getX(),e.getY());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (SwingUtilities.isRightMouseButton(e))  {
			model.updateScene(view.getWidth(),view.getHeight());
		}
		view.repaint();
    }
    
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    		
    		if (e.getKeyChar() == 'n') {
    			System.out.printf("captured RobberCar Number = %d\n escpaed RobberCar Number = %d\n",RobberCar.capturedCarCount,RobberCar.escapedCarCount);
    		}
    		else if (e.getKeyChar() == 'r') {
    			model.initialize();
    			view.repaint();
    		}
    	 		
        	
    }
    @Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
    	
    		if (e.getKeyChar() == 's') {
    			 Thread t1 = new Thread(new SpriteMover(this.model,this.view)); 
    		     t1.start();
    		}
		
	}
    @Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }


}


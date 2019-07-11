import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;



class Model
{
    ArrayList<Sprite> spriteList;
    
    Model() throws IOException 
    {	
    	spriteList = new ArrayList<Sprite>();
		
		Bank bank = new Bank();
		spriteList.add(bank);
		
    }
    
   public void addSpriteAt(int xIn, int yIn) throws IOException 
   {   
	   
	 synchronized(spriteList) {
		 Car car = (this.spriteList.size() % 2 == 0) ? new CopCar() : new RobberCar();  
		     
		   if (car instanceof RobberCar) {
			   car.setX(300);
			   car.setY(300);
		   }
		   else {
			   car.setX(xIn);
			   car.setY(yIn);
		   }
		   
		   this.spriteList.add(car); 
	 }
		     
	 	      
   }

    public void update(Graphics g) {
    	 synchronized(spriteList) {
    		for(Sprite sprite : spriteList) 
    		{
    			sprite.updateImage(g);
    		}
    	 }
    }

    public void updateScene(int widthIn, int heightIn) {

    		
    	synchronized(spriteList) {

			Iterator<Sprite> iterator = spriteList.iterator();
        	while(iterator.hasNext()){
        		Sprite sprite = iterator.next();
        		sprite.updateState(widthIn,heightIn);

        		if (sprite instanceof CopCar) {
        			for (Sprite sprite1 : spriteList){
        				if (sprite1 instanceof RobberCar) {
        					RobberCar robberCar = ((RobberCar) sprite1);
        					if(!(robberCar.isCaptured())) {
        						if (sprite.overlaps(sprite1)) {
        							robberCar.captured();
        						}	
        					}	
        				}
        			}
        		}

        		else if(sprite instanceof RobberCar) {
        			if(((RobberCar) sprite).hasEscaped()) {
        				System.out.print("IMOFREEEE!!!\n");
        				iterator.remove();
        			}
        		}

        	}
		
    	}
	

    }
    
    public void initialize() {
    		
        	this.spriteList = new ArrayList<Sprite>();
        	RobberCar.capturedCarCount = 0;
        	RobberCar.escapedCarCount = 0;
        	Bank bank = new Bank();
    		spriteList.add(bank);
    
    }

}

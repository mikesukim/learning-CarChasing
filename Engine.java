
public class Engine {
	
	private String engineName;		//name of Engine
	private int mpg;				//miles per gallon
	private int maxSpeed;			//maximum speed
	
	public Engine(String engineNameIn, int mpgIn, int maxSpeedIn) 
	{
		this.engineName = (engineNameIn.length() > 0) ? engineNameIn : "Generic engine";
		this.mpg = (mpgIn > 0) ? mpgIn : 0;
		this.maxSpeed = (maxSpeedIn > 0) ? maxSpeedIn : 0;
			
	}
	
	public String getEngineName() 
	{
		return this.engineName;
	}
	
	public int getMpg() 
	{
		return this.mpg;
	}
	
	public int getMaxSpeed()
	{
		return this.maxSpeed;
	}
	
	public String getDescription() {
		
		//e.g. "V6 (MPG: 20, Max speed: 120)"
		String engineDescription = String.format("%s (MPG: %d, Max speed: %d)",this.engineName,this.mpg,this.maxSpeed);
		return engineDescription;
	}
		
}

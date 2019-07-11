
public class GasTank {

	private int capacity;			///measurement unit = gallon
	private double currentLevel;	///measurement unit = gallon
	
	public GasTank(int capacityIn) 
	{
		//set gasCapacity
		this.capacity = (capacityIn > 0) ? capacityIn : 0;
		
		//set currentGasLevel
		this.currentLevel = 0;		
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public double getLevel()
	{
		return currentLevel;
	}
	
	public void setLevel(double levelIn) {
		
		if (levelIn > 0) 
		{
			this.currentLevel = (levelIn > this.capacity) ? this.capacity : levelIn;
		}
		else 
		{
			this.currentLevel = 0;
		}		
	}
	
}

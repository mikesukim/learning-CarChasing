import java.awt.Graphics;

public class Car extends Sprite {

	private String carName;
	private GasTank gasTank;
	private Engine engine;
	
	public Car(String carNameIn, int gasCapacityIn, Engine engineIn, String jpgName)
	{	
		super(jpgName); 
		this.carName = (carNameIn.length() > 0) ? carNameIn : "Generic car";			
		this.gasTank = (gasCapacityIn > 0) ? new GasTank(gasCapacityIn) :  new GasTank(0);
		this.engine = (engineIn != null) ? engineIn : new Engine("", 0, 0);
		
	}
	
	public void updateImage(Graphics g) {
		
		super.updateImage(g);
	}
	
	public String getDescription() 
	{	
		//e.g. "Sweet Ride (engine: V6 (MPG: 20, Max speed: 120)), fuel: 0.00/15, location: (0,0)"
		String carDescription = String.format("%s (engine: %s (MPG: %d, Max speed: %d)), fuel: %.2f/%d, location: (%d,%d)", this.carName,this.engine.getEngineName(),this.engine.getMpg(),this.engine.getMaxSpeed(),this.gasTank.getLevel(),this.gasTank.getCapacity(),getX(),getY());
		return carDescription;		
	}
	
	public double getFuelLevel() 
	{
		return this.gasTank.getLevel();
	}
	
	public int getMPG() 
	{
		return this.engine.getMpg();
	}
	
	public void fillUp()
	{
		this.gasTank.setLevel(this.gasTank.getCapacity());
	}
	
	public int getMaxSpeed() 
	{
		return this.engine.getMaxSpeed();
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		if (!isFuelEnoughFor(distance)) 
		{
			distance = setNewAvailableDistance();
			System.out.printf("Ran out of gas after driving %.2f miles. \n", (double)distance);
		}
		
		setRemainingFuelAfter(distance);
		
		////if statement added due to Assignment4 wrong behavior.
		////if xRatio = 0 && yRatio = 0 then it does not move.
		if((xRatio != 0) || (yRatio != 0)){
			setDestinedCoordinateXY(distance,xRatio,yRatio);
		}
		
		return distance;
	}

	private boolean isFuelEnoughFor(int distance) 
	{
		double currentFuelLevel = getFuelLevel();
		double consumedFuel = calculateConsumedFuel(distance);
		
		if ((currentFuelLevel - consumedFuel) >= 0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void setRemainingFuelAfter(int distance) 
	{	
		double currentFuelLevel = getFuelLevel();
		double consumedFuel = calculateConsumedFuel(distance);
		
		this.gasTank.setLevel(currentFuelLevel-consumedFuel);		
	}
	
	private void setDestinedCoordinateXY(int distance, double xRatio, double yRatio) 
	{
		double oneRatioValue = calculateOneRatioValue(distance,xRatio,yRatio);
		double distanceMovedX = calculateMovedX(oneRatioValue,xRatio);
		double distanceMovedY = calculateMovedY(oneRatioValue,yRatio);	
		
		setX((int) (distanceMovedX + getX()));
		setY((int) (distanceMovedY + getY()));
	}
	
	private double calculateConsumedFuel(int distance) 
	{
		int mpg = getMPG();
		double consumedFuel = (double) distance / mpg;
		
		return consumedFuel;
	}
	
	private int setNewAvailableDistance() 
	{
		int newDistance = (int) (getFuelLevel() * getMPG());
		return newDistance;
	}
	
	private double calculateOneRatioValue(int distance, double xRatio, double yRatio)
	{
		double addedSquaredRatio = Math.pow(xRatio, 2) + Math.pow(yRatio, 2); 
		double squaredDistance = Math.pow(distance, 2);
		double oneRatioSquearedValue = squaredDistance / addedSquaredRatio;
		double oneRatioValue = Math.sqrt(oneRatioSquearedValue);
		return oneRatioValue;
	}
	
	private double calculateMovedX(double oneRatioValue, double xRatio)
	{
		return oneRatioValue * xRatio;
	}
	
	private double calculateMovedY(double oneRatioValue, double yRatio)
	{
		return oneRatioValue * yRatio;
	}
	
}

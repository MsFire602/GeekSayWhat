import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class CalibrateDistance
{
    private DifferentialPilot boticorn;

	public static void main(String[] args)
	{
		CalibrateDistance calibration = new CalibrateDistance();
		calibration.run();
	}
	
	void CalibrateDistance()
	{
		boticorn = new DifferentialPilot(56, 108, Motor.B, Motor.C);
		boticorn.setRotateSpeed(250);
		boticorn.setTravelSpeed(250);
	}
	
	public void run()
	{
		int travelDistance = getTravelDistanceFromCm(20);
		boticorn.travel(travelDistance);
	}
	
	public int getTravelDistanceFromCm(int centimeters)
	{
		return centimeters * 10;
	}

}

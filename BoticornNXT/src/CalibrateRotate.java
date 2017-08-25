import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class CalibrateRotate
{
    private DifferentialPilot boticorn;

	public static void main(String[] args)
	{
		CalibrateRotate calibration = new CalibrateRotate();
		calibration.run();
	}
	
	void CalibrateRotate()
	{
		boticorn = new DifferentialPilot(56, 108, Motor.B, Motor.C);
		boticorn.setRotateSpeed(250);
		boticorn.setTravelSpeed(250);
	}
	
	public void run()
	{
		boticorn.rotate(getCalibratedAngle(360));
	}
	
	public double getCalibratedAngle(double angle)
	{
		return angle * 1.25;
	}
}

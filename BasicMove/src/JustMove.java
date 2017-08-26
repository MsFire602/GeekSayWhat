import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class JustMove
{
	private DifferentialPilot boticorn;
	
	public static void main(String[] args)
	{
		System.out.println("Go Boticorn Go!");
		Button.waitForAnyPress();
		JustMove move = new JustMove();
		move.run();
		//Button.waitForAnyPress();
		
		//Behavior b1 = new mForward();
		////Behavior b2 = new mBack();
	    //Behavior b3 = new HitWall(SensorPort.S4, SensorPort.S3);
	    
	    //Behavior [] bArray = {b1, /*b2,*/ b3};
	    //Arbitrator arby = new Arbitrator(bArray);
	    //arby.start();
	}

	JustMove()
	{
		boticorn = new DifferentialPilot(56, 141, Motor.B, Motor.C);
		boticorn.setRotateSpeed(500);
		boticorn.setTravelSpeed(500);
	}
	
	public void run()
	{
		//openClaws(-15);
		//Challenge1();
		//Challenge4();
		Challenge5();
		boticorn.stop();
	}
	
	public void Challenge1()
	{
		// Press the button and move to pick the cube
		moveForward(950);
		rotateLeft(75);
		moveBack(225);
		rotateLeft(30);
		boticorn.setTravelSpeed(250);
		moveForward(380);
		boticorn.setTravelSpeed(500);
		
		// Use claws
		Motor.A.setSpeed(60);
		Motor.A.rotate(-60);
		Motor.A.stop();
		
		// Travel to drop the cube
		moveBack(300);
		rotateRight(45);
		moveForward(710);
		rotateRight(45);
		moveForward(750);
		rotateRight(25);
		moveForward(395);
		
		Motor.A.rotate(60);

		// Go to finish line
		moveBack(150);
		rotateRight(30);
		moveForward(600);
		rotateLeft(32);
		moveForward(1500);
	}

	public void Challenge4()
	{
		moveForward(200);
		rotateLeft(90);
		moveForward(450);
		rotateRight(80);
		moveForward(340);
		rotateRight(90);
		moveForward(460);
		rotateLeft(100);
		moveForward(340);
		rotateRight(90);
		moveForward(340);
		rotateLeft(45);
	}

	//Challenge5


	public void Challenge5()
	{
		/*LightSensor light = new LightSensor(SensorPort.S3);
		final int blackWhiteThreshold = 5;

		final int forward = 1;
		final int stop = 3;
		final int power = 20;

		// Use the light sensor as a reflection sensor
		//light.setFloodlight(true);

		while (! Button.ESCAPE.isDown())
		{
				if (light.readValue() > blackWhiteThreshold)
				{
					// On white, turn right
					MotorPort.C.controlMotor(0,stop);
					MotorPort.B.controlMotor(power, forward);
					//Button.waitForAnyPress(30);
				}
				else
				{
					// On black, turn left
					MotorPort.C.controlMotor(power, forward);
					MotorPort.B.controlMotor(0,stop);
				}
				
				try{
					Thread.sleep(10);
				}catch(Exception e){}
		}*/
		
		int min = 30;
		int max = 54;
		int readLight = 0;
		int Mspeed = 80;
		int Mspeed2 = 15;
		
		LightSensor ls = new LightSensor(SensorPort.S3);
	       
	    while (! Button.ESCAPE.isDown()) {
	    	Motor.C.forward();
	        Motor.B.forward();
	           
	           readLight = ls.readValue();
	           if (readLight < min){
	        	   readLight = min+1;
	           }

	           if (max < readLight){
	        	   readLight = max-1;
	           }
	   
	           Motor.B.setSpeed(Mspeed + (Mspeed2 * (readLight - min)));
	           Motor.C.setSpeed(Mspeed + (Mspeed2 * (max - readLight)));
	           
	       }
	   }

	public void openClaws(int angle)
	{
		Motor.A.setSpeed(100);
		Motor.A.rotate(angle);
		Motor.A.stop();		
	}

	public double getTravelDistanceFromCm(int centimeters)
	{
		return centimeters * 1.00;
	}
	
	public void moveForward(double cm)
	{
		boticorn.travel(cm);
	}
	
	public void moveBack(double cm)
	{
		boticorn.travel(-cm);
	}
	
	public void rotateLeft(double angle)
	{
		boticorn.rotate(-angle);
	}
	
	public void rotateRight(double angle)
	{
		boticorn.rotate(angle);
	}
}


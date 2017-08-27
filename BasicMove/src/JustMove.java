import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import java.io.File;

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
		for(int ii=1; ii < 6; ii++)
		{
			int Result = runChallenge(ii);
			System.out.println("Challenge " + Result + " completed!");
			int nextChallenge = ii+1;
			System.out.println("*** Press any button to continue to " + nextChallenge);
			Button.waitForAnyPress();
		}

		// If everything goes to shit, do these one by one!
		//Challenge1();
		//Challenge2();
		//Challenge3();
		//Challenge4();
		//Challenge5();
		
		// Secret assignment in the end
		JustDance();
		boticorn.stop();
	}
	
	public int runChallenge(int challenge)
	{
		System.out.println("Challenge " + challenge + " started!");
		switch(challenge)
		{
		case 1:
			Challenge1();
			break;
		case 2:
			Challenge2();
			break;
		case 3:
			Challenge3();
			break;
		case 4:
			Challenge4();
			break;
		case 5:
			Challenge5();
			break;
			default:
				System.out.println("Panic and cry! Wave hands 4 help!");	
			break;
		}
		
		return challenge;
	}
	
	public void Challenge1()
	{
		// Press the button and move to pick the cube
		moveForward(950);
		rotateLeft(75);
		moveBack(235);
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
		moveForward(708);
		rotateRight(50);
		moveForward(750);
		rotateRight(25);
		moveForward(395);
		
		Motor.A.rotate(60);

		// Go to finish line
		moveBack(150);
		rotateRight(30);
		moveForward(600);
		rotateLeft(38);
		moveForward(1500);
	}
	public void Challenge2()
	{
		// Press the button and move to pick the cube
		moveForward(500);
		rotateRight(90);
		moveBack(140);
		moveForward(140);
		rotateRight(80);
		moveForward(310);
		rotateLeft(60);
		Button.waitForAnyPress(3000);
		moveForward(970);
		Button.waitForAnyPress(4700);
		boticorn.setTravelSpeed(650);
		moveForward(390);
		boticorn.setTravelSpeed(500);
		rotateRight(45);
		moveForward(700);
	}
	
	public void Challenge3()
	{
		// Rinteestä lähtö
		moveForward(1600);
		Button.waitForAnyPress(5000);
		moveForward(500);	
	}

	public void Challenge4()
	{
		moveForward(240);
		rotateLeft(78);
		moveForward(485);
		rotateRight(69);
		moveForward(620);
		rotateRight(58);
		moveForward(850);
		rotateLeft(32);
		moveForward(400);
	}

	// Challenge 5
	public void Challenge5()
	{
		moveForward(500);
		boticorn.setTravelSpeed(800);
		moveForward(2700);
    }

	public void JustDance()
	{
		while(true)
		{
		moveForward(300);
		moveBack(300);
		rotateLeft(360);
		rotateRight(360);
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


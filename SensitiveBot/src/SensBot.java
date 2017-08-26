import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class SensBot {
   public static void main(String [] args) {
	  System.out.println("Go Boticorn Go!");
      Button.waitForAnyPress();

	  Behavior b1 = new DriveForward();
      //Behavior b2 = new BatteryLow(6.5f);
      Behavior b2 = new HitWall(SensorPort.S4, SensorPort.S3);
      Behavior [] bArray = {b1, b2/*, b3*/};
      Arbitrator arby = new Arbitrator(bArray);
      arby.start();
   }
}



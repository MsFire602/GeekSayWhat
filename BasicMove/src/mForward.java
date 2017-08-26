import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class mForward  implements Behavior {
   private boolean suppressed = false;
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     Motor.B.forward();
     Motor.C.forward();
     while( !suppressed )
        Thread.yield();
     Motor.B.stop(); // clean up
     Motor.C.stop();
   }
}
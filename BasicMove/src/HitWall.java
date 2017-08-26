import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class HitWall implements Behavior {
    private TouchSensor touch;
    private UltrasonicSensor sonar;
    private boolean suppressed = false;
    
    public HitWall(SensorPort ultraPort, SensorPort touchPort)
    {
       sonar = new UltrasonicSensor(ultraPort);
       touch = new TouchSensor(touchPort);
    }

    public boolean takeControl() {
       return touch.isPressed() || sonar.getDistance() < 25;
    }

    public void suppress() {
       suppressed = true;
    }

    public void action() {
       suppressed = false;
       Motor.B.rotate(-80, true);
       Motor.C.rotate(-160, true);

       while( Motor.C.isMoving() && !suppressed )
         Thread.yield();

       Motor.B.stop();
       Motor.C.stop();
    }
}
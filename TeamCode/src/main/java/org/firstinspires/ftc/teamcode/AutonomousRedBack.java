package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Back")
public class AutonomousRedBack extends Autonomous
{
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnRight();
    driveChassis.moveForward(102);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(102);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.strafeRight(60);
    
    driveChassis.moveForward(102);
    driveChassis.strafeLeft(18);
    
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(45);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    driveChassis.moveForward(90);
    driveChassis.strafeLeft(7);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(75);
  }
  
  
}
  //ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
  //ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
  //ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
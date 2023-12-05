package org.firstinspires.ftc.teamcode;

// tICKs per centimeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Back")
public class AutonomousRedBack extends Autonomous
{
  public void turnColor()
  {
    blang.turnRed();
  }
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its forward");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnRight();
    goTill(105, 15);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(45);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.strafeRight(60);
    driveChassis.moveForward(40);
    driveChassis.strafeLeft(18);
    goTill(70, 15);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(75);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    driveChassis.strafeLeft(7);
    goTill(100, 15);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(60);
  }
  
  
}
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
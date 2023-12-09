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
    driveChassis.strafeRight(3);
    goBackboard(105);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(45);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.strafeRight(60);
    driveChassis.moveForward(60);
    driveChassis.strafeLeft(18);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(55);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    driveChassis.strafeLeft(7);
    goBackboard(100);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(60);
  }
  
  
}
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
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
    goBackboard(105);
    goAwayFromRightWall(65);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(45);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.strafeRight(60);
    driveChassis.moveForward(60);
    goAwayFromRightWall(50);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(60);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    goAwayFromRightWall(70);
    goBackboard(100);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(55);
  }
  
  
}
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
package org.firstinspires.ftc.teamcode;

// tICKs per centimeter = 17.7914

public abstract class AutonomousRedBack extends Autonomous
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
    goAwayFromRightWall(63 + yellowOffset());
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.strafeRight(60);
    driveChassis.moveForward(60);
    goAwayFromRightWall(50 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    goAwayFromRightWall(70 + yellowOffset());
    goBackboard(100);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
  }
  
  
}
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
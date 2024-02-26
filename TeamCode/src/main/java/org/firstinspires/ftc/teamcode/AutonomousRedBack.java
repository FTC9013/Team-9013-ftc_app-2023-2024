package org.firstinspires.ftc.teamcode;

// tICKs per centimeter = 17.7914

public abstract class AutonomousRedBack extends Autonomous
{
  @Override
  public double backboardDirection()
  {
    return -90;
  }
  
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
    driveChassis.straighten(backboardDirection());
    goBackboard(105);
    driveChassis.straighten(backboardDirection());
    goAwayFromRightWall(64 + yellowOffset());
    driveChassis.straighten(backboardDirection());
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(75);
    driveChassis.moveForward(20);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.strafeRight(60);
    driveChassis.moveForward(60);
    driveChassis.straighten(backboardDirection());
    goAwayFromRightWall(53 + yellowOffset());
    driveChassis.straighten(backboardDirection());
    goBackboard(72);
    driveChassis.straighten(backboardDirection());
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(80);
    driveChassis.moveForward(20);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    driveChassis.straighten(backboardDirection());
    goAwayFromRightWall(72 + yellowOffset()); // used to be 72 from right wall
    driveChassis.straighten(backboardDirection());
    goBackboard(100);
    driveChassis.straighten(backboardDirection());
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(85);
    driveChassis.moveForward(20);
  }
  
  
}
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
//ooh eee ooh ahh ahh, ching chang, walla walla bing bang...
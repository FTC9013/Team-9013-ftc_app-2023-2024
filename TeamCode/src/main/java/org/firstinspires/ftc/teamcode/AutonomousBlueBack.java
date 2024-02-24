package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
public abstract class AutonomousBlueBack extends Autonomous
{
  @Override
  public double backboardDirection()
  {
    return 90;
  }
  
  public void turnColor()
  {
    blang.turnBlue();
  }
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Ite no left or reight so fowawrd");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnLeft();
    driveChassis.straighten(backboardDirection());
    goAwayFromLeftWall(60 + yellowOffset());
    goBackboard(100);
    driveChassis.straighten(backboardDirection());
    goAwayFromLeftWall(62 + yellowOffset());
    pixelDropperYellow.drop_pixel();
    //parkingBotCheckBlue(40);
    driveChassis.strafeRight(65);
    driveChassis.moveForward(20);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnLeft();
    driveChassis.turnLeft();
    driveChassis.straighten(backboardDirection());
    goBackboard(95);
    driveChassis.straighten(backboardDirection());
    goAwayFromLeftWall(76 + yellowOffset());
    driveChassis.straighten(backboardDirection());
    pixelDropperYellow.drop_pixel();
    //parkingBotCheckBlue(40);
    driveChassis.strafeRight(40);
    driveChassis.moveForward(20);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.strafeLeft(38);
    driveChassis.moveForward(50);
    goAwayFromLeftWall(53 + yellowOffset());
    driveChassis.straighten(backboardDirection());
    goBackboard(55);
    driveChassis.straighten(backboardDirection());
    goAwayFromLeftWall(53 + yellowOffset());
    pixelDropperYellow.drop_pixel();
    //parkingBotCheckBlue(40);
    driveChassis.strafeRight(65);
    driveChassis.moveForward(20);
  }
  
  
}

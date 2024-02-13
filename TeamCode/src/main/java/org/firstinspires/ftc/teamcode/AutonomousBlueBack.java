package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
public abstract class AutonomousBlueBack extends Autonomous
{
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
    goBackboard(100);
    goAwayFromLeftWall(67 + yellowOffset());
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(40, 55);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnLeft();
    driveChassis.turnLeft();
    goBackboard(95);
    goAwayFromLeftWall(77 + yellowOffset());
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(40, 40);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.strafeLeft(38);
    driveChassis.moveForward(50);
    goAwayFromLeftWall(56 + yellowOffset());
    goBackboard(55);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(40, 70);
  }
  
  
}

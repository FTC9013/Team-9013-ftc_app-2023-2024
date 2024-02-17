package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914

public abstract class AutonomousRedFront extends Autonomous
{
  public void turnColor()
  {
    blang.turnRed();
  }
  
  public void goCenter()
  {
    sleep(5000);
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.strafeRight(9);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    goAwayFromRightWall(70 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
  }
  
  public void goRight()
  {
    sleep(5000);
    telemetry.addLine("PROP DETECTION: Righte");
    telemetry.update();
    driveChassis.moveBackward(3);
    driveChassis.strafeRight(6);
    driveChassis.turnLeft();
    driveChassis.strafeLeft(4);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    goAwayFromRightWall(50 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
    
  }
  
  public void goLeft()
  {
    sleep(5000);
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(5);
    driveChassis.turnRight();
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    goAwayFromRightWall(85.5 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(40);
  }
  
  
}
  
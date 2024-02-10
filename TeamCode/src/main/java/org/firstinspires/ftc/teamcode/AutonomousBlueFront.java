package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914

public abstract class AutonomousBlueFront extends Autonomous
{
  public void turnColor()
  {
    blang.turnBlue();
  }
  
  public void goCenter()
  {
    int strafeDist = 200;
    double wallDist = 0;
    driveChassis.moveForward(2);
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.strafeRight(9);
    
    driveChassis.moveBackward(propSensors.backDistance() - 5);
    wallDist = propSensors.backDistance();
    while (wallDist > 5)
    {
      driveChassis.moveBackward(wallDist - 5);
      wallDist = propSensors.backDistance();
    }
    while (strafeDist > 0)
    {
      if (strafeDist > 50)
      {
        driveChassis.strafeLeft(50);
        strafeDist -= 50;
        if (wallDist < propSensors.backDistance())
        {
          driveChassis.moveForward(wallDist - propSensors.backDistance());
        }
        
      } else
      {
        driveChassis.strafeLeft(strafeDist);
        strafeDist = 0;
        if (wallDist < propSensors.backDistance())
        {
          driveChassis.moveForward(wallDist - propSensors.backDistance());
        }
      }
    }
    driveChassis.moveForward(10);
    driveChassis.turnLeft();
    goAwayFromLeftWall(75 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(50);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(3);
    driveChassis.strafeRight(6);
    driveChassis.turnLeft();
    driveChassis.strafeLeft(4);
    driveChassis.moveBackward(propSensors.backDistance() - 0.5);
    driveChassis.strafeLeft(200);
    driveChassis.turnLeft();
    goAwayFromLeftWall(100 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(45);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(5);
    driveChassis.turnRight();
    driveChassis.moveBackward(propSensors.backDistance() - 0.5);
    driveChassis.strafeLeft(200);
    driveChassis.turnLeft();
    goAwayFromLeftWall(55 + yellowOffset());
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(75);
  }
}
  
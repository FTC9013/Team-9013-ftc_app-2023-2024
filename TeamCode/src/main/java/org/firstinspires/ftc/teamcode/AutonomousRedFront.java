package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Front")
public class AutonomousRedFront extends Autonomous
{
  public void turnColor()
  {
    blang.turnRed();
  }
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.strafeRight(9);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    yellowGoLeft(70);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(50);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Righte");
    telemetry.update();
    driveChassis.strafeRight(6);
    driveChassis.turnLeft();
    driveChassis.strafeLeft(4);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    yellowGoLeft(50);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(125);
    
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(5);
    driveChassis.turnRight();
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeRight(200);
    driveChassis.turnRight();
    yellowGoLeft(78);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckRed(45);
  }
  
  
}
  
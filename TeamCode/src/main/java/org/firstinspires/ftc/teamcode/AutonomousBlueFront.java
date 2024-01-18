package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue Front")
public class AutonomousBlueFront extends Autonomous
{
  public void turnColor()
  {
    blang.turnBlue();
  }
  
  public void goCenter()
  {
    driveChassis.moveForward(2);
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.strafeRight(9);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeLeft(200);
    driveChassis.turnLeft();
    yellowGoRight(75);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(50);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.strafeRight(6);
    driveChassis.turnLeft();
    driveChassis.strafeLeft(4);
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeLeft(200);
    driveChassis.turnLeft();
    yellowGoRight(100);
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
    driveChassis.moveBackward(propSensors.backDistance() - 1);
    driveChassis.strafeLeft(200);
    driveChassis.turnLeft();
    yellowGoRight(55);
    goBackboard(70);
    pixelDropperYellow.drop_pixel();
    parkingBotCheckBlue(75);
  }
}
  
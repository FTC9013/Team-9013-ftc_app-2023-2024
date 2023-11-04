package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Back")
public class AutonomousRedBack extends Autonomous
{
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnRight();
    driveChassis.moveForward(98);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(73);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.strafeRight(30);
    driveChassis.moveForward(88);
    driveChassis.strafeRight(20);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(65);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnRight();
    driveChassis.turnRight();
    driveChassis.moveForward(87);
    driveChassis.strafeLeft(40);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(105);
  }
  
  
}
  
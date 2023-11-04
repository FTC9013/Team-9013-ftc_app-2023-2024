package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Front")
public class AutonomousRedFront extends Autonomous
{
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnLeft();
    driveChassis.moveForward(88);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(73);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnLeft();
    driveChassis.turnLeft();
    driveChassis.moveForward(85);
    
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(100);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.strafeLeft(38);
    driveChassis.moveForward(88);
    driveChassis.strafeRight(17);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeLeft(65);
  }
  
  
}
  
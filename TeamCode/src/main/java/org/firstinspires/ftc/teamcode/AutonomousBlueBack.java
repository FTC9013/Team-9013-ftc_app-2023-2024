package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue Back")
public class AutonomousBlueBack extends Autonomous
{
  
  public void goCenter()
  {
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    driveChassis.moveBackward(8);
    driveChassis.turnLeft();
    goTill(100, 15);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(60);
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
    driveChassis.moveBackward(11);
    driveChassis.turnLeft();
    driveChassis.turnLeft();
    goTill(95, 15);
    
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(45);
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
    driveChassis.strafeLeft(38);
    driveChassis.moveForward(50);
    driveChassis.strafeRight(17);
    goTill(55, 15);
    pixelDropperYellow.drop_pixel();
    driveChassis.strafeRight(75);
  }
  
  
}

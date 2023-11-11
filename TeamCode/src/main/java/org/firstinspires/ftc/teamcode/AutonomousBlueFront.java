package org.firstinspires.ftc.teamcode;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue Front")
public class AutonomousBlueFront extends Autonomous
{
  
  public void goCenter()
  {
    driveChassis.moveForward(2);
    telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
    telemetry.update();
    
  }
  
  public void goRight()
  {
    telemetry.addLine("PROP DETECTION: Right");
    telemetry.update();
  }
  
  public void goLeft()
  {
    telemetry.addLine("PROP DETECTION: Lefte");
    telemetry.update();
  }
  
  
}
  
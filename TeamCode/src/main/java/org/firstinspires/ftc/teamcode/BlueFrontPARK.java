package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue Front PARK")
public class BlueFrontPARK extends Autonomous
{
  @Override
  public double yellowOffset()
  {
    return 0;
  }
  
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
    driveChassis.moveForward(40);
    pixelDropperYellow.drop_pixel();
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
    driveChassis.moveForward(40);
    pixelDropperYellow.drop_pixel();
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
    driveChassis.moveForward(40);
    pixelDropperYellow.drop_pixel();
  }
}
  
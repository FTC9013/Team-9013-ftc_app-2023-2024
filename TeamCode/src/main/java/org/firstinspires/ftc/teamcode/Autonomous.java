package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autononomous", group = "Linear Opmode")
public class Autonomous extends LinearOpMode
{
  public Prop_Sensors propSensors;
  public PixelDropper pixelDropper;
  private final ElapsedTime runtime = new ElapsedTime();
  
  // a timer for the various automation activities.
  @Override
  public void runOpMode()
  {
    propSensors = new Prop_Sensors(hardwareMap, telemetry);
    pixelDropper = new PixelDropper(hardwareMap, telemetry);
    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // setup a instance of our drive system
    // Declare OpMode members.
    MecanumDriveChassis driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    // Wait for the game to start (driver presses PLAY)
    waitForStart();
    runtime.reset();
    // run until the end of the match (driver presses STOP)
    if (opModeIsActive())
    {
      driveChassis.moveForward(83);
      telemetry.addLine("Moved Forward");
      telemetry.update();
      driveChassis.stop_motors();
      if (propSensors.detectProp() == Prop_Sensors.PropSide.Front)
      {
        pixelDropper.drop_pixel();
        telemetry.addLine("Prop on fronte");
        telemetry.update();
      } else if (propSensors.detectProp() == Prop_Sensors.PropSide.Left)
      {
        driveChassis.turnLeft();
        telemetry.addLine("Prop on Lefte");
        pixelDropper.drop_pixel();
        telemetry.update();
      } else if (propSensors.detectProp() == Prop_Sensors.PropSide.Right)
      {
        driveChassis.turnRight();
        pixelDropper.drop_pixel();
        telemetry.addLine("Prop on the Righty");
        telemetry.update();
      }
      while (opModeIsActive())
      {
      
      }
      
      pixelDropper.resetDropper();
      telemetry.update();
      
    }
  }
}
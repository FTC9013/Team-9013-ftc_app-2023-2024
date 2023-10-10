package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

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
    while (opModeIsActive() && propSensors.detectProp() != Prop_Sensors.PropSide.No ) {
      driveChassis.moveForward();
      
    }
    driveChassis.stop_motors();
    if (propSensors.detectProp() == Prop_Sensors.PropSide.Front ) {
      pixelDropper.drop_pixel();
    }
    else if (propSensors.detectProp() == Prop_Sensors.PropSide.Left){
      driveChassis.turnLeft();
      pixelDropper.drop_pixel();
    }
    else if (propSensors.detectProp() == Prop_Sensors.PropSide.Right){
      driveChassis.turnRight();
      pixelDropper.drop_pixel();
      
    }
  }
}
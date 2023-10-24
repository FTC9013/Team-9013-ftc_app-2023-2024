package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

// ticks per centemeter = 17.7914
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autononomous", group = "Linear Opmode")
public class Autonomous extends LinearOpMode
{
  public Prop_Sensors propSensors;
  public PixelDropper pixelDropperPurple;
  public PixelDropper pixelDropperYellow;
  private final ElapsedTime runtime = new ElapsedTime();
  
  
  // a timer for the various automation activities.
  @Override
  public void runOpMode()
  {
    propSensors = new Prop_Sensors(hardwareMap, telemetry);
    pixelDropperPurple = new PixelDropper(hardwareMap, telemetry, "pixelDropperPurple");
    pixelDropperYellow = new PixelDropper(hardwareMap, telemetry, "pixelDropperYellow");
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
      driveChassis.moveForward(78);
      
      telemetry.addLine("Moved Forward");
      telemetry.update();
      
      driveChassis.stop_motors();
      if (propSensors.detectProp() == Prop_Sensors.PropSide.Front)
      {
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("Prop on fronte");
        telemetry.update();
        driveChassis.turnLeft();
        driveChassis.moveForward(100);
        pixelDropperYellow.drop_pixel();
        
      } else if (propSensors.detectProp() == Prop_Sensors.PropSide.Left)
      {
        driveChassis.turnLeft();
        driveChassis.moveForward(10);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("Prop on the Lefte");
        telemetry.update();
        driveChassis.strafeLeft(35);
        driveChassis.moveForward(90);
        driveChassis.strafeRight(35);
      } else if (propSensors.detectProp() == Prop_Sensors.PropSide.Right)
      {
        driveChassis.turnRight();
        driveChassis.strafeLeft(10);
        driveChassis.moveForward(10);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("Prop on the Righty");
        telemetry.update();
        driveChassis.moveBackward(10);
        driveChassis.turnLeft();
        driveChassis.turnLeft();
        driveChassis.moveForward(103);
      } else
      {
        telemetry.addLine("Prop does not exist, I am too dumb to see anything.");
        telemetry.update();
      }
      while (opModeIsActive())
      {
      
      }
      
      
      telemetry.update();
      
    }
  }
}
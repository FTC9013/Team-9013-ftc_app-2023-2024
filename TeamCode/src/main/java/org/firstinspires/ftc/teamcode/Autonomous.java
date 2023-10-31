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
      driveChassis.moveForward(83);
      
      telemetry.addLine("Moved Forward");
      telemetry.update();
      
      driveChassis.stop_motors();
      if (propSensors.detectProp() == Prop_Sensors.PropSide.No)
      {
        telemetry.addLine("Prop aint found so we goin backward");
        telemetry.update();
        driveChassis.moveBackward(3);
        
      }
      if (propSensors.detectProp() == Prop_Sensors.PropSide.No)
      {
        driveChassis.moveBackward(6);
        
        
      }
      
      if (propSensors.detectProp() == Prop_Sensors.PropSide.Left)
      {
        driveChassis.strafeRight(3);
        driveChassis.turnLeft();
        driveChassis.moveForward(9);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Left");
        telemetry.update();
        driveChassis.strafeLeft(38);
        driveChassis.moveForward(92);
        driveChassis.strafeRight(17);
        pixelDropperYellow.drop_pixel();
      } else if (propSensors.detectProp() == Prop_Sensors.PropSide.Right)
      {
        driveChassis.strafeLeft(2);
        driveChassis.turnRight();
        driveChassis.strafeLeft(15);
        driveChassis.moveForward(5);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Right");
        telemetry.update();
        driveChassis.moveBackward(11);
        driveChassis.turnLeft();
        driveChassis.turnLeft();
        driveChassis.moveForward(94);
        driveChassis.strafeRight(6);
        pixelDropperYellow.drop_pixel();
      } else
      {
        telemetry.addLine("No. Just no.");
        telemetry.update();
        driveChassis.moveBackward(2);
        driveChassis.strafeLeft(3);
        driveChassis.moveBackward(2);
        driveChassis.strafeLeft(6);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
        telemetry.update();
        driveChassis.moveBackward(8);
        driveChassis.turnLeft();
        driveChassis.moveForward(92);
        driveChassis.strafeRight(7);
        pixelDropperYellow.drop_pixel();
      }
      while (opModeIsActive())
      {
      
      }
      
      
      telemetry.update();
      
    }
  }
}
//Logan wuz heres ooh hee hee hoo hoo haa haa
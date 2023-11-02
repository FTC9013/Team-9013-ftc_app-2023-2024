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
      driveChassis.moveForward(70);
      Prop_Sensors.PropSide propLocation = Prop_Sensors.PropSide.No;
      driveChassis.startMovingForward(18);
      while (driveChassis.stillMoving())
      {
        if (propLocation == Prop_Sensors.PropSide.No)
        {
          propLocation = propSensors.detectProp();
          telemetry.addLine("neo pruaup fuaund yeat");
        } else
        {
          telemetry.addData("proop finded", propLocation);
        }
        telemetry.update();
      }
      driveChassis.stop_motors();
      
      telemetry.addLine("Moved Forward");
      telemetry.update();
      
      
      if (propLocation == Prop_Sensors.PropSide.Left)
      {
        driveChassis.turnLeft();
        driveChassis.moveForward(9);
        driveChassis.strafeLeft(8);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Lefte");
        telemetry.update();
        driveChassis.strafeLeft(38);
        driveChassis.moveForward(88);
        driveChassis.strafeRight(17);
        pixelDropperYellow.drop_pixel();
        driveChassis.strafeLeft(65);
      } else if (propLocation == Prop_Sensors.PropSide.Right)
      {
        driveChassis.strafeLeft(2);
        driveChassis.turnRight();
        driveChassis.strafeLeft(8);
        driveChassis.moveForward(5);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Right");
        telemetry.update();
        driveChassis.moveBackward(11);
        driveChassis.turnLeft();
        driveChassis.turnLeft();
        driveChassis.moveForward(90);
        driveChassis.strafeRight(6);
        pixelDropperYellow.drop_pixel();
        driveChassis.strafeLeft(90);
      } else
      {
        telemetry.addLine("fooooorrrrwwwwaaaaaaarrrd");
        telemetry.update();
        driveChassis.moveBackward(5);
        driveChassis.strafeLeft(3);
        driveChassis.moveBackward(2);
        driveChassis.strafeLeft(6);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
        telemetry.update();
        driveChassis.moveBackward(8);
        driveChassis.turnLeft();
        driveChassis.moveForward(88);
        pixelDropperYellow.drop_pixel();
        driveChassis.strafeLeft(73);
      }
      while (opModeIsActive())
      {
      
      }
      
      
      telemetry.update();
      
    }
  }
}
//Logan wuz heres ooh hee hee hoo hoo haa haa
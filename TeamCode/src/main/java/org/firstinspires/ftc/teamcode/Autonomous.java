package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

// ticks per centemeter = 17.7914
public abstract class Autonomous extends LinearOpMode
{
  public MecanumDriveChassis driveChassis;
  public Prop_Sensors propSensors;
  public PixelDropper pixelDropperPurple;
  public PixelDropper pixelDropperYellow;
  private final ElapsedTime runtime = new ElapsedTime();
  
  public abstract void goLeft();
  
  public abstract void goRight();
  
  public abstract void goCenter();
  
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
    driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    // Wait for the game to start (driver presses PLAY)
    waitForStart();
    runtime.reset();
    // run until the end of the match (driver presses STOP)
    
    if (opModeIsActive())
    {
      driveChassis.moveForward(68);
      Prop_Sensors.PropSide propLocation = Prop_Sensors.PropSide.No;
      driveChassis.startMovingForward(20);
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
        driveChassis.moveForward(2);
        driveChassis.strafeLeft(8);
        pixelDropperPurple.drop_pixel();
        goLeft();
      } else if (propLocation == Prop_Sensors.PropSide.Right)
      {
        driveChassis.strafeLeft(2);
        driveChassis.turnRight();
        driveChassis.strafeLeft(6);
        
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Right");
        telemetry.update();
        goRight();
      } else
      {
        telemetry.addLine("fooooorrrrwwwwaaaaaaarrrd");
        telemetry.update();
        driveChassis.moveBackward(7);
        driveChassis.strafeLeft(3);
        driveChassis.moveBackward(2);
        driveChassis.strafeLeft(6);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Its no left or right so its foward");
        telemetry.update();
        goCenter();
      }
      while (opModeIsActive())
      {
      
      }
      
      
      telemetry.update();
      
    }
  }
}

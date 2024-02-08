package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

// ticks per centemeter = 17.7914
public abstract class Autonomous extends LinearOpMode
{
  public Blang blang;
  public MecanumDriveChassis driveChassis;
  public Prop_Sensors propSensors;
  public PixelDropper pixelDropperPurple;
  public PixelDropper pixelDropperYellow;
  private final ElapsedTime runtime = new ElapsedTime();
  
  public abstract void goLeft();
  
  public abstract void goRight();
  
  public abstract void goCenter();
  
  public abstract void turnColor();
  
  public abstract double yellowOffset();
  
  // a timer for the various automation activities.
  @Override
  public void runOpMode()
  {
    
    blang = new Blang(hardwareMap);
    propSensors = new Prop_Sensors(hardwareMap, telemetry);
    pixelDropperPurple = new PixelDropper(hardwareMap, telemetry, "pixelDropperPurple");
    pixelDropperYellow = new PixelDropper(hardwareMap, telemetry, "pixelDropperYellow");
    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // setup a instance of our drive system
    // Declare OpMode members.
    driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    // Wait for the game to start (driver presses PLAY)
    turnColor();
    waitForStart();
    runtime.reset();
    // run until the end of the match (driver presses STOP)
    
    if (opModeIsActive())
    {
      driveChassis.moveForward(65);
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
        driveChassis.moveForward(5);
        driveChassis.strafeLeft(8);
        pixelDropperPurple.drop_pixel();
        goLeft();
      } else if (propLocation == Prop_Sensors.PropSide.Front)
      {
        telemetry.addLine("forward");
        telemetry.update();
        driveChassis.moveBackward(9);
        driveChassis.strafeLeft(9);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("PROP DETECTION: Front");
        telemetry.update();
        goCenter();
      } else
      {
        driveChassis.strafeLeft(2);
        driveChassis.turnRight();
        driveChassis.strafeLeft(6);
        driveChassis.moveForward(5);
        pixelDropperPurple.drop_pixel();
        telemetry.addLine("Going right");
        telemetry.update();
        goRight();
      }
      
      while (opModeIsActive())
      {
      
      }
      
      
      //telemetry.update();
      
    }
  }
  
  public void goAwayFromLeftWall(double distRight)
  {
    double distTravel = distRight - propSensors.leftDistance();
    driveChassis.strafeRight(distTravel);
  }
  
  public void goAwayFromRightWall(double distLeft)
  {
    double distTravel = distLeft - propSensors.rightDistance();
    driveChassis.strafeLeft(distTravel);
  }
  
  public void parkingBotCheckBlue(double distCm)
  {
    if (propSensors.rightDistance() > distCm)
    {
      driveChassis.strafeRight(distCm);
    } else
    {
      double distance = propSensors.leftDistance() - 2;
      driveChassis.strafeLeft(distance);
    }
  }
  
  public void parkingBotCheckRed(double distCm)
  {
    if (propSensors.leftDistance() > distCm)
    {
      driveChassis.strafeLeft(distCm);
    } else
    {
      double distance = propSensors.rightDistance() - 2;
      driveChassis.strafeRight(distance);
    }
  }
  
  
  public void goBackboard(double failSafe)
  {
    driveChassis.startMovingForward(failSafe, 0.2);
    while (driveChassis.stillMoving())
    {
      telemetry.addData("Front sensor distance is", propSensors.frontDistance());
      if (propSensors.frontDistance() < 30)
      {
        telemetry.addLine("We stopin");
        telemetry.update();
        break;
      }
      telemetry.update();
    }
    driveChassis.stop_motors();
    double howDist = propSensors.frontDistance();
    double howFarGo = 10;
    double howFar = howDist - howFarGo;
    driveChassis.moveForward(howFar);
  }
  
  
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "IMU Test", group = "Linear Opmode")

public class IMUTest extends LinearOpMode
{
  
  public MecanumDriveChassis driveChassis;
  
  @Override
  public void runOpMode()
  {
    driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // setup a instance of our drive system
    // Declare OpMode members.
    MecanumDriveChassis driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    // Wait for the game to start (driver presses PLAY)
    waitForStart();
    // run until the end of the match (driver presses STOP)
    while (opModeIsActive())
    {
      driveChassis.moveForward(10);
      telemetry.addLine("Moved Forward");
      driveChassis.turnRightDistance(100);
      telemetry.addLine("Turned Right");
      sleep(3000);
      driveChassis.straighten(0);
      telemetry.addLine("Straightened");
      sleep(5000);
      telemetry.addLine("Done and waitin.");
      telemetry.update();
    }
  }
}
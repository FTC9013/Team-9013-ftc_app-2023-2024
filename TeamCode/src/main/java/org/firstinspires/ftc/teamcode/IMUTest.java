package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "IMU Test", group = "Linear Opmode")

public class IMUTest extends LinearOpMode
{
  IMU imu;
  public MecanumDriveChassis driveChassis;
  
  @Override
  public void runOpMode()
  {
    imu = hardwareMap.get(IMU.class, "imu");
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
      YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
      double yaw = orientation.getYaw(AngleUnit.DEGREES);
      telemetry.addData("Yaw is", yaw);
      telemetry.update();
      
      
      
      /*driveChassis.moveForward(10);
      telemetry.addLine("Moved Forward");
      driveChassis.turnRightDistance(100);
      telemetry.addLine("Turned Right");
      sleep(3000);
      driveChassis.straighten(0);
      telemetry.addLine("Straightened");
      sleep(5000);
      telemetry.addLine("Done and waitin.");
      telemetry.update();*/
    }
  }
}
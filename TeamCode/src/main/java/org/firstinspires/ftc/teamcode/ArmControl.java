package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmControl
{
  private final DcMotor armMotor;
  private final Servo gripper;
  //private final TouchSensor limitSwitch;
  private final Telemetry telemetry;
  
  
  ArmControl(HardwareMap hardwareMap, Telemetry theTelemetry)
  {
    telemetry = theTelemetry;
    // Initialize the hardware variables
    armMotor = hardwareMap.get(DcMotor.class, "arm");
    gripper = hardwareMap.get(Servo.class, "gripper");
    gripper.setPosition(0);
    //limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
    armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    // Motors on one side reversed to drive forward
    // Reverse the motor that runs backwards when connected directly to the battery
    // A positive power number should drive the robot forward regardless of the motor's position on the robot.
    armMotor.setDirection(DcMotor.Direction.REVERSE);
    armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
  
  public void lower()
  {
    
    armMotor.setPower(-0.6);
    telemetry.addData("Limit Switch is Pressed", "true");
    
  }
  
  public void raise()
  {
    armMotor.setPower(0.6);
    telemetry.addData("Raising", "True");
  }
  
  public void stop()
  {
    
    //telemetry.addData("Limit Switch?", limitSwitch.isPressed() ? "Pressed" : "Not Pressed");
    armMotor.setPower(0);
  }
  
  public void toggleGripper()
  {
    if (gripper.getPosition() == 1)
    {
      gripper.setPosition(0);
    } else
    {
      gripper.setPosition(1);
    }
    telemetry.addData("Gripping", "True");
  }
}

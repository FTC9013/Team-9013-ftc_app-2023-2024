package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmControl
{
  private final DcMotor armMotor;
  private final TouchSensor limitSwitch;
  private final Telemetry telemetry;
  
  
  ArmControl(HardwareMap hardwareMap, Telemetry theTelemetry)
  {
    telemetry = theTelemetry;
    // Initialize the hardware variables
    armMotor = hardwareMap.get(DcMotor.class, "arm");
    limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
    armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    // Motors on one side reversed to drive forward
    // Reverse the motor that runs backwards when connected directly to the battery
    // A positive power number should drive the robot forward regardless of the motor's position on the robot.
    armMotor.setDirection(DcMotor.Direction.REVERSE);
    armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
  
  public void lower()
  {
    if (limitSwitch.isPressed())
    {
      armMotor.setPower(0);
      telemetry.addData("Limit Switch is Pressed", "true");
    } else
    {
      armMotor.setPower(-0.6);
      telemetry.addData("Lowering", "True");
    }
  }
  
  public void raise()
  {
    armMotor.setPower(0.6);
    telemetry.addData("Raising", "True");
  }
  
  public void stop()
  {
    
    telemetry.addData("Limit Switch?", limitSwitch.isPressed() ? "Pressed" : "Not Pressed");
    armMotor.setPower(0);
  }
}









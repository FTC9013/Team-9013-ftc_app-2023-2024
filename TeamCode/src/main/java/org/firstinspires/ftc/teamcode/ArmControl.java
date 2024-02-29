package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmControl
{
  private final DcMotor armMotor;
  private final Servo gripper;
  //private final TouchSensor limitSwitch;
  private final Telemetry telemetry;
  public TouchSensor touchSensor;
  
  
  ArmControl(HardwareMap hardwareMap, Telemetry theTelemetry)
  {
    telemetry = theTelemetry;
    // Initialize the hardware variables
    armMotor = hardwareMap.get(DcMotor.class, "arm");
    gripper = hardwareMap.get(Servo.class, "gripper");
    touchSensor = hardwareMap.get(TouchSensor.class, "arm_failsafe");
    gripper.setPosition(0);
    //limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
    armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    // Motors on one side reversed to drive forward
    // Reverse the motor that runs backwards when connected directly to the battery
    // A positive power number should drive the robot forward regardless of the motor's position on the robot.
    armMotor.setDirection(DcMotor.Direction.REVERSE);
    armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
  
  public void armLower()
  {
    
    
    if (!touchSensor.isPressed())
    {
      armMotor.setPower(0.7);
      telemetry.addLine("Goging downe in the G R I P P E R arm");
    } else
    {
      telemetry.addLine("Stoping the G R I P P E R arm");
      armStop();
    }
    
  }
  
  public void armRaise()
  {
    armMotor.setPower(-0.6);
    telemetry.addData("Raising G R I P P E R", "True");
  }
  
  public void armStop()
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
    telemetry.addData("G R I P P I N G", "True");
  }
}

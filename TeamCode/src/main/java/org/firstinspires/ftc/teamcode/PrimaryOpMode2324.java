/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
 * This OpMode executes a POV Game style Teleop for a direct drive robot
 * The code is structured as a LinearOpMode
 *
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the arm using the Gamepad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name = "Primary Op Mode 23-24", group = "Robot")

public class PrimaryOpMode2324 extends LinearOpMode
{
  
  /* Declare OpMode members. */
  public DcMotor driveMotor = null;
  public Sweeper sweeper;
  public AirplaneLauncher airplane;
  public MecanumDriveChassis driveChassis;
  public Prop_Sensors prop_sensors;
  public PixelDropper pixelDropper;
  
  @Override
  public void runOpMode()
  {
    
    sweeper = new Sweeper(hardwareMap, telemetry);
    airplane = new AirplaneLauncher(hardwareMap, telemetry);
    driveChassis = new MecanumDriveChassis(hardwareMap, telemetry);
    prop_sensors = new Prop_Sensors(hardwareMap, telemetry);
    pixelDropper = new PixelDropper(hardwareMap, telemetry);
    telemetry.addData(">", "Robot Ready.  Press Play.");    //
    telemetry.update();
    
    // Wait for the game to start (driver presses PLAY)
    waitForStart();
    
    // run until the end of the match (driver presses STOP)
    while (opModeIsActive())
    {
      if (gamepad1.left_bumper)
      {
        sweeper.sweepIn();
      } else if (gamepad1.right_bumper)
      {
        sweeper.sweepOut();
      } else
      {
        sweeper.sweepStop();
      }
      if (gamepad1.right_trigger > 0.75 && gamepad1.left_trigger > 0.75)
      {
        airplane.launch();
      }
      if (gamepad1.right_trigger > 0.75 && gamepad1.x)
      {
        airplane.resetLauncher();
      }
      if (gamepad1.right_bumper && gamepad1.right_trigger > 0.75)
      {
        pixelDropper.drop_pixel();
      }
      if (gamepad1.left_bumper && gamepad1.left_trigger > 0.75)
      {
        pixelDropper.resetDropper();
      }
      prop_sensors.detectProp();
      telemetry.update();
      
      telemetry.addData("LStickY", gamepad1.left_stick_y * -1);
      telemetry.addData("LStickX", gamepad1.left_stick_x);
      telemetry.addData("vD: ", 1000);
      telemetry.update();
      
      driveChassis.drive(gamepad1.left_stick_y, gamepad1.left_stick_x,
        gamepad1.right_stick_x, gamepad1.left_bumper);
      // Pace this loop so jaw action is reasonable speed.
      sleep(50);
    }
  }
}

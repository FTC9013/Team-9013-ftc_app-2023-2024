/* Copyright (c) 2017-2020 FIRST. All rights reserved.
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

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import androidx.annotation.NonNull;

/*
 * This OpMode shows how to use a color sensor in a generic
 * way, regardless of which particular make or model of color sensor is used. The OpMode
 * assumes that the color sensor is configured with a name of "sensor_color".
 *
 * There will be some variation in the values measured depending on the specific sensor you are using.
 *
 * You can increase the gain (a multiplier to make the sensor report higher values) by holding down
 * the A button on the gamepad, and decrease the gain by holding down the B button on the gamepad.
 *
 * If the color sensor has a light which is controllable from software, you can use the X button on
 * the gamepad to toggle the light on and off. The REV sensors don't support this, but instead have
 * a physical switch on them to turn the light on and off, beginning with REV Color Sensor V2.
 *
 * If the color sensor also supports short-range distance measurements (usually via an infrared
 * proximity sensor), the reported distance will be written to telemetry. As of September 2020,
 * the only color sensors that support this are the ones from REV Robotics. These infrared proximity
 * sensor measurements are only useful at very small distances, and are sensitive to ambient light
 * and surface reflectivity. You should use a different sensor if you need precise distance measurements.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

public class Prop_Sensors
{
  
  /** The colorSensor field will contain a reference to our color sensor hardware object */
  NormalizedColorSensor frontSensor;
  NormalizedColorSensor rightSensor;
  NormalizedColorSensor leftSensor;
  
  /** The relativeLayout field is used to aid in providing interesting visual feedback
   * in this sample application; you probably *don't* need this when you use a color sensor on your
   * robot. Note that you won't see anything change on the Driver Station, only on the Robot Controller. */
  View relativeLayout;
  private final Telemetry telemetry;
  
  enum PropSide
  {Right, Left, Front, No}
  
  Prop_Sensors(@NonNull HardwareMap hardwareMap, Telemetry theTelemetry)
  {
    telemetry = theTelemetry;
    int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
    relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
    frontSensor = hardwareMap.get(NormalizedColorSensor.class, "frontSensor");
    leftSensor = hardwareMap.get(NormalizedColorSensor.class, "leftSensor");
    rightSensor = hardwareMap.get(NormalizedColorSensor.class, "rightSensor");
    
  }
  
  
  
  /*
   * The runOpMode() method is the root of this OpMode, as it is in all LinearOpModes.
   * Our implementation here, though is a bit unusual: we've decided to put all the actual work
   * in the runSample() method rather than directly in runOpMode() itself. The reason we do that is
   * that in this sample we're changing the background color of the robot controller screen as the
   * OpMode runs, and we want to be able to *guarantee* that we restore it to something reasonable
   * and palatable when the OpMode ends. The simplest way to do that is to use a try...finally
   * block around the main, core logic, and an easy way to make that all clear was to separate
   * the former from the latter in separate methods.
   */
  
  
  protected PropSide detectProp()
  {
    // You can give the sensor a gain value, will be multiplied by the sensor's raw value before the
    // normalized color values are calculated. Color sensors (especially the REV Color Sensor V3)
    // can give very low values (depending on the lighting conditions), which only use a small part
    // of the 0-1 range that is available for the red, green, and blue values. In brighter conditions,
    // you should use a smaller gain than in dark conditions. If your gain is too high, all of the
    // colors will report at or near 1, and you won't be able to determine what color you are
    // actually looking at. For this reason, it's better to err on the side of a lower gain
    // (but always greater than  or equal to 1).
    float gain = 2;
    
    // Once per loop, we will update this hsvValues array. The first element (0) will contain the
    // hue, the second element (1) will contain the saturation, and the third element (2) will
    // contain the value. See http://web.archive.org/web/20190311170843/https://infohost.nmt.edu/tcc/help/pubs/colortheory/web/hsv.html
    // for an explanation of HSV color.
    final float[] hsvValues = new float[3];
    
    // xButtonPreviouslyPressed and xButtonCurrentlyPressed keep track of the previous and current
    // state of the X button on the gamepad
    
    // Get a reference to our sensor object. It's recommended to use NormalizedColorSensor over
    // ColorSensor, because NormalizedColorSensor consistently gives values between 0 and 1, while
    // the values you get from ColorSensor are dependent on the specific sensor you're using
    
    
    // Tell the sensor our desired gain value (normally you would do this during initialization,
    // not during the loop)
    frontSensor.setGain(gain);
    leftSensor.setGain(gain);
    rightSensor.setGain(gain);
    
    // Get the normalized colors from the sensor
    NormalizedRGBA frontColors = frontSensor.getNormalizedColors();
    NormalizedRGBA leftColors = leftSensor.getNormalizedColors();
    NormalizedRGBA rightColors = rightSensor.getNormalizedColors();
    
    
    /* Use telemetry to display feedback on the driver station. We show the red, green, and blue
     * normalized values from the sensor (in the range of 0 to 1), as well as the equivalent
     * HSV (hue, saturation and value) values. See http://web.archive.org/web/20190311170843/https://infohost.nmt.edu/tcc/help/pubs/colortheory/web/hsv.html
     * for an explanation of HSV color. */
    
    // Update the hsvValues array by passing it to Color.colorToHSV()
    Color.colorToHSV(frontColors.toColor(), hsvValues);
    /* If this color sensor also has a distance sensor, display the measured distance.
     * Note that the reported distance is only useful at very close range, and is impacted by
     * ambient light and surface reflectivity. */
    if (frontSensor instanceof DistanceSensor)
    {
      telemetry.addData("Port 0, Front Sensor | Distance (cm)", "%.3f", ((DistanceSensor) frontSensor).getDistance(DistanceUnit.CM));
      if (((DistanceSensor) frontSensor).getDistance(DistanceUnit.CM) < 3.5)
      {
        telemetry.addLine("It on de front");
        return PropSide.Front;
      }
    }
    
    if (leftSensor instanceof DistanceSensor)
    {
      telemetry.addData("Port 1, Left Sensor | Distance (cm)", "%.3f", ((DistanceSensor) leftSensor).getDistance(DistanceUnit.CM));
      if (((DistanceSensor) leftSensor).getDistance(DistanceUnit.CM) < 3.5)
      {
        telemetry.addLine("It on de lefte");
        return PropSide.Left;
      }
    }
    
    if (rightSensor instanceof DistanceSensor)
    {
      telemetry.addData("Port 2, Right Sensor | Distance (cm)", "%.3f", ((DistanceSensor) rightSensor).getDistance(DistanceUnit.CM));
      if (((DistanceSensor) rightSensor).getDistance(DistanceUnit.CM) < 3.5)
      {
        telemetry.addLine("It on de rite");
        return PropSide.Right;
      }
    }
    return PropSide.No;
  }
}
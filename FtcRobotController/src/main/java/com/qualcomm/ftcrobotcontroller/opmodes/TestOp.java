package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by root on 10/14/2015.
 */
public class TestOp extends OpMode {

    DcMotor leftmotor;
    DcMotor rightmotor;


    @Override
    public void init() {
    leftmotor = hardwareMap.dcMotor.get("left_drive");
    rightmotor = hardwareMap.dcMotor.get("right_drive");

    rightmotor.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        float xValue = gamepad1.right_stick_x;
        float yValue = -gamepad1.right_stick_y;

        float leftPower = yValue + xValue;
        float rightPower = yValue - xValue;

        leftPower = Range.clip(leftPower, -1, 1);      //if gamepad inputs are >1 or <-1, set them to 1 or -1, respectively
        rightPower = Range.clip(rightPower, -1, 1);    //replace this later with a scaling method

        leftmotor.setPower(leftPower);
        rightmotor.setPower(rightPower);

    }
}

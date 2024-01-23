package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Drive and Lift")
public class DriveAndLift extends LinearOpMode  {
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor leftLift;
    public DcMotor rightLift;

    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        leftLift.setDirection(DcMotor.Direction.REVERSE);
        rightLift.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while(opModeIsActive()) {
            // Drive
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            double left = drive + turn;
            double right = drive - turn;

            leftDrive.setPower(left);
            rightDrive.setPower(right);

            // Operator
            double lift = -gamepad2.left_stick_y;

            leftLift.setPower(lift);
            rightLift.setPower(lift);

            telemetry.addData("Right", right);
            telemetry.addData("Left", left);
        }
    }
    }


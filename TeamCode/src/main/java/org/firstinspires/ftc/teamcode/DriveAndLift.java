package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Drive and Lift")
public class DriveAndLift extends LinearOpMode  {
    // Initialization of motors
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor leftLift;
    public DcMotor rightLift;
    public ServoMotor wrist
    public ServoMotor claw

    @Override
    public void runOpMode() {
        // Get drive motors from the control hub
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        // Get lift motors from the control hub
        leftLift = hardwareMap.get(DcMotor.class, "leftLift");
        rightLift = hardwareMap.get(DcMotor.class, "rightLift");

        // Reverse the direction of the left drive and lift motors (remember: the axles are facing opposite directions)
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        leftLift.setDirection(DcMotor.Direction.REVERSE);
        rightLift.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the start button to be pressed
        waitForStart();

        // Loop until the op mode is stopped
        while(opModeIsActive()) {
            // Drive
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            // Combine drive and turn for blended motion
            double left = drive + turn;
            double right = drive - turn;

            // Apply power to the motors (note: you may want to apply an if statement or hyperbolic tangent function to the power to normalize it to a range of -1 to 1)

            /*
            The following code is an example of how to apply an if statement to the power to normalize it to a range of -1 to 1
            if (Math.abs(left) > 1) { // Absolute value of left is greater than 1
                left = left / Math.abs(left);
                // Divide left by the absolute value of left (to keep the sign)
                // For instance, if left is -1.5, then left / Math.abs(left) is -1.5 / 1.5 = -1
            }
            if (Math.abs(right) > 1) {
                right = right / Math.abs(right);
            }
             */

            // Apply power to the motors
            leftDrive.setPower(left);
            rightDrive.setPower(right);

            // Operator
            double lift = -gamepad2.left_stick_y;
            single claw = gamepad2.left_back_y;
            single wrist = gamepad2.right_back_y;

            // Apply power to the motors
            leftLift.setPower(lift);
            rightLift.setPower(lift);

            // Telemetry (print statements) to the driver station
            telemetry.addData("Right", right);
            telemetry.addData("Left", left);
        }
    }
    }


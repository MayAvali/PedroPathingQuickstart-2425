package pedroPathing.Underdawgs.teleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import pedroPathing.Underdawgs.Subsystems.Claw;
import pedroPathing.Underdawgs.Subsystems.Slides;
import pedroPathing.Underdawgs.Subsystems.Mecanum;

import pedroPathing.Underdawgs.Libraries.GamepadButton;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOpCompetition", group = "Linear OpMode")
public class TeleOpCompetition extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        GamepadButton slideExtendButton = new GamepadButton(gamepad1, GamepadButton.GamepadKeys.RIGHT_BUMPER);
        GamepadButton slideRotateButton = new GamepadButton(gamepad1, GamepadButton.GamepadKeys.LEFT_BUMPER);
        GamepadButton clawGripButton = new GamepadButton(gamepad1, GamepadButton.GamepadKeys.A);

        waitForStart();
        if(isStopRequested()) return;

        Mecanum drivetrain = new Mecanum(
                hardwareMap.dcMotor.get("leftFront"),
                hardwareMap.dcMotor.get("leftBack"),
                hardwareMap.dcMotor.get("rightFront"),
                hardwareMap.dcMotor.get("rightBack"),
                hardwareMap.get(IMU.class, "imu")
        );

        Slides slides = new Slides(
                hardwareMap.dcMotor.get("slideMotor"),
                hardwareMap.dcMotor.get("slideRotatorMotorR"),
                hardwareMap.dcMotor.get("slideRotatorMotorL")
        );

        Claw claw = new Claw(
                hardwareMap.servo.get("clawServo")
        );

        while(opModeIsActive()) {
            if (slideExtendButton.isPressed()) {
                slides.toggleSlide();
            }
            if (slideRotateButton.isPressed()) {
                slides.toggleSlideRotator();
            }
            if (clawGripButton.isPressed()) {
                claw.toggleClaw();
            }

            drivetrain.botOrientedDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_trigger);

            telemetry.addData("Front Left Motor Power", drivetrain.getFrontLeftPower());
            telemetry.addData("Back Left Motor Power", drivetrain.getBackLeftPower());
            telemetry.addData("Front Right Motor Power", drivetrain.getFrontRightPower());
            telemetry.addData("Back Right Motor Power", drivetrain.getBackRightPower());

            telemetry.addData("Left Stick X " , gamepad1.left_stick_x);
            telemetry.addData("Left Stick Y " , gamepad1.left_stick_y);
            telemetry.addData("Right Stick X " , gamepad1.right_stick_x);
            telemetry.addData("Right Stick Y " , gamepad1.right_stick_y);

            telemetry.addData("Slider Extended", slides.sliderExtended);
            telemetry.addData("Slider Forward", slides.sliderForward);

            telemetry.update();
        }
    }

}

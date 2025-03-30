package pedroPathing.Underdawgs.teleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import pedroPathing.Underdawgs.Subsystems.Mecanum;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOpDrivetrain", group = "Linear OpMode")
public class TeleOpDrivetrain extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Mecanum drivetrain = new Mecanum(
                hardwareMap.dcMotor.get("leftFront"),
                hardwareMap.dcMotor.get("leftBack"),
                hardwareMap.dcMotor.get("rightFront"),
                hardwareMap.dcMotor.get("rightBack"),
                hardwareMap.get(IMU.class, "imu")
        );
        waitForStart();
        if(isStopRequested()) return;

        while(opModeIsActive()) {
            drivetrain.botOrientedDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_trigger);

            telemetry.addData("Front Left Motor Power", drivetrain.getFrontLeftPower());
            telemetry.addData("Back Left Motor Power", drivetrain.getBackLeftPower());
            telemetry.addData("Front Right Motor Power", drivetrain.getFrontRightPower());
            telemetry.addData("Back Right Motor Power", drivetrain.getBackRightPower());

            telemetry.addData("Left Stick X " , gamepad1.left_stick_x);
            telemetry.addData("Left Stick Y " , gamepad1.left_stick_y);
            telemetry.addData("Right Stick X " , gamepad1.right_stick_x);
            telemetry.addData("Right Stick Y " , gamepad1.right_stick_y);

            telemetry.update();
        }
    }

}

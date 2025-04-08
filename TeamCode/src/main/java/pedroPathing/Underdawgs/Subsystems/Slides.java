package pedroPathing.Underdawgs.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Slides {
    private DcMotor slideMotor;
    private DcMotor slideRotatorMotorR;
    private DcMotor slideRotatorMotorL;
    boolean sliderExtended = false;
    boolean sliderForward = false;
    public Slides(DcMotor slideMotor, DcMotor slideRotatorMotorR, DcMotor slideRotatorMotorL) {
        this.slideMotor = slideMotor;
        this.slideRotatorMotorR = slideRotatorMotorR;
        this.slideRotatorMotorL = slideRotatorMotorL;

        slideMotor.setDirection(DcMotor.Direction.REVERSE);
        slideRotatorMotorR.setDirection(DcMotor.Direction.REVERSE);
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideRotatorMotorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideRotatorMotorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        slideMotor.setTargetPosition(0);
        slideRotatorMotorR.setTargetPosition(0);
        slideRotatorMotorL.setTargetPosition(0);

        slideMotor.setPower(1);
        slideRotatorMotorR.setPower(0.5);
        slideRotatorMotorL.setPower(0.5);

        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideRotatorMotorR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideRotatorMotorL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void toggleSlide() {
        sliderExtended = !sliderExtended;
        slideUpdate();
    }
    public void slideUpdate() {
        if (sliderExtended) {
            slideMotor.setTargetPosition(sliderForward ? 1500 : 4200);
        } else {
            slideMotor.setTargetPosition(0);
        }
    }
    public void toggleSlideRotator() {
        sliderForward = !sliderForward;
        slideRotatorUpdate();
    }
    public void slideRotatorUpdate() {
        if (sliderForward) {
            slideRotatorMotorR.setTargetPosition(750);
            slideRotatorMotorL.setTargetPosition(750);
        } else {
            slideRotatorMotorR.setTargetPosition(0);
            slideRotatorMotorL.setTargetPosition(0);
        }
    }
}

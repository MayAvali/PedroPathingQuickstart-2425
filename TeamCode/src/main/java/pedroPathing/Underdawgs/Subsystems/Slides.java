package pedroPathing.Underdawgs.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Slides {
    private DcMotor slideMotor;
    private DcMotor slideRotatorMotorR;
    private DcMotor slideRotatorMotorL;
    public static boolean sliderExtended = false;
    public static int sliderForward = 0;
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
            if (sliderForward == 0) {
                slideMotor.setTargetPosition(4200);
            } else {
                slideMotor.setTargetPosition(500);
            } 
        } else {
            slideMotor.setTargetPosition(0);
        }
    }
    public void toggleSlideRotator() {
        slideRotatorUpdate();
        SliderForwardTick();
    }
    public void slideRotatorUpdate() {
        if ((sliderForward == 0) & !sliderExtended) {
            slideRotatorMotorR.setTargetPosition(800);
            slideRotatorMotorL.setTargetPosition(800);
        } else if (sliderForward == 1) {
            slideRotatorMotorR.setTargetPosition(900);
            slideRotatorMotorL.setTargetPosition(900);
        } else if (!sliderExtended) {
            slideRotatorMotorR.setTargetPosition(0);
            slideRotatorMotorL.setTargetPosition(0);
        }
    }
    private void SliderForwardTick() {
        if (sliderForward > 1 && !sliderExtended) {
            sliderForward = 0;
        } else if (((sliderForward == 0) && !sliderExtended) || sliderForward == 1) {
            sliderForward++;
        }

    }
}
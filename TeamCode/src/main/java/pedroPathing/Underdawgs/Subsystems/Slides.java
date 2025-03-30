package pedroPathing.Underdawgs.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Slides {
    private DcMotor slideMotor;
    private DcMotor slideRotatorMotor;
    boolean sliderExtended = false;
    boolean sliderForward = false;
    public Slides(DcMotor slideMotor, DcMotor slideRotatorMotor) {
        this.slideMotor = slideMotor;
        this.slideRotatorMotor = slideRotatorMotor;

        //slideMotor.setDirection(DcMotor.Direction.REVERSE);
        //slideRotatorMotor.setDirection(DcMotor.Direction.REVERSE);
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideRotatorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        slideMotor.setTargetPosition(0);
        slideRotatorMotor.setTargetPosition(0);

        slideMotor.setPower(0.5);
        slideRotatorMotor.setPower(0.5);

        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideRotatorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setSlideTarget(int target) {slideMotor.setTargetPosition(target);}
    public void setSlideRotatorTarget(int target) {slideRotatorMotor.setTargetPosition(target);}

    public void toggleSlide() {
        sliderExtended = !sliderExtended;
        if (sliderExtended) {
            slideMotor.setTargetPosition(sliderForward ? 1500 : 4200);
        } else {
            slideMotor.setTargetPosition(0);
        }
    }

    public void toggleSlideRotator() {
        sliderForward = !sliderForward;
        if (sliderForward) {
            slideRotatorMotor.setTargetPosition(25);
        } else {
            slideRotatorMotor.setTargetPosition(0);
        }
    }
}

package pedroPathing.Underdawgs.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import pedroPathing.Underdawgs.Subsystems.Slides;

public class Claw {
    private Servo clawServo;

    boolean clawOpen = true;
    public Claw(Servo clawServo) {
        this.clawServo = clawServo;
        clawServo.setPosition(0.2);
    }
    public void toggleClaw() {
        if (clawOpen) {
            clawServo.setPosition(0.1);
            clawOpen = false;
        } else if (Slides.sliderForward || Slides.sliderExtended) {
            clawServo.setPosition(0.2);
            clawOpen = true;
        }
    }
}

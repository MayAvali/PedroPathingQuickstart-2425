package pedroPathing.Underdawgs.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo clawServo;

    boolean clawOpen = true;
    public Claw(Servo clawServo) {
        this.clawServo = clawServo;
        clawServo.setPosition(0.1);
    }
    public void toggleClaw() {
        if (clawOpen) {
            clawServo.setPosition(0.1);
            clawOpen = false;
        } else {
            clawServo.setPosition(0.3);
            clawOpen = true;
        }
    }
}

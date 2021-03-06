package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jennifer on 10/28/2016.
 */
@TeleOp(name = "Winder", group = "Mini Op")
public class Winder extends OpMode {
    private final double winderPower = 0.8;
    public DcMotor winderMotor = null;

    @Override
    public void init() {
        winderMotor = TeamShared.getRobotPart(hardwareMap, RobotPart.windermotor);
        winderMotor.setDirection(DcMotor.Direction.FORWARD);
        winderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        winderMotor.setPower(0);
    }

    @Override
    public void loop() {
        double power = 0;
        if (gamepad2.right_bumper) {
            power = winderPower;
        }
        winderMotor.setPower(power);
        telemetry.addData("Winder power ", power);
    }
}

package com.huskehhh.code.tasks;

import java.util.Timer;

public class UpdateCheck {

    Timer timer;

    public UpdateCheck() {

        timer = new Timer();
        timer.schedule(new UpdateCheckTask(), (5 * 1000));

    }

}

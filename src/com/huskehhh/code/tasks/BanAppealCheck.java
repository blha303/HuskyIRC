package com.huskehhh.code.tasks;

import java.util.Timer;

public class BanAppealCheck {

    Timer timer;

    public BanAppealCheck() {

        timer = new Timer();
        timer.schedule(new UpdateCheckTask(), (5 * 1000));

    }
}

package com.huskehhh.code.tasks;

import java.util.Timer;

public class KDRCheck {

    Timer timer;

    public KDRCheck() {

        timer = new Timer();
        timer.schedule(new KDRCheckTask(), (30000));

    }
}

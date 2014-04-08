package com.huskehhh.code.tasks;

import java.util.Timer;

public class TwitterCheck {

    Timer timer;

    public TwitterCheck() {

        timer = new Timer();
        timer.schedule(new TwitterCheckTask(), (60000));

    }
}

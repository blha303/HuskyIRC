package com.huskehhh.code.tasks;

import java.util.Timer;

public class ConnectionKill {

    Timer timer;

    public ConnectionKill() {

        timer = new Timer();
        timer.schedule(new ConnectionKillTask(), (30 * 1000));

    }

}

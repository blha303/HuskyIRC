package com.huskehhh.code.tasks;

import java.util.Timer;

public class MinecraftServerStatusCheck {

    Timer timer;

    public MinecraftServerStatusCheck() {

        timer = new Timer();
        timer.schedule(new MinecraftServerStatusCheckTask(), 60000); // 1 minute???
        // 60000 / 1000[Milliseconds]
        // = 60 / 60[Seconds]
        // = 1[Minute]

    }
}

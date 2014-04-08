package com.huskehhh.code.tasks;

import java.util.Timer;

public class MinecraftServerStatusCheck {

    Timer timer;

    public MinecraftServerStatusCheck() {

        timer = new Timer();
        timer.schedule(new MinecraftServerStatusCheckTask(), (60000));

    }
}

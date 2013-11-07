package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.Utility;

import java.util.TimerTask;

public class UpdateCheckTask extends TimerTask {

    @Override
    public void run() {

        if (Utility.isUpdate()) {

            HuskyIRC.bot.sendMessage(Utility.getUser("Husk", "#oresomecraft"), "There is an update available!");
            HuskyIRC.bot.sendMessage(Utility.getUser("Husk", "#oresomecraft"), "Current version: " + Utility.getVersion());
            HuskyIRC.bot.sendMessage(Utility.getUser("Husk", "#oresomecraft"), "New version: " + Utility.newVersion());

        }

    }

}

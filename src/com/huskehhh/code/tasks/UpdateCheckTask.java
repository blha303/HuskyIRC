package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.Utility;

import java.util.TimerTask;

public class UpdateCheckTask extends TimerTask {

    @Override
    public void run() {

        if (Utility.isUpdate()) {

            Utility.getUser("Husk", "#oresomecraft").sendMessage("There is an update available!");
            Utility.getUser("Husk", "#oresomecraft").sendMessage("Current version: " + Utility.getVersion());
            Utility.getUser("Husk", "#oresomecraft").sendMessage("New version: " + Utility.newVersion());

        }

    }

}

package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {
    @Override
    public void run() {

      //KDRUtil.sendKD("MinecraftUsername", "IRCUsername");
        KDRUtil.sendKD("ScruffyRules", "Scruffeh");
        KDRUtil.sendKD("_Husky_", "Husk");
        KDRUtil.sendKD("123Oblivious", "Obbehhh");
        KDRUtil.sendKD("SuperDuckFace", "SuperDuckFace_");
        KDRUtil.sendKD("psgs", "psgs");
        KDRUtil.sendKD("dutchy336", "SuperDuckFace_");
        KDRUtil.sendKD("dutchy336", "Scruffeh");
        new KDRCheck();
    }
}

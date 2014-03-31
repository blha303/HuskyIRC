package com.huskehhh.code.tasks;

import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {

    @Override
    public void run() {

      //KDRUtil.sendKD("MinecraftUsername,etc", "IRCUsername,etc");
        KDRUtil.sendKD("ScruffyRules", "Scruffeh,Scruff,ScruffDoge");
        KDRUtil.sendKD("_Husky_", "Husk");
        KDRUtil.sendKD("123Oblivious", "Obby,Obbehhh");
        KDRUtil.sendKD("SuperDuckFace,dutchy336", "SuperDuckFace_");
        KDRUtil.sendKD("psgs", "psgs");

        KDRUtil.updateUserKD("ScruffyRules,_Husky_,SuperDuckFace,dutchy336,psgs,123Oblivious");

        new KDRCheck();
    }
}

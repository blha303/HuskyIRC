package com.huskehhh.code.tasks;

import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {
    @Override
    public void run() {

      //KDRUtil.sendKD("MinecraftUsername,etc", "IRCUsername,etc");
        KDRUtil.sendKD("ScruffyRules,_Husky_,dutchy336,psgs,SuperDuckFace,zachoz", "Scruffeh,Scruff,ScruffDoge");
        KDRUtil.sendKD("_Husky_", "Husk");
        KDRUtil.sendKD("123Oblivious", "Obbehhh,Obby");
        KDRUtil.sendKD("SuperDuckFace,dutchy336", "SuperDuckFace_,SuperDuckFace");
        KDRUtil.sendKD("psgs", "psgs");
        KDRUtil.sendKD("xCreeeeepz", "#OresomeCraft-Battles");

        new KDRCheck();
    }
}

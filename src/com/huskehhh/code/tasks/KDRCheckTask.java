package com.huskehhh.code.tasks;

import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {
    @Override
    public void run() {

      //KDRUtil.sendKD("MinecraftUsername", "IRCUsername");
        KDRUtil.sendKD("ScruffyRules,_Husky_,dutchy336,psgs,SuperDuckFace", "Scruffeh,Scruff,ScruffDoge");
        KDRUtil.sendKD("123Oblivious", "Obbehhh,Obby");
        KDRUtil.sendKD("SuperDuckFace,dutchy336", "SuperDuckFace_,SuperDuckFace");
        KDRUtil.sendKD("psgs", "psgs");

        new KDRCheck();
    }
}

package com.huskehhh.code.tasks;

import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {

    @Override
    public void run() {

      //KDRUtil.sendKD("MinecraftUsername,etc", "IRCUsername,etc");
        System.out.println("KDRCheck: Start!");
        long startTime = System.currentTimeMillis();
        
        KDRUtil.sendKD("ScruffyRules", "Scruffeh,Scruff,ScruffDoge");
        KDRUtil.sendKD("_Husky_", "Husk");
        KDRUtil.sendKD("123Oblivious", "Obby,Obbehhh");
        KDRUtil.sendKD("SuperDuckFace,dutchy336", "SuperDuckFace_");
        KDRUtil.sendKD("psgs", "psgs");
        
        System.out.println("KDRCheck: End!");
        System.out.println("KDRCheck took " + (System.currentTimeMillis() - startTime) + "ms");
        
        long startTime = System.currentTimeMillis();
        KDRUtil.updateUserKD("ScruffyRules,_Husky_,dutchy336,psgs,SuperDuckFace,123Oblivious");
        System.out.println("KDRUpdate took " + (System.currentTimeMillis() - startTime) + "ms");

        new KDRCheck();
    }
}

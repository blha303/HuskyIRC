package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.KDRUtil;
import java.util.TimerTask;

public class KDRCheckTask extends TimerTask {
    @Override
    public void run() {
        String KD = KDRUtil.getKD("ScruffyRules");

        if (!KD.equals(KDRUtil.getLastKD("ScruffyRules"))) {
            HuskyIRC.bot.sendMessage("Scruffeh","You have a new KDR:" + KD + ", Previous: " + KDRUtil.getLastKD("ScruffyRules"));
            KDRUtil.setLastKD(KD,"ScruffyRules");
        }
        new KDRCheck();
    }
}
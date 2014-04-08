package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.BanAppealUtil;

import java.util.TimerTask;

public class BanAppealCheckTask extends TimerTask {

    String channel = "#OresomeCraft-Admin";

    @Override
    public void run() {

        String title =  BanAppealUtil.getTitle();
        if (!title.equals(BanAppealUtil.getLastTitle())) {

            HuskyIRC.bot.joinChannel(channel);
            HuskyIRC.bot.sendMessage(channel, "New ban appeal!");
            HuskyIRC.bot.sendMessage(channel, BanAppealUtil.getTitle() + " posted by " + BanAppealUtil.getAuthor());
            HuskyIRC.bot.sendMessage(channel, "Posted on: " + BanAppealUtil.getDate());
            HuskyIRC.bot.sendMessage(channel, "More info here: " + BanAppealUtil.getLink());

            HuskyIRC.bot.sendMessage("Scruff","Check #OresomeCraft-Admin!");

            BanAppealUtil.setLastTitle(title);
        }
        new BanAppealCheck();
    }
}

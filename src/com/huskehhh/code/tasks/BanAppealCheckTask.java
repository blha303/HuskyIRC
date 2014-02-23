package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.BanAppealUtil;

import java.util.TimerTask;

public class BanAppealCheckTask extends TimerTask {

    private String channel = "#OresomeCraft-Admin";

    @Override
    public void run() {

        if (!BanAppealUtil.getTitle().equals(BanAppealUtil.lastTitle)) {

            HuskyIRC.bot.joinChannel(channel);
            HuskyIRC.bot.sendMessage(channel, "New ban appeal!");
            HuskyIRC.bot.sendMessage(channel, BanAppealUtil.getTitle() + " posted by " + BanAppealUtil.getAuthor());
            HuskyIRC.bot.sendMessage(channel, "Posted on: " + BanAppealUtil.getDate());
            HuskyIRC.bot.sendMessage(channel, "More info here: " + BanAppealUtil.getLink());

            HuskyIRC.bot.sendMessage("Scruffeh","Check #OresomeCraft-Admin!");

            BanAppealUtil.lastTitle = BanAppealUtil.getTitle();
        }
        new BanAppealCheck();
    }
}

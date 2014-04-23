package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Permissions extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (Utility.isAdminV2(event.getUser().getNick())) {

            if (line[0].equalsIgnoreCase("!op") && event.getUser().isVerified()) {

                HuskyIRC.bot.op(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

            } else if (line[0].equalsIgnoreCase("!deop") && event.getUser().isVerified()) {

                HuskyIRC.bot.deOp(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

            } else if (line[0].equalsIgnoreCase("!voice") && event.getUser().isVerified()) {

                HuskyIRC.bot.voice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

            } else if (line[0].equalsIgnoreCase("!devoice") && event.getUser().isVerified()) {

                HuskyIRC.bot.deVoice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

            } else if (line[0].equalsIgnoreCase("!reload") && event.getUser().isVerified()) {

                Config.loadConfiguration();
                event.respond("Config reloaded!");

            }

        }

    }

}

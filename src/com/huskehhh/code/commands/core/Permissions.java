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

            if (event.getUser().isVerified()) {

                if (line[0].equalsIgnoreCase("!op")) {

                    HuskyIRC.bot.op(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

                } else if (line[0].equalsIgnoreCase("!deop")) {

                    HuskyIRC.bot.deOp(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

                } else if (line[0].equalsIgnoreCase("!voice")) {

                    HuskyIRC.bot.voice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

                } else if (line[0].equalsIgnoreCase("!devoice")) {

                    HuskyIRC.bot.deVoice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

                } else if (line[0].equalsIgnoreCase("!reload")) {

                    Config.loadConfiguration();
                    event.respond("Config reloaded!");

                }

            } else {

                event.respond("You need to be authenticated with NickServ!");

            }

        } else {

            event.respond("You need to be Admin to do this");

        }

    }

}

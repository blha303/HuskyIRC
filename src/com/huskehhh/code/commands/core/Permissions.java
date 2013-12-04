package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Permissions extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!op") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.sendRawLineNow("/chanserv flags " + event.getChannel() + line[1] + " AOP");

        } else if (line[0].equalsIgnoreCase("!deop") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.sendRawLineNow("/chanserv flags " + event.getChannel() + line[1] + " -*");

        } else if (line[0].equalsIgnoreCase("!voice") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.sendRawLineNow("/chanserv flags " + event.getChannel() + line[1] + " VOP");

        } else if (line[0].equalsIgnoreCase("!devoice") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.sendRawLineNow("/chanserv flags " + event.getChannel() + line[1] + " -*");

        }

    }

}

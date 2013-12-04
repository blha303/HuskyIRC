package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Permissions extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!op") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.op(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

        } else if (line[0].equalsIgnoreCase("!deop") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.deOp(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

        } else if (line[0].equalsIgnoreCase("!voice") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.voice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

        } else if (line[0].equalsIgnoreCase("!devoice") && AuthCheck.authCheck(event.getUser().getNick())) {

            HuskyIRC.bot.deVoice(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));

        }

    }

}

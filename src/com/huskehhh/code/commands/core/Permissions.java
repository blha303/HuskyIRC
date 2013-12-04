package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Permissions extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!op")) {

            HuskyIRC.bot.sendRawLineNow("/msg ChanServ AOP " + event.getChannel() + " ADD " + line[1]);

        } else if (line[0].equalsIgnoreCase("!deop")) {

            HuskyIRC.bot.sendRawLineNow("/msg ChanServ AOP " + event.getChannel() + " REMOVE " + line[1]);

        } else if (line[0].equalsIgnoreCase("!voice")) {

            HuskyIRC.bot.sendRawLineNow("/msg ChanServ VOP " + event.getChannel() + " ADD " + line[1]);

        } else if (line[0].equalsIgnoreCase("!devoice")) {

            HuskyIRC.bot.sendRawLineNow("/msg ChanServ VOP " + event.getChannel() + " REMOVE " + line[1]);

        }

    }

}

package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Punishment extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!ban") && Utility.isAdminV2(event.getUser().getNick())) {

            HuskyIRC.bot.ban(event.getChannel(), line[1]);
            HuskyIRC.bot.kick(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));
            event.respond("Banned " + line[1]);

        } else if (line[0].equalsIgnoreCase("!mute") && Utility.isAdminV2(event.getUser().getNick())) {

            HuskyIRC.bot.setMode(event.getChannel(), "+q", Utility.getUser(line[1], event.getChannel().getName()));
            event.respond("Muted " + line[1]);

        } else if (line[0].equalsIgnoreCase("!unban") && Utility.isAdminV2(event.getUser().getNick())) {

            HuskyIRC.bot.unBan(event.getChannel(), line[1]);
            event.respond("Unbanned " + line[1]);

        } else if (line[0].equalsIgnoreCase("!unmute") && Utility.isAdminV2(event.getUser().getNick())) {

            HuskyIRC.bot.setMode(event.getChannel(), "-q", Utility.getUser(line[1], event.getChannel().getName()));
            event.respond("Unmuted " + line[1]);

        } else if (line[0].equalsIgnoreCase("!kick") && Utility.isAdminV2(event.getUser().getNick())) {

            HuskyIRC.bot.kick(event.getChannel(), Utility.getUser(line[1], event.getChannel().getName()));
            event.respond("Kicked " + line[1]);

        }

    }

}

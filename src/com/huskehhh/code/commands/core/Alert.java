package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import org.pircbotx.Channel;
import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Iterator;
import java.util.Set;

public class Alert extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!alert")) {

            if (Utility.isAdminV2(event.getUser().getNick())) {

                String text = event.getMessage().replace(line[0], "");

                Set<Channel> channels = event.getBot().getChannels();
                Iterator<Channel> iterator = channels.iterator();

                while (iterator.hasNext()) {
                    HuskyIRC.bot.sendMessage(iterator.next().getName(), Colors.RED + Colors.BOLD + "[Alert]" + Colors.NORMAL + text);
                }
            }
        }
    }
}

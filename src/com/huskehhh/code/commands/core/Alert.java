package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Alert extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!alert")) {

            if (Utility.isAdminV2(event.getUser().getNick()) && AuthCheck.authCheck(event.getUser().getNick())) {

                String build = "";
                for (int i = 1; i < line.length; i++) {
                    build = build + line[i];
                }
                String[] channels = Config.channels;

                for (int x = 0; x < channels.length; x++) {
                    HuskyIRC.bot.getChannel(channels[x]).sendMessage(Colors.RED + Colors.BOLD + "[Alert] " + Colors.REVERSE + build);
                }
            }
        }
    }

}

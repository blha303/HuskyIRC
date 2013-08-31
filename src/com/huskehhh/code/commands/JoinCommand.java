package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.*;

import com.huskehhh.code.HuskyIRC;

@SuppressWarnings("rawtypes")
public class JoinCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length > 1) {

            if (event.getMessage().equals("!join")) {

                event.respond("Please specify a channel to join.");
            }

            String channelarg = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("!join ") && event.getMessage().contains(channelarg)) {

                String admin = "Huskehhh";

                if (admin.contains(event.getUser().getNick())) {
                    HuskyIRC.bot.sendRawLineNow("join" + " " + channelarg);

                    event.respond("Attempted to join channel " + channelarg);

                }
            }
        }

    }
}

package com.huskehhh.code.commands.core;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Iterator;
import java.util.Set;

public class Channels extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        if (event.getMessage().equalsIgnoreCase("!channels") && event.getMessage().split(" ")[1].equals("scruff")) {
            String s = "";
            for (int i = 0; i < event.getBot().getChannels().toArray().length; i++) {
                if (i == event.getBot().getChannels().toArray().length -1) {
                    s = s.replaceFirst(", ", "") + " and " + event.getBot().getChannels().toArray()[i];
                } else {
                    s += ", " + event.getBot().getChannels().toArray()[i];
                }
            }
            event.respond("Channels: " + s);
        } else if (event.getMessage().equalsIgnoreCase("!channels")) {

            Set<Channel> channels = event.getBot().getChannels();
            Iterator<Channel> iterator = channels.iterator();
            String ret = "";

            while (iterator.hasNext()) {
                ret = ret + iterator.next().getName() + ", ";
            }

            event.respond("Channels: " + ret);

        }

    }

}

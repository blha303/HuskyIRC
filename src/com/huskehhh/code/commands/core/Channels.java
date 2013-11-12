package com.huskehhh.code.commands.core;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Iterator;
import java.util.Set;

public class Channels extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        if (event.getMessage().equalsIgnoreCase("!channels")) {

            Set<Channel> channels = event.getBot().getChannels();
            Iterator<Channel> iterator = channels.iterator();
            String ret = "";

            while (iterator.hasNext()) {
                ret = ret + iterator.next() + ", ";
            }

            event.respond("Channels: " + ret);

        }

    }

}

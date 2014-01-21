package com.huskehhh.code.commands.oresomecraft;


import com.huskehhh.code.tasks.TwitterCheck;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Twitter extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!twitter")) {
            new TwitterCheck();
        }

    }


}

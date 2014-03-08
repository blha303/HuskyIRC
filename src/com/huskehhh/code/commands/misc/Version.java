package com.huskehhh.code.commands.misc;

import com.huskehhh.code.tasks.UpdateCheck;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Version extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!version")) {

            try {

                event.respond("Local version: " + Utility.getVersion());
                event.respond("External version: " + Utility.newVersion());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new UpdateCheck();

        }

    }

}

package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.auth.AuthCheck;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Game extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!game")) {

            if(line[1] == null) event.respond("No server specified!");

            if (AuthCheck.authCheck(event.getUser().getNick())) {

                if (event.getChannel().getName().equalsIgnoreCase("#oresomecraft-admin")) {

                    String command = "";
                    for (int i = 2; i < line.length; i++) {
                        command = command + line[i] + " ";
                    }

                    /**
                     * SSH?
                     */

                }

            }

        }

    }


}

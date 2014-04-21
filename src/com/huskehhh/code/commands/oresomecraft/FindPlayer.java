package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class FindPlayer extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!findplayer")) {

            if (line.length > 1) {
                String player = line[1];
                String result = Utility.findPlayer(player);
                if (!result.contains("isn't")) {
                    event.respond("'" + player + "', is on '" + result + "'.");
                }
            }
        }
    }

}

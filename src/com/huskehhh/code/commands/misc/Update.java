package com.huskehhh.code.commands.misc;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.IOException;

public class Update extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!update")) {

            if (event.getUser().getNick().equals("Husk") && AuthCheck.authCheck(event.getUser().getNick())) {

                if (Utility.isUpdate()) {

                    try {

                        event.respond("Updating!");
                        Runtime.getRuntime().exec("./update.sh");

                        HuskyIRC.bot.disconnect();
                        HuskyIRC.bot.shutdown();
                        System.exit(0);

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                } else {
                    event.respond("No update available!");
                }

            } else {
                event.respond("Sorry, you don't have the correct permission to use this feature!");
            }

        }

    }

}

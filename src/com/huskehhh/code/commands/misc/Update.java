package com.huskehhh.code.commands.misc;

import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.IOException;

public class Update extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!update")) {

            if (line.length == 1) {

                if ((event.getUser().getNick().equals("Husk") || event.getUser().getNick().equals("Scruffeh"))&& event.getUser().isVerified()) {

                    if (Utility.isUpdate()) {

                        try {

                            event.respond("Updating!");
                            Runtime.getRuntime().exec("./oldupdate.sh");

                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }

                    } else {
                        event.respond("No update available!");
                    }

                } else {
                    event.respond("Sorry, you don't have the correct permission to use this feature!");
                }

            } else {

                if (line[1].equalsIgnoreCase("repo")) {

                    if (event.getUser().getNick().equals("Husk") && event.getUser().isVerified()) {

                        event.respond("Updating local map repo!");

                        try {
                            Runtime.getRuntime().exec("./updateMapREPO.sh");
                            event.respond("Updated!");
                        } catch (IOException exception) {
                            exception.printStackTrace();
                            event.respond("Error updating! Check console!");
                        }

                    }

                }

            }

        }

    }

}

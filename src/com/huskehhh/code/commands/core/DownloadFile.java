package com.huskehhh.code.commands.core;

import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class DownloadFile extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!dl")) {

            if (line.length > 2) {

                if (Utility.isAdmin(event.getUser().getNick())) {

                    event.respond("Downloading " + line[1] + "!");

                    long startTime = System.currentTimeMillis();

                    Utility.downloadFile(line[1], line[2]);

                    long endTime = System.currentTimeMillis();

                    event.respond("Download finished!");
                    event.respond("Saved as: " + line[2] + ", Downloaded in " + (endTime - startTime) + "ms");
                } else {

                    event.respond("Sorry but you can't use this!");
                }

            } else {

                event.respond("Usage: !dl <url> <filename>.<ext>");
            }
        }
    }
}

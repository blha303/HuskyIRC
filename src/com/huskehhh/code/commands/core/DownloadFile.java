package com.huskehhh.code.commands.core;

import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class DownloadFile extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!dl")) {

            if (line.length > 2) {

                if (Utility.isAdminV2(event.getUser().getNick()) && event.getUser().isVerified()) {

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


/**
 Maybe we could make My VPS a file hosting/sharing website, instead of having stuff all over the place, like imgur, youtube, mediafire-
 this way we can also keep records aswell as it being super-useful. :)
**/
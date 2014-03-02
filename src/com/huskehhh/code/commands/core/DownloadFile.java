package com.huskehhh.code.commands.core;

import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class DownloadFile extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line.length > 2) {
            if (Utility.isAdmin(event.getUser().getNick())) {

                event.respond("Downloading " + line[1] + "!");
                long startTime = System.currentTimeMillis();
                Utility.downloadFile(line[1], line[2]);
                long endTime = System.currentTimeMillis();
                event.respond("Download finished!");
                event.respond("Downloaded in " + (startTime - endTime) + "ms");
            } else {
                event.respond("Sorry you can't use this!");
            }
        } else {
            event.respond("Syntax: !dl <url> <filename>.<ext>");
        }
    }

}

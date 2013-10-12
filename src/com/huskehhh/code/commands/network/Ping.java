package com.huskehhh.code.commands.network;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] lines = event.getMessage().split(" ");

        if (lines.length >= 1) {
            if (lines[0].equalsIgnoreCase("!ping")) {
                if (lines.length > 1) {
                    event.respond("Testing ping...");
                    try {
                        Process ping = Runtime.getRuntime().exec("ping -c 3 " + lines[1]);
                        BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            event.respond(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    event.respond("Usage: !ping <ip>");
                }
            }
        }
    }

}

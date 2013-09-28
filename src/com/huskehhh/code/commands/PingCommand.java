package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length >= 1) {
            String[] lines = event.getMessage().split(" ");
            if (lines[0].equalsIgnoreCase("!ping")) {
                if (lines.length > 1) {
                    event.respond("Testing ping...");
                    try {
                        Process ping = Runtime.getRuntime().exec("ping -c 5 " + lines[1]);
                        BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                            sb.append("\n");
                        }
                        event.respond(sb.toString());
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

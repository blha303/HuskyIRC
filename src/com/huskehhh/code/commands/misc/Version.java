package com.huskehhh.code.commands.misc;

import com.huskehhh.code.tasks.UpdateCheck;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Version extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!version")) {

            try {

                URL url = new URL("https://raw.github.com/Huskehhh/HuskyIRC/master/VERSION");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                event.respond("Version: " + in.readLine());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new UpdateCheck();

        }

    }

}

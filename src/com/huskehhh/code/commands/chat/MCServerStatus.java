package com.huskehhh.code.commands.chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class MCServerStatus extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!mcstatus")) {

            String site = "";
            String login = "";
            String session = "";
            try {
                JsonParser parser = new JsonParser();
                InputStream input = new URL("http://status.mojang.com/check").openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String status = reader.readLine();

                JsonArray json = parser.parse(status).getAsJsonArray();
                for (Object obj : json) {

                    Map.Entry<String, JsonElement> entry  = parser.parse(obj.toString()).getAsJsonObject().entrySet().iterator().next();

                    if (entry.getKey().equals("minecraft.net")) {
                        if (entry.getValue().getAsString().equals("red")) {
                            site = "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            site = "slow";
                        } else {
                            site = "up";
                        }
                    } else if (entry.getKey().equals("login.minecraft.net")) {
                        if (entry.getValue().getAsString().equals("red")) {
                            login = "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            login = "slow";
                        } else {
                            login = "up";
                        }
                    } else if (entry.getKey().equals("session.minecraft.net")) {
                        if (entry.getValue().getAsString().equals("red")) {
                            session = "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            session = "slow";
                        } else {
                            session = "up";
                        }
                    }

                }
                event.respond("Minecraft Site: " + site + ", Login Server: " + login + ", Session Server: " + session);
            } catch (Exception e) {

                event.respond("Could not reach the Minecraft Servers.");
                e.printStackTrace();

            }

        }

    }

}

package com.huskehhh.code.commands.chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.pircbotx.Colors;
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
                            site = Colors.RED + Colors.BOLD + "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            site = Colors.BOLD + Colors.YELLOW + "slow";
                        } else {
                            site = Colors.BOLD + Colors.GREEN + "up";
                        }
                    } else if (entry.getKey().equals("login.minecraft.net")) {
                        if (entry.getValue().getAsString().equals("red")) {
                            login = Colors.BOLD + Colors.RED + "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            login = Colors.BOLD + Colors.YELLOW + "slow";
                        } else {
                            login = Colors.BOLD + Colors.GREEN + "up";
                        }
                    } else if (entry.getKey().equals("session.minecraft.net")) {
                        if (entry.getValue().getAsString().equals("red")) {
                            session = Colors.BOLD + Colors.RED + "down";
                        } else if (entry.getValue().getAsString().equals("yellow")) {
                            session = Colors.BOLD + Colors.YELLOW + "slow";
                        } else {
                            session = Colors.BOLD + Colors.GREEN + "up";
                        }
                    }

                }
                event.respond("Minecraft Site: " + site + Colors.removeFormattingAndColors(", Login Server: ") + login + Colors.removeFormattingAndColors(", Session Server: ") + session);
            } catch (Exception e) {

                event.respond(Colors.RED + "Could not reach the Minecraft Servers.");
                e.printStackTrace();

            }

        }

    }

}

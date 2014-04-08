package com.huskehhh.code.tasks;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.BanAppealUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TimerTask;

public class MinecraftServerStatusCheckTask extends TimerTask {

    String channel = "#OresomeCraft-Admin";

    @Override
    public void run() {

        try {
            JsonParser parser = new JsonParser();
            InputStream input = new URL("http://status.mojang.com/check").openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String status = reader.readLine();

            JsonArray json = parser.parse(status).getAsJsonArray();
            for (Object obj : json) {

                Map.Entry<String, JsonElement> entry  = parser.parse(obj.toString()).getAsJsonObject().entrySet().iterator().next();

                if (entry.getKey().equals("login.minecraft.net")) {
                    if (entry.getValue().getAsString().equals("red")) {
//                        System.out.println("Login servers are down!");
                        HuskyIRC.bot.sendMessage("Scruff", "Login servers are down!");
                        HuskyIRC.bot.sendMessage("#OresomeCraft", "Login servers are down!");
                    } else if (entry.getValue().getAsString().equals("yellow")) {
//                        System.out.println("Login servers are slow!");
                        HuskyIRC.bot.sendMessage("Scruff", "Login servers are slow!");
                        HuskyIRC.bot.sendMessage("#OresomeCraft", "Login servers are slow!");
                    }
                }
                if (entry.getKey().equals("session.minecraft.net")) {
                    if (entry.getValue().getAsString().equals("red")) {
//                        System.out.println("Session servers are down!");
                        HuskyIRC.bot.sendMessage("Scruff", "Session servers are down!");
                        HuskyIRC.bot.sendMessage("#OresomeCraft", "Session servers are down!");
                    } else if (entry.getValue().getAsString().equals("yellow")) {
//                        System.out.println("Session servers are slow!");
                        HuskyIRC.bot.sendMessage("Scruff", "Session servers are slow!");
                        HuskyIRC.bot.sendMessage("#OresomeCraft", "Session servers are slow!");
                    }
                }
            }
        } catch (Exception exce) {
            exce.printStackTrace();
        }
        new BanAppealCheck();
    }
}

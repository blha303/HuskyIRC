package com.huskehhh.code.commands.oresomecraft;

import ch.jamiete.mcping.MinecraftPing;
import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.IOException;

public class GlobalCount extends ListenerAdapter {

    MinecraftPing ping = new MinecraftPing();
    int totalPlayers;

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!globalcount") || line[0].equalsIgnoreCase("!gcount")) {
            String channel = event.getChannel().getName();
            event.getBot().sendMessage(channel, "--== OresomeCraft Global Player Count ==--");
            csip(channel, "Hub", Config.mainIP, Config.hubPort);
            csip(channel, "SMP", Config.mainIP, Config.smpPort);
            csip(channel, "Battles", Config.mainIP, Config.battlesPort);
            csip(channel, "Arcade", Config.mainIP, Config.arcadePort);
            csip(channel, "Kart", Config.mainIP, Config.kartPort);
            csip(channel, "TiOT", Config.mainIP, Config.tiotPort);
            csip(channel, "Development", Config.mainIP, Config.developmentPort);

            event.getBot().sendMessage(channel, "--== Total Player Count: " + totalPlayers + " ==--");
        }
    }

    public void csip(String channel, String server, String ip, int port) {
        try {
            int players = ping.getPing(ip, port).getOnlinePlayers();
            HuskyIRC.bot.sendMessage(channel, server + ": " + players);
            totalPlayers += players;
        } catch (IOException e) {
            HuskyIRC.bot.sendMessage(channel, server + ": Error: An IOException occurred while trying to fetch player counts!");
            e.printStackTrace();
        }
    }
}

package com.huskehhh.code.commands.oresomecraft;

import ch.jamiete.mcping.MinecraftPing;
import ch.jamiete.mcping.MinecraftPingReply;
import com.huskehhh.code.config.Config;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.IOException;

public class GlobalCount extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!globalcount") || line[0].equalsIgnoreCase("!gcount")) {
            MinecraftPing ping = new MinecraftPing();
            event.respond("--== OresomeCraft Global Player Count ==--");
            try {
                MinecraftPingReply arcadePing = ping.getPing(Config.arcadeIP);
                MinecraftPingReply battlesPing = ping.getPing(Config.battlesIP);
                MinecraftPingReply developmentPing = ping.getPing(Config.developmentIP);
                MinecraftPingReply hubPing = ping.getPing(Config.hubIP);
                MinecraftPingReply kartPing = ping.getPing(Config.kartIP);
                MinecraftPingReply smpPing = ping.getPing(Config.smpIP);
                MinecraftPingReply tiotPing = ping.getPing(Config.tiotIP);

                event.respond("Arcade: " + arcadePing.getOnlinePlayers());
                event.respond("Battles: " + battlesPing.getOnlinePlayers());
                event.respond("Development: " + developmentPing.getOnlinePlayers());
                event.respond("Hub: " + hubPing.getOnlinePlayers());
                event.respond("Kart: " + kartPing.getOnlinePlayers());
                event.respond("SMP: " + smpPing.getOnlinePlayers());
                event.respond("TiOT: " + tiotPing.getOnlinePlayers());

                int totalCount = (arcadePing.getOnlinePlayers() + battlesPing.getOnlinePlayers() + developmentPing.getOnlinePlayers() + hubPing.getOnlinePlayers() + kartPing.getOnlinePlayers() + smpPing.getOnlinePlayers() + tiotPing.getOnlinePlayers());
                event.respond("-== Total Player Count: " + totalCount + " ==--");
            } catch (IOException ex) {
                event.respond("Error: An IOException occured while trying to fetch player counts!");
                ex.printStackTrace();
            }
        }
    }
}

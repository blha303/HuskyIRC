package com.huskehhh.code.commands.oresomecraft;

import ch.jamiete.mcping.MinecraftPing;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class GlobalCount extends ListenerAdapter {

    MinecraftPing ping = new MinecraftPing();
    int totalPlayers;

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!globalcount") || line[0].equalsIgnoreCase("!gcount")) {
            int hub = Utility.getPlayersOnline("hub");
            int smp = Utility.getPlayersOnline("smp");
            int battle = Utility.getPlayersOnline("battle");
            int arcade = Utility.getPlayersOnline("arcade");
            int kart = Utility.getPlayersOnline("oresomekart");
            int tiot = Utility.getPlayersOnline("tiot");
            int dev = Utility.getPlayersOnline("dev");
            String channel = event.getChannel().getName();
            event.getBot().sendMessage(channel, "--== OresomeCraft Global Player Count ==--");
            event.respond("Hub: " + hub);
            event.respond("SMP: " + smp);
            event.respond("Battles: " + battle);
            event.respond("Arcade: " + arcade);
            event.respond("Kart: " + kart);
            event.respond("TiOT: " + tiot);
            event.respond("Development: " + dev);

            event.getBot().sendMessage(channel, "--== Total Player Count: " + (hub + smp + battle + arcade + kart + tiot + dev) + " ==--");
        }
    }

}

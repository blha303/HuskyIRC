package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GlobalCount extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!globalcount") || line[0].equalsIgnoreCase("!gcount")) {
            int hub = getPlayersOnline("hub");
            int smp = getPlayersOnline("smp");
            int battle = getPlayersOnline("battle");
            int arcade = getPlayersOnline("arcade");
            int kart = getPlayersOnline("oresomekart");
            int tiot = getPlayersOnline("tiot");
            int dev = getPlayersOnline("dev");

            String channel = event.getChannel().getName();
            event.getBot().sendMessage(channel, "--== OresomeCraft Global Player Count ==--");
            if (hub != 0) {event.getBot().sendMessage(channel, "Hub: " + hub);}
            if (smp != 0) {event.getBot().sendMessage(channel, "SMP: " + smp);}
            if (battle != 0) {event.getBot().sendMessage(channel, "Battles: " + battle);}
            if (arcade != 0) {event.getBot().sendMessage(channel, "Arcade: " + arcade);}
            if (kart != 0) {event.getBot().sendMessage(channel, "Kart: " + kart);}
            if (tiot != 0) {event.getBot().sendMessage(channel, "TiOT: " + tiot);}
            if (dev != 0) {event.getBot().sendMessage(channel, "Development: " + dev);}

            event.getBot().sendMessage(channel, "--== Total Player Count: " + (hub + smp + battle + arcade + kart + tiot + dev) + " ==--");
        }
    }

    private int getPlayersOnline(String server) {
        String query = "SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
        ResultSet rs = mysql.querySQL(query);
        try {
            if (rs.next()) {
                return rs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

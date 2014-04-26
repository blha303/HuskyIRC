package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
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

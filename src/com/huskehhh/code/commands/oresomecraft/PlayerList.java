package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerList extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!players")) {
            System.out.println("DEBUG: LINE LENGTH = " + line.length);
            if (line.length == 1) {
                parseResultSet("all");
                System.out.println("DEBUG: parsing 'all'");
            } else if (line.length == 2) {
                parseResultSet(line[1]);
                System.out.println("DEBUG: parsing '" + line[1] + "'";
            }
        }
    }


    /**
     * 'players' format,
     * SMP: player, player | Battles: player, player | Arcade: player, player | TiOT: player, player | Hub: player, player
     */

    public String parseResultSet(String server) {
        if (server.equalsIgnoreCase("smp") || server.equalsIgnoreCase("battle") || server.equalsIgnoreCase("arcade") || server.equalsIgnoreCase("tiot") || server.equalsIgnoreCase("hub") || server.equalsIgnoreCase("dev")) {
            String players = "";
            String query = "SELECT * FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
            String count = "SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
            ResultSet rs = mysql.querySQL(query);
            ResultSet rsc = mysql.querySQL(count);

            int rows = 0;

            try {
                if (rsc.next() && rs.next()) {
                    rows = rsc.getInt("COUNT(*)");
                    for (int i = 1; i < rows; i++) {
                        rs.absolute(i);
                        players += rs.getString("user") + ", ";
                    }
                } else {
                    return "No players online!";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return players;
        } else {
            String smp = parseResultSet("smp");
            String battle = parseResultSet("battle");
            String arcade = parseResultSet("arcade");
            String hub = parseResultSet("hub");
            String dev = parseResultSet("dev");
            String tiot = parseResultSet("tiot");

            return "Players online: | SMP: " + smp + "| Battle: " + battle + "| Arcade: " + arcade + "| Hub: " + hub + "| Dev: " + dev + " | TiOT: " + tiot + "|";
        }
    }
}

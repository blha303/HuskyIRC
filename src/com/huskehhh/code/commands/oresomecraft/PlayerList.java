package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerList extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!players")) {
            if (line.length == 1) {
                if (event.getChannel().getName().equals("#oresomecraft")) {
                    event.respond(getAllPlayersOnline());
                }
            } else {
                String players = "";
                String server = line[1];
                if (server.equalsIgnoreCase("smp") || server.equalsIgnoreCase("battle") || server.equalsIgnoreCase("arcade") || server.equalsIgnoreCase("tiot") || server.equalsIgnoreCase("hub") || server.equalsIgnoreCase("dev")) {
                    String query = "SELECT * FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
                    String count = "SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
                    ResultSet rs = mysql.querySQL(query);
                    ResultSet rsc = mysql.querySQL(count);

                    int rows = 0;

                    try {
                        if (rsc.next()) {
                            rows = rsc.getInt("COUNT(*)");
                            for (int i = 1; i < rows; i++) {
                                System.out.println("i=" + i + " and rows=" + rows);
                                rs.absolute(i);
                                players += rs.getString("user") + ", ";
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    event.respond(players.substring(0, players.length()-2));
                }
            }
        }
    }


    /**
     * 'players' format,
     * SMP: player, player | Battles: player, player | Arcade: player, player | TiOT: player, player | Hub: player, player
     */
    public String getAllPlayersOnline() {
        String players = "";
        String[] servers = {"SMP", "Battle", "Arcade", "Hub", "TiOT"};

        for (int i = 0; i < servers.length; i++) {
            ResultSet rs = mysql.querySQL("SELECT * FROM `online_users`.`players` WHERE server LIKE '" + servers[i] + "';");
            ResultSet count = mysql.querySQL("SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + servers[i] + "';");
            int rows = 0;
            try {
                if (count.next()) {
                    rows = count.getInt("COUNT(*)");
                    players += " | " + servers[i] + ": ";
                    for (int x = 1; x < rows; x++) {
                        rs.absolute(x);
                        players += rs.getString(x) + ", ";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return players;
    }
}

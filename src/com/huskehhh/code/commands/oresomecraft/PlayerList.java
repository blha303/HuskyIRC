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
                            rs.next();
                            rows = rsc.getInt("COUNT(*)");
                            for (int i = 1; i < rows; i++) {
                                players += rs.getString(i) + ", ";
                                event.respond("Debug: " + rs.getString(i));
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    event.respond(players);
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

        for (int i = 1; i < servers.length; i++) {
            ResultSet rs = mysql.querySQL("SELECT * FROM `online_users`.`players` WHERE server LIKE '" + servers[i] + "';");
            ResultSet count = mysql.querySQL("SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + servers[i] + "';");
            int rows = 0;
            try {
                if (count.next()) {
                    rs.next();
                    rows = count.getInt("COUNT(*)");
                    for (int x = 1; x < rows; x++) {
                        players += " | " + servers[i] + ": " + rs.getString(x) + ", ";
                        HuskyIRC.bot.getChannel("#oresomecraft").sendMessage("Debug: " + servers[i] + " : " + rs.getString(x));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return players;
    }
}

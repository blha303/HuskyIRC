package com.huskehhh.code.commands.oresomecraft;

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
                if (event.getChannel().equals("#oresomecraft")) {
                    return getAllPlayersOnline();
                }
            }
            String players = "";
            String server = line[1];
            if (server.equalsIgnoreCase("smp") || server.equalsIgnoreCase("battle") || server.equalsIgnoreCase("arcade") || server.equalsIgnoreCase("tiot") || server.equalsIgnoreCase("hub") || server.equalsIgnoreCase("hub")) {
                String query = "SELECT * FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
                String count = "SELECT COUNT(*) FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
                ResultSet rs = mysql.querySQL(query);
                ResultSet rsc = mysql.querySQL(count);

                int rows = 0;

                try {
                    if (rsc.next()) {
                        rows = rsc.getInt("COUNT(*)");
                    }
                    for (int i = 0; i < rows; i++) {
                        players += rs.getString(i);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                event.respond(players);
            }
        }
    }

    public String getAllPlayersOnline() {
        String players = "";
        String[] servers = {"smp", "battles", "arcade"};

        ResultSet smprs = mysql.querySQL(smp);
        ResultSet smpcount = mysql.querySQL();
        return players;
    }
}

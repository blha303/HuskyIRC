package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPlayer extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!findplayer")) {

            String player = line[1];
            String result = findPlayer(player);
            if (!result.contains("isn't")) {
                event.respond(player + ", is on " + result + ".");
            }
        }
    }

    private String findPlayer(String player) {
        String query = "SELECT server FROM `online_users`.`players` WHERE user LIKE '" + player + "';";
        ResultSet rs = mysql.querySQL(query);
        try {
            if (rs.next()) {
                return rs.getString("server");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "'" + player + "' isn't online!";
    }

}

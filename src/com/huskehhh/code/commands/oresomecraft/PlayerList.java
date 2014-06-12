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
            if (line.length == 1) {return;}
            String players = "";
            String server = line[1];
            String query = "SELECT * FROM `online_users`.`players` WHERE server LIKE '" + server + "';";
            ResultSet rs = mysql.querySQL(query);
            try {
                while (rs.next()) {
                    while (rs.getString("user") != null) {
                        players += rs.getString("user") + ", ";
	                    event.respond(rs.getString("user"));
	                    rs.next();
                    }
//                    rs.next();
                }
                event.respond(players.substring(0, players.length()-2));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

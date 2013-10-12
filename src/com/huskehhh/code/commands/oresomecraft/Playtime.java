package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class Playtime extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!playtime")) {

            if (line.length > 1) {

                String player = line[1];
                String query = "SELECT onlinetime FROM `Logblock_SMP`.`lb-players` WHERE `playername`='" + player + "';";
                ResultSet rs = null;

                try {

                    rs = mysql.querySQL(query);

                    if (rs != null) {
                        rs.next();
                        int playtime = Integer.parseInt(rs.getString("onlinetime"));
                        playtime = playtime / 60;
                        event.respond(player + " has played for " + (playtime / 60) + " hours! (SMP)");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

            } else {
                event.respond("Usage: !playtime <player>");
            }

        }

    }

}
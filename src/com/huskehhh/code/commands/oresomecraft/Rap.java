package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rap extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) throws Exception {
        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!rap")) {

            if (line.length > 2) {
                String player = line[1];
                String server = line[2];

                String smp = "SELECT * FROM `mb_ban_records_smp` WHERE `banned` LIKE '" + player + "';";
                String battles = "SELECT * FROM `mb_ban_records_battles` WHERE `banned` LIKE '" + player + "';";
                String tiot = "SELECT * FROM `mb_ban_records_tiot` WHERE `banned` LIKE '" + player + "';";
                String onslaught = "SELECT * FROM `mb_ban_records_onslaught` WHERE `banned` LIKE '" + player + "';";

                ResultSet rs = null;

                if (server.equalsIgnoreCase("smp")) {
                    rs = mysql.querySQL(smp);
                } else if (server.equalsIgnoreCase("battles")) {
                    rs = mysql.querySQL(battles);
                } else if (server.equalsIgnoreCase("tiot")) {
                    rs = mysql.querySQL(tiot);
                } else if (server.equalsIgnoreCase("onslaught")) {
                    rs = mysql.querySQL(onslaught);
                }

                if (rs != null) {

                    try {

                        event.respond(player + " has been banned previously from " + server + " for:");

                        while (rs.next()) {
                            if (rs.getString("ban_reason") != null) {
                                event.respond(rs.getString("ban_reason") + " (" + rs.getString("banned_by") + ").");
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    event.respond("More information over at: " + Utility.returnWebURL(player, server));

                }

            } else {
                event.respond("Usage: !rap <player> <smp|battles|tiot|onslaught>");
            }

        }

    }

}

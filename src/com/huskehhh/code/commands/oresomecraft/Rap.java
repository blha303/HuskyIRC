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

                String ban_smp = "SELECT * FROM `mb_ban_records_smp` WHERE `banned` LIKE '" + player + "';";
                String ban_battles = "SELECT * FROM `mb_ban_records_battles` WHERE `banned` LIKE '" + player + "';";
//                String ban_tiot = "SELECT * FROM `mb_ban_records_tiot` WHERE `banned` LIKE '" + player + "';";
                String ban_onslaught = "SELECT * FROM `mb_ban_records_onslaught` WHERE `banned` LIKE '" + player + "';";

                String mute_smp = "SELECT * FROM `mb_mutes_records_smp` WHERE `muted` LIKE '" + player + "';";
                String mute_battles = "SELECT * FROM `mb_mutes_records_battles` WHERE `muted` LIKE '" + player + "';";
//                String mute_tiot = "SELECT * FROM `mb_mutes_records_tiot` WHERE `muted` LIKE '" + player + "';";
                String mute_onslaught = "SELECT * FROM `mb_mutes_records_onslaught` WHERE `muted` LIKE '" + player + "';";

                ResultSet rsb = null;
                ResultSet rsm = null;

                if (server.equalsIgnoreCase("smp")) {
                    rsb = mysql.querySQL(ban_smp);
                    rsm = mysql.querySQL(mute_smp);
                } else if (server.equalsIgnoreCase("battles")) {
                    rsb = mysql.querySQL(ban_battles);
                    rsm = mysql.querySQL(mute_battles);
/*                } else if (server.equalsIgnoreCase("tiot")) {
                    rsb = mysql.querySQL(ban_tiot);
                    rsm = mysql.querySQL(mute_tiot);
*/
                } else if (server.equalsIgnoreCase("onslaught")) {
                    rsb = mysql.querySQL(ban_onslaught);
                    rsm = mysql.querySQL(mute_onslaught);
                }

                if (rsb != null) {

                    try {

                        event.respond(player + " has been banned previously from " + server + " for:");

                        while (rsb.next()) {
                            if (rsb.getString("ban_reason") != null) {
                                event.respond(rsb.getString("ban_reason") + " (" + rsb.getString("banned_by") + ")");
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

                if (rsm != null) {

                    try {

                        event.respond(player + " has been muted previously from " + server + " for:");

                        while (rsm.next()) {
                            if (rsm.getString("mute_reason") != null) {
                                event.respond(rsm.getString("mute_reason") + " (" + rsm.getString("muted_by") + ")");
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                event.respond("More information over at: " + Utility.returnWebURL(player, server));

            } else {
                event.respond("Usage: !rap <player> <smp|battles|onslaught>");
//                event.respond("Usage: !rap <player> <smp|battles|tiot|onslaught>");
            }

        }

    }

}

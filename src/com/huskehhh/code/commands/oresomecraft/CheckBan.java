package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.Utility;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.Colors;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class CheckBan extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!checkban")) {

            if (line.length > 2) {

                String player = line[1];
                String server = line[2];

                if (server.equalsIgnoreCase("smp")) {
                    event.respond(parseResultSet(player, "SMP", mysql.querySQL("SELECT * FROM `mb_bans_smp` WHERE `banned` LIKE '" + player + "'")));
                } else if (server.equalsIgnoreCase("battles")) {
                    event.respond(parseResultSet(player, "Battle", mysql.querySQL("SELECT * FROM `mb_bans_battles` WHERE `banned` LIKE '" + player + "';")));
                } else if (server.equalsIgnoreCase("onslaught")) {
                    event.respond(parseResultSet(player, "Onslaught", mysql.querySQL("SELECT * FROM `mb_bans_onslaught` WHERE `banned` LIKE '" + player + "';")));
                } else if (server.equalsIgnoreCase("tiot")) { // I don't think this even works.
                    event.respond(parseResultSet(player, "TiOT", mysql.querySQL("SELECT * FROM `mb_bans_tiot` WHERE `banned` LIKE '" + player + "';")));
                } else if (server.equalsIgnoreCase("all")) {
                    event.respond(parseResultSet(player, "SMP", mysql.querySQL("SELECT * FROM `mb_bans_smp` WHERE `banned` LIKE '" + player + "'")));
                    event.respond(parseResultSet(player, "Battle", mysql.querySQL("SELECT * FROM `mb_bans_battles` WHERE `banned` LIKE '" + player + "';")));
                    event.respond(parseResultSet(player, "TiOT", mysql.querySQL("SELECT * FROM `mb_bans_tiot` WHERE `banned` LIKE '" + player + "';")));
                    event.respond(parseResultSet(player, "Onslaught", mysql.querySQL("SELECT * FROM `mb_bans_onslaught` WHERE `banned` LIKE '" + player + "';")));
                }

                event.respond("More information over at: " + Utility.returnWebURL(player, server));

            } else {

                event.respond("Usage: !checkban <player> <smp|battles|tiot|onslaught|all>");

            }

        }

    }

    private String parseResultSet(String player, String server, ResultSet parse) {
        try {

            if (parse != null) {

                parse.next();

                if (parse.getString("banned") == null) {
                    return player + " is " + Colors.GREEN + "not banned" + Colors.removeFormattingAndColors(" from " + server);
                } else {
                    return player + " is " + Colors.RED + "banned" + Colors.removeFormattingAndColors(" from " + server + ", banned by " + parse.getString("banned_by") + " for the reason of '" + parse.getString("ban_reason") + "'.");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return player + " is " + Colors.GREEN + "not banned" + Colors.removeFormattingAndColors(" from " + server);
    }

}

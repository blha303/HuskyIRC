package com.huskehhh.code.commands;

import code.husky.mysql.MySQL;
import com.huskehhh.code.Config;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class CheckBanCommand extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (event.getMessage().startsWith("!checkban ")) {
            if (line.length > 2) {
                String player = line[1];
                String server = line[2];
                if (server.equalsIgnoreCase("battles")) {
                    event.respond(battleBan(player));
                } else if (server.equalsIgnoreCase("smp")) {
                    event.respond(smpBan(player));
                } else if (server.equalsIgnoreCase("onslaught")) {
                    event.respond(onslaughtBan(player));
                } else if (server.equalsIgnoreCase("all")) {
                    event.respond(battleBan(player));
                    event.respond(smpBan(player));
                    event.respond(onslaughtBan(player));
                }
            } else {
                event.respond("Usage: !checkban <player> <smp|onslaught|battles|all>");
            }
        }
    }

    private String onslaughtBan(String player) {
        ResultSet rs = null;
        String query = "SELECT * FROM `mb_bans_onslaught` WHERE `banned`='" + player + "';";
        try {
            rs = mysql.querySQL(query);
            if (rs != null) {
                rs.next();
                if (rs.getString("banned") == null) {
                    return player + " is not banned from Onslaught.";
                } else {
                    return player + " is banned from Onslaught, banned by " + rs.getString("banned_by") + " for the reason of '" + rs.getString("ban_reason") + "'.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return player + " is not banned from Onslaught.";
    }

    private String smpBan(String player) {
        ResultSet rs = null;
        String query = "SELECT * FROM `mb_bans_smp` WHERE `banned`='" + player + "';";
        try {
            rs = mysql.querySQL(query);
            if (rs != null) {
                rs.next();
                if (rs.getString("banned") == null) {
                    return player + " is not banned from SMP.";
                } else {
                    return player + " is banned from SMP, banned by " + rs.getString("banned_by") + " for the reason of '" + rs.getString("ban_reason") + "'.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return player + " is not banned from SMP.";
    }

    private String battleBan(String player) {
        ResultSet rs = null;

        String query = "SELECT * FROM `mb_bans_battles` WHERE `banned`='" + player + "';";
        try {
            rs = mysql.querySQL(query);
            if (rs != null) {
                rs.next();
                if (rs.getString("banned") == null) {
                    return player + " is not banned from Battles.";
                } else {
                    return player + " is banned from Battles, banned by " + rs.getString("banned_by") + " for the reason of '" + rs.getString("ban_reason") + "'.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return player + " is not banned from Battles.";
    }

}

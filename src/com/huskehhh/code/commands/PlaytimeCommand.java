package com.huskehhh.code.commands;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import code.husky.mysql.MySQL;

import com.huskehhh.code.Config;

@SuppressWarnings("rawtypes")
public class PlaytimeCommand extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");
        String player = line[1];

        if (event.getMessage().contains("!playtime ")) {
            String query = "SELECT * FROM `Logblock_SMP`.`lb-players` WHERE `playername`='" + player + "';";
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
        }

    }
}
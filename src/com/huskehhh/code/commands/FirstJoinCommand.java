package com.huskehhh.code.commands;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import code.husky.mysql.MySQL;

import com.huskehhh.code.Config;

@SuppressWarnings("rawtypes")
public class FirstJoinCommand extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");
        String player = line[1];

        if (event.getMessage().contains("!firstjoin ")) {
            String query = "SELECT firstjoin FROM `Logblock_SMP`.`lb-players` WHERE `playername`='" + player + "';";
            ResultSet rs = null;
            try {
                rs = mysql.querySQL(query);
                if (rs != null) {
                    rs.next();

                    event.respond(player + " first joined " + rs + " (SMP)");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    }
}
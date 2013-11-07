package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class FirstJoin extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!firstjoin")) {
            if (line.length > 1) {
                String query = "SELECT firstlogin FROM `Logblock_SMP`.`lb-players` WHERE `playername`='" + line[1] + "';";
                ResultSet rs = null;
                try {
                    rs = mysql.querySQL(query);
                    if (rs != null) {
                        rs.next();
                        event.respond(line[1] + " first joined " + rs.getString("firstlogin") + " (SMP)");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            } else {
                event.respond("Usage: !firstjoin <player>"); //TODO: Add Battles support;
            }
        }
    }
}
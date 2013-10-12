package com.huskehhh.code.commands.oresomecraft;

import com.huskehhh.code.auth.AuthCheck;
import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.sql.ResultSet;

public class Query extends ListenerAdapter {

    MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    public void onMessage(MessageEvent event) throws Exception {

        if (AuthCheck.authCheck(event.getUser().getNick())) {

            String[] line = event.getMessage().split(" ");

            if (line[0].equalsIgnoreCase("!query")) {
                if (line.length > 3) {

                    String[] admin = Config.admins;

                    for (int i = 0; i <= admin.length; i++) {

                        if (admin[i] == null) return;

                        if (admin[i].replaceAll(" ", "").equals(event.getUser().getNick())) {

                            String s = "";
                            for (int x = 1; x < line.length; x++) {
                                s = s + line[x] + " ";
                            }

                            if (!s.startsWith("SELECT")) return;

                            ResultSet rs = mysql.querySQL(s);

                            if (rs != null) {

                                while (rs.next()) {
                                    if (rs.getString(line[2].replaceAll("`", "")) != null)
                                        event.respond("Result: " + rs.getString(line[2].replaceAll("`", "")));
                                }

                            }

                        }

                    }

                } else {
                    event.respond("Usage: !query <sql query syntax>");
                }

            }

        }

    }

}

package com.huskehhh.code.commands;

import java.net.URL;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class StatsCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        String[] args = event.getMessage().split(" ");

        if (event.getMessage().startsWith("!stats ")) {
            if(args.length <= 2) {
                String p = args[1];
                String url = "http://oresomecraft.com/battleapi.php?name=" + p;
                URL http = new URL(url);
                Object o = http.openConnection().getContent();
                String json = o.toString();
                String[] it = json.split(",");
                String kills = it[2];
                String deaths = it[3];
                String gamesplayed = it[6];
                event.respond(p + " Stats: Kills = " + kills + ", Deaths = " + deaths + ", Amount of Games played = " + gamesplayed);
            }
        }

    }

}

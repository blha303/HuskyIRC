package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.huskehhh.code.Config;
import com.huskehhh.code.HuskyIRC;

@SuppressWarnings("rawtypes")
public class PartCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length > 1) {

            String channel = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("!part ") && event.getMessage().contains(channel)) {
                
                String[] admin = Config.admins;

                for(int i = 0; i<=admin.length; i++) {
                    
                    if(admin[i] == null) return;
                    
                    if (admin[i].replaceAll(" ", "").equals(event.getUser().getNick())) {
                        HuskyIRC.bot.sendRawLineNow("part" + " " + channel);
                        event.respond("Ciao! " + channel);
                    } else {
                        event.respond("What you doing here boy, ain't no work for you.");
                    }
                    
                }

            }

        }
    }
}

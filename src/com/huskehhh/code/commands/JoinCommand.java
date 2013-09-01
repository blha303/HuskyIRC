package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.*;

import com.huskehhh.code.Config;
import com.huskehhh.code.HuskyIRC;

@SuppressWarnings("rawtypes")
public class JoinCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length > 1) {

            if (event.getMessage().equals("!join")) {

                event.respond("Please specify a channel to join.");
            }

            String channelarg = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("!join ") && event.getMessage().contains(channelarg)) {
                
                String[] admin = Config.admins;
                
                for(int i = 0; i<=admin.length; i++) {
                    
                    if(admin[i] == null) return;
                    
                    if (admin[i].replaceAll(" ", "").equals(event.getUser().getNick())) {
                        HuskyIRC.bot.sendRawLineNow("join" + " " + channelarg);
                        event.respond("Attempted to join channel " + channelarg);
                    } else {
                        event.respond("What you doing here boy, ain't no work for you.");
                    }
                    
                }
            }
        }
    }
}

package com.huskehhh.code.commands.core;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.tasks.UpdateCheck;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class Part extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {

        if (event.getMessage().split(" ").length > 1) {

            String channel = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("!part ") && event.getMessage().contains(channel)) {

                if (event.getUser().isVerified()) {

                    String[] admin = Config.admins;

                    for (int i = 0; i <= admin.length - 1; i++) {

                        if (admin[i] == null) return;

                        if (admin[i].replaceAll(" ", "").equals(event.getUser().getNick())) {
                            event.respond("Ciao! " + channel);
                            HuskyIRC.bot.sendRawLineNow("part " + channel);
                        }

                    }

                    new UpdateCheck();

                } else {
                    event.respond("Sorry, you don't have the correct permission to use this feature!");
                }

            }

        }

    }

}

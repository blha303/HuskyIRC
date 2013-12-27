package com.huskehhh.code.commands.chat;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Help extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String line = event.getMessage();

        if (line.equals("!help")) {

            event.respond("Check your private messages for help!");
            event.getBot().sendMessage(event.getUser().getNick(), "=============== HuskBot Help ===============");
            event.getBot().sendMessage(event.getUser().getNick(), "!c <query> -- Gives <query> a cookie!");
            event.getBot().sendMessage(event.getUser().getNick(), "!pizza <query> -- Gives <query> a pizza!");
            event.getBot().sendMessage(event.getUser().getNick(), "!slap <query> -- Slaps <query>!");
            event.getBot().sendMessage(event.getUser().getNick(), "!slay <query> -- Slays <query>!");
            event.getBot().sendMessage(event.getUser().getNick(), "!eat <query> -- Eats <query>!");
            event.getBot().sendMessage(event.getUser().getNick(), "!hf <query> -- Hi-fives <query>!");
            event.getBot().sendMessage(event.getUser().getNick(), "\\o -- Responds with o/");
            event.getBot().sendMessage(event.getUser().getNick(), "o/ -- Responds with \\o");
            event.getBot().sendMessage(event.getUser().getNick(), "!roll <number> -- Picks a random number between 0 and <number>.");
            event.getBot().sendMessage(event.getUser().getNick(), "!gc -- Responds with information about how much memory its using.");
            event.getBot().sendMessage(event.getUser().getNick(), "!channels -- Responds with a list of all the connected channels.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!join <channel> -- Attempts to join <channel>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!part <channel> -- Leaves <channel>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!op <user> -- Attempts to op <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!deop <user> -- Attempts to deop <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!voice <user> -- Attempts to voice <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!devoice <user> -- Attempts to devoice <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!ban <user> -- Attempts to ban <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!unban <user> -- Attempts to unban <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!mute <user> -- Attempts to mute <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "*!unmute <user> -- Attempts to umute <user>.");
            event.getBot().sendMessage(event.getUser().getNick(), "**!update [repo] -- Attempts to update the bot. (Never works! :P)");
            event.getBot().sendMessage(event.getUser().getNick(), "!version -- Responds bot and online versions.");
            event.getBot().sendMessage(event.getUser().getNick(), "!check <ip> -- Responds with host name of <ip>.");
            event.getBot().sendMessage(event.getUser().getNick(), "!ping <ip> -- Responds with the results of the ping.");
            event.getBot().sendMessage(event.getUser().getNick(), "");
            event.getBot().sendMessage(event.getUser().getNick(), "* - Bot admins only.");
            event.getBot().sendMessage(event.getUser().getNick(), "** - Husk only.");
        }
    }
    public void onMessage(MessageEvent event) {
        
        event.respond("Sorry, but commands don't work here!")
    }
}

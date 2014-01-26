package com.huskehhh.code.commands.chat;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Help extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!help") && line[1].equalsIgnoreCase("admin")) {
            event.respond("Check your private messages for admin help!");
            getAdminHelp(event.getUser().getNick());
        } else if (line[0].equalsIgnoreCase("!help")) {
            event.respond("Check your private messages for help!");
            getHelp(event.getUser().getNick());
        }
    }
    public void onPrivateMessage(PrivateMessageEvent event) {
        if (line[0].equalsIgnoreCase("!help") && line[1].equalsIgnoreCase("admin")) {
            event.respond("Check your private messages for admin help!");
            getAdminHelp(event.getUser().getNick());
        } else if (line[0].equalsIgnoreCase("!help")) {
            event.respond("Check your private messages for help!");
            getHelp(event.getUser().getNick());
        }
    }

    public void getHelp(String user) {
        event.getBot().sendMessage(user, "================== HuskBot Help ==================");
        event.getBot().sendMessage(user, "!c <query> -- Gives <query> a cookie!");
        event.getBot().sendMessage(user, "!pizza <query> -- Gives <query> a pizza!");
        event.getBot().sendMessage(user, "!slap <query> -- Slaps <query>!");
        event.getBot().sendMessage(user, "!slay <query> -- Slays <query>!");
        event.getBot().sendMessage(user, "!eat <query> -- Eats <query>!");
        event.getBot().sendMessage(user, "!hf <query> -- Hi-fives <query>!");
        event.getBot().sendMessage(user, "\\o -- Responds with o/");
        event.getBot().sendMessage(user, "o/ -- Responds with \\o");
        event.getBot().sendMessage(user, "!roll <number> -- Picks a random number between 0 and <number>.");
        event.getBot().sendMessage(user, "!gc -- Responds with information about how much memory its using.");
        event.getBot().sendMessage(user, "!channels -- Responds with a list of all the connected channels.");
        event.getBot().sendMessage(user, "!version -- Responds bot and online versions.");
        event.getBot().sendMessage(user, "!check <ip> -- Responds with host name of <ip>.");
        event.getBot().sendMessage(user, "!ping <ip> -- Responds with the results of the ping.");
    }

    public void getAdminHelp(String user) {
        event.getBot().sendMessage(user, "=============== HuskBot Admin Help ===============");
        event.getBot().sendMessage(user, "*!join <channel> -- Attempts to join <channel>.");
        event.getBot().sendMessage(user, "*!part <channel> -- Leaves <channel>.");
        event.getBot().sendMessage(user, "*!op <user> -- Attempts to op <user>.");
        event.getBot().sendMessage(user, "*!deop <user> -- Attempts to deop <user>.");
        event.getBot().sendMessage(user, "*!voice <user> -- Attempts to voice <user>.");
        event.getBot().sendMessage(user, "*!devoice <user> -- Attempts to devoice <user>.");
        event.getBot().sendMessage(user, "*!ban <user> -- Attempts to ban <user>.");
        event.getBot().sendMessage(user, "*!unban <user> -- Attempts to unban <user>.");
        event.getBot().sendMessage(user, "*!mute <user> -- Attempts to mute <user>.");
        event.getBot().sendMessage(user, "*!unmute <user> -- Attempts to umute <user>.");
        event.getBot().sendMessage(user, "**!update [repo] -- Attempts to update the bot. (Never works! :P)");
    }
}

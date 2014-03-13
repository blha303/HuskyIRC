package com.huskehhh.code.commands.chat;

import com.huskehhh.code.HuskyIRC;
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
        String[] line = event.getMessage().split(" ");
        if (line[0].equalsIgnoreCase("!help") && line[1].equalsIgnoreCase("admin")) {
            event.respond("Check your private messages for admin help!");
            getAdminHelp(event.getUser().getNick());
        } else if (line[0].equalsIgnoreCase("!help")) {
            event.respond("Check your private messages for help!");
            getHelp(event.getUser().getNick());
        } else {
            HuskyIRC.bot.sendMessage("Scruffeh", event.getUser().getNick() + ": " + event.getMessage());
        }
    }

    public void getHelp(String user) {
        HuskyIRC.bot.sendMessage(user, "================== HuskBot Help ==================");
        HuskyIRC.bot.sendMessage(user, "!c <query> -- Gives <query> a cookie!");
        HuskyIRC.bot.sendMessage(user, "!pizza <query> -- Gives <query> a pizza!");
        HuskyIRC.bot.sendMessage(user, "!slap <query> -- Slaps <query>!");
        HuskyIRC.bot.sendMessage(user, "!slay <query> -- Slays <query>!");
        HuskyIRC.bot.sendMessage(user, "!eat <query> -- Eats <query>!");
        HuskyIRC.bot.sendMessage(user, "!hf <query> -- Hi-fives <query>!");
        HuskyIRC.bot.sendMessage(user, "\\o -- Responds with o/");
        HuskyIRC.bot.sendMessage(user, "o/ -- Responds with \\o");
        HuskyIRC.bot.sendMessage(user, "!roll <number> -- Picks a random number between 0 and <number>.");
        HuskyIRC.bot.sendMessage(user, "!gc -- Responds with information about how much memory it's using.");
        HuskyIRC.bot.sendMessage(user, "!channels -- Responds with a list of all the connected channels.");
        HuskyIRC.bot.sendMessage(user, "!version -- Responds bot and online versions.");
        HuskyIRC.bot.sendMessage(user, "!check <ip> -- Responds with host name of <ip>.");
        HuskyIRC.bot.sendMessage(user, "!ping <ip> -- Responds with the results of the ping.");
        HuskyIRC.bot.sendMessage(user, "!stats <BattlePlayer> -- Responds with the statistics of 'BattlePlayer'");
        HuskyIRC.bot.sendMessage(user, "!remind <Number>[s|m|h] <User|Channel> <Message> -- Set a reminder to be sent after 'o' so many minutes");
        HuskyIRC.bot.sendMessage(user, "Do !help admin for admin help.");
    }

    public void getAdminHelp(String user) {
        HuskyIRC.bot.sendMessage(user, "=============== HuskBot Admin Help ===============");
        HuskyIRC.bot.sendMessage(user, "*!join <channel> -- Attempts to join <channel>.");
        HuskyIRC.bot.sendMessage(user, "*!part <channel> -- Leaves <channel>.");
        HuskyIRC.bot.sendMessage(user, "*!op <user> -- Attempts to op <user>.");
        HuskyIRC.bot.sendMessage(user, "*!deop <user> -- Attempts to deop <user>.");
        HuskyIRC.bot.sendMessage(user, "*!voice <user> -- Attempts to voice <user>.");
        HuskyIRC.bot.sendMessage(user, "*!devoice <user> -- Attempts to devoice <user>.");
        HuskyIRC.bot.sendMessage(user, "*!ban <user> -- Attempts to ban <user>.");
        HuskyIRC.bot.sendMessage(user, "*!unban <user> -- Attempts to unban <user>.");
        HuskyIRC.bot.sendMessage(user, "*!mute <user> -- Attempts to mute <user>.");
        HuskyIRC.bot.sendMessage(user, "*!unmute <user> -- Attempts to umute <user>.");
        HuskyIRC.bot.sendMessage(user, "**!update [repo] -- Attempts to update the bot. (Never works! :P)");
    }
}

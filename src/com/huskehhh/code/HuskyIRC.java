package com.huskehhh.code;

import com.huskehhh.code.commands.chat.ChatManagement;
import com.huskehhh.code.commands.core.*;
import com.huskehhh.code.commands.misc.Update;
import com.huskehhh.code.commands.misc.Version;
import com.huskehhh.code.commands.network.Check;
import com.huskehhh.code.commands.network.Ping;
import com.huskehhh.code.commands.oresomecraft.*;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.tasks.UpdateCheck;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

public class HuskyIRC {

    public static PircBotX bot = new PircBotX();

    public static void main(String[] args) {

        load();

    }

    private static void load() {

        try {
            Config.loadConfiguration();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            bot.setAutoNickChange(true);
            bot.setVersion("HuskyIRC Bot - Kudos to Zachoz for some code. :)");
            bot.setLogin(Config.ircuser);
            bot.setName(Config.ircuser);
            bot.identify(Config.nickPass);
            bot.setVerbose(true);
            bot.connect(Config.network, 6667);
            bot.setAutoReconnect(false);
            bot.setAutoReconnectChannels(true);

            new UpdateCheck();

        } catch (IrcException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        joinChannels();

        loadListeners();

    }

    private static void loadListeners() {
        bot.getListenerManager().addListener(new CheckBan());
        bot.getListenerManager().addListener(new Check());
        bot.getListenerManager().addListener(new Part());
        bot.getListenerManager().addListener(new Join());
        bot.getListenerManager().addListener(new ChatManagement());
        bot.getListenerManager().addListener(new Playtime());
        bot.getListenerManager().addListener(new Rap());
        bot.getListenerManager().addListener(new Query());
        bot.getListenerManager().addListener(new Ping());
        bot.getListenerManager().addListener(new FirstJoin());
        bot.getListenerManager().addListener(new Update());
        bot.getListenerManager().addListener(new Version());
        bot.getListenerManager().addListener(new Channels());
        bot.getListenerManager().addListener(new RotationGen());
        bot.getListenerManager().addListener(new Permissions());
        bot.getListenerManager().addListener(new Punishment());
        bot.getListenerManager().addListener(new BattleStats());
        bot.getListenerManager().addListener(new Help());
    }


    private static void joinChannels() {

        for (int i = 0; i < Config.channels.length; i++) {

            bot.joinChannel(Config.channels[i].replaceAll(" ", ""));

        }

    }

    public static void shutdown() {

        bot.disconnect();
        bot.shutdown();

    }

}

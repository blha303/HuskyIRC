package com.huskehhh.code.commands.chat;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Timer;

public class Reminder extends ListenerAdapter implements Runnable {

    @Override
    public void run() {

        String messagee = messageEdited;
        String whoo = who;
        int timee = time;
        System.out.println("Sleeping! " + timee/60000);
        try {
            Thread.sleep(timee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HuskyIRC.bot.sendMessage(whoo, messagee);
    }

    String message;
    static String messageEdited;
    static String who;
    static int time;

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!remind") && line.length > 1) {

            message = event.getMessage();
            String user = event.getUser().getNick();

            time = Integer.valueOf(line[1]) * 60000;
            who = line[2];
            messageEdited = message.replace("!remind ", "");
            messageEdited = messageEdited.replaceFirst(line[1], "");
            messageEdited = messageEdited.replace(" " + line[2] + " ", "");

            String s = "";
            if (time > 60000) s = "s";

            HuskyIRC.bot.sendMessage(event.getChannel().getName(), "After " + line[1] + " minute" + s + " your message will be sent to " + who);
            Thread t = new Thread(new Reminder(), String.valueOf(System.currentTimeMillis()));
            t.start();

        } else if (line[0].equalsIgnoreCase("!remind") && !(line.length > 1)) {

            event.respond("Syntax: !remind <minute(s)> <User|Channel> <Message>");
        }

    }
}

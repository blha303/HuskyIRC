package com.huskehhh.code.commands.chat;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Reminder extends ListenerAdapter implements Runnable {

    @Override
    public void run() {

        String messagee = messageEdited;
        String whoo = who;
        int timee = time;

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

        if (line[0].equalsIgnoreCase("!remind") && line.length > 2) {

            message = event.getMessage();
            String timeStripped = line[1].replace("s", "").replace("m", "").replace("h", "");
            time = Integer.valueOf(timeStripped);

            String s = "";
            if (time > 1) s = "s";

            String timeUnit;
            if (line[1].endsWith("s")) {
                time *= 1000;
                timeUnit = "second";
            } else if (line[1].endsWith("m")) {
                time *= 60000;
                timeUnit = "minute";
            } else if (line[1].endsWith("h")) {
                time *= 360000;
                timeUnit = "hour";
            } else {
                time *= 60000;
                timeUnit = "minute";
            }

            who = line[2];
            messageEdited = message.replace("!remind ", "");
            messageEdited = messageEdited.replaceFirst(line[1], "");
            messageEdited = messageEdited.replace(" " + line[2] + " ", "");

            HuskyIRC.bot.sendMessage(event.getChannel().getName(), "After " + timeStripped + " " + timeUnit + s +" your message will be sent to " + who);
            Thread t = new Thread(new Reminder(), String.valueOf(System.currentTimeMillis()));
            t.start();

        } else if (line[0].equalsIgnoreCase("!remind") && !(line.length > 1)) {

            event.respond("Usage: !remind <Number>[s|m|h] <User|Channel> <Message>");
        }

    }
}

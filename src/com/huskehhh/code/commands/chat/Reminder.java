package com.huskehhh.code.commands.chat;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.util.Utility;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Reminder extends ListenerAdapter implements Runnable {

    @Override
    public void run() {

        String messageThreaded = messageEdited;
        String whoThreaded = who;
        int timeThreaded = time;

        try {
            Thread.sleep(timeThreaded);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HuskyIRC.bot.sendMessage(whoThreaded, messageThreaded);
    }

    String message;
    static String messageEdited;
    static String who;
    static int time;

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!remind") && line.length > 3) {

            message = event.getMessage();
            String timeStripped = line[2].replace("s", "").replace("m", "").replace("h", "");
            if (timeStripped.equals("")) {
                time = 1;
                timeStripped = "1";
            } else {
                try {
                    time = Integer.valueOf(timeStripped);
                } catch (Exception e) {
                    event.respond("\"" + timeStripped + "\" is not a number!");
                    return;
                }
            }

            String s = "";
            if (time > 1) s = "s";

            String timeUnit;
            if (line[2].endsWith("s")) {
                time *= 1000;
                timeUnit = "second";
            } else if (line[2].endsWith("m")) {
                time *= 60000;
                timeUnit = "minute";
            } else if (line[2].endsWith("h")) {
                time *= 3600000;
                timeUnit = "hour";
            } else {
                time *= 60000;
                timeUnit = "minute";
            }

            who = line[1];

            messageEdited = message.replace("!remind ", "");
            messageEdited = messageEdited.replace(who, "");
            messageEdited = messageEdited.replace(" " + line[2] + " ", "");
            messageEdited += " [" + event.getUser().getNick() + "]";

            if (!(Utility.channelExists(who) || Utility.userExists(who))) {
                event.respond("Please check that \"" + who + "\" is a real channel or user unless this is intended.");
            }


            HuskyIRC.bot.sendMessage(event.getChannel().getName(), "After " + timeStripped + " " + timeUnit + s +" your message will be sent to " + who);
            Thread t = new Thread(new Reminder(), String.valueOf(System.currentTimeMillis()));
            t.start();

        } else if (line[0].equalsIgnoreCase("!remind") && !(line.length > 3)) {

            event.respond("Usage: !remind <User|Channel> <Number>[s|m|h] <Message>");
        }

    }
}

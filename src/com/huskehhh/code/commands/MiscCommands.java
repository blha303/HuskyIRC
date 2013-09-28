package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class MiscCommands extends ListenerAdapter {

    public void onMessage(MessageEvent event) {
        if (event.getMessage().length() >= 1) {
            String[] line = event.getMessage().split(" ");

            if (event.getMessage().startsWith("!c ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a cookie!");
                } else {
                    event.respond("You need to actually have a paramater after the command! >.<");
                }
            } else if (event.getMessage().startsWith("!pizza ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a pizza!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (event.getMessage().startsWith("!slap ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "slaps " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (event.getMessage().startsWith("!slay ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "slays " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (event.getMessage().startsWith("!eat ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "eats " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (event.getMessage().startsWith("!hf ")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a hi-five!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (event.getMessage().startsWith("\\o")) {
                event.respond("o/");
            } else if (event.getMessage().startsWith("o/")) {
                event.respond("\\o");
            } else if (event.getMessage().equalsIgnoreCase("HuskBot: Is Smithey someone's bitch?")) {
                event.respond("Once upon a there was a person named Smithey, He went around saying he would finish stuff, but in actual fact he didn't.");
                event.respond("One day the almighty Zachoz learned that incentives would make him become his bitch.");
                event.respond("And to this day he is still the bitch of the almighty Zachoz!");
                event.respond("The End!");
            } else if (event.getMessage().equalsIgnoreCase("HuskBot: Do you like OresomeBot?")) {
                event.respond("He's okay I guess...But it wouldn't bother me if it had a bug and was taken out of action.");
            } else if (event.getMessage().startsWith("!roll")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "*rolls*");
                    Random rand = new Random();
                    int num = rand.nextInt(Integer.parseInt(line[1]));
                    event.respond("You rolled a " + num + "!");
                } else {
                    event.respond("Usage: !roll <Highest Number>");
                }
            }
        }
    }

}

package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class MiscCommands extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (event.getMessage().startsWith("!c ")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a cookie!");
            } else {
                event.respond("You need to actually have a paramater after the command! >.<");
            }
        } else if (event.getMessage().startsWith("!pizza")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a pizza!");
            } else {
                event.respond("You need to actually have a parameter after the command! >.<");
            }
        } else if (event.getMessage().startsWith("!slap")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "slaps " + line[1] + "!");
            } else {
                event.respond("You need to actually have a parameter after the command! >.<");
            }
        } else if (event.getMessage().startsWith("!slay")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "slays " + line[1] + "!");
            } else {
                event.respond("You need to actually have a parameter after the command! >.<");
            }
        } else if (event.getMessage().startsWith("!eat")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "eats " + line[1] + "!");
            } else {
                event.respond("You need to actually have a parameter after the comand! >.<");
            }
        } else if (event.getMessage().startsWith("!hf")) {
            if (line[1] != null) {
                event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a hi-five!");
            } else {
                event.respond("You need to actually have a parameter after the command! >.<");
            }
        } else if (event.getMessage().startsWith("\\o")) {
            event.respond("o/");
        } else if (event.getMessage().startsWith("o/")) {
            event.respond("\\o");
        } else if (event.getMessage().equalsIgnoreCase("HuskBot: Is Smithey someones bitch?")) {
            event.respond("Once upon a there was a person named Smithey, He went around saying he would finish stuff, but in actual fact he didn't.");
            event.respond("One day the almighty Zachoz learned that incentives would make him become his bitch.");
            event.respond("And to this day he is still the bitch of the almighty Zachoz!");
            event.respond("The End!!");
        }
    }

}

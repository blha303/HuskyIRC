package com.huskehhh.code.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class MiscCommands extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

	String[] line = event.getMessage().split(" ");

	if (event.getMessage().startsWith("!c ")) {
	    if(line[1] != null) {
		event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a cookie!");
	    } else {
		event.respond("You need to actually have a paramater after the command! >.<");
	    }
	} else if(event.getMessage().startsWith("!pizza")) {
	    if(line[1] != null) {
		event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a pizza!");
	    } else {
		event.respond("You need to actually have a paramater after the command! >.<");
	    }
	} else if(event.getMessage().startsWith("!slap")) {
	    if(line[1] != null) {
		event.getBot().sendAction(event.getChannel(), "slaps " + line[1] + "!");
	    } else {
		event.respond("You need to actually have a paramater after the command! >.<");
	    }
	} else if(event.getMessage().startsWith("!slay")) {
	    if(line[1] != null) {
		event.getBot().sendAction(event.getChannel(), "slays " + line[1] + "!");
	    } else {
		event.respond("You need to actually have a paramater after the command! >.<");
	    }
	} else if(event.getMessage().startsWith("!hf")) {
	    if(line[1] != null) {
		event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a hi-five!");
	    } else {
		event.respond("You need to actually have a paramater after the command! >.<");
	    }
	} else if(event.getMessage().contains("\\o")) {
	    event.respond("o/");
	} else if(event.getMessage().contains("o/")) {
	    event.respond("\\o");
	}
    }

}

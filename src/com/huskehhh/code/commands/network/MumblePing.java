package com.huskehhh.code.commands.network;

import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.MumbleQuery;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class MumblePing extends ListenerAdapter {

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!mumbleping")) {
            MumbleQuery mumbleServer = new MumbleQuery(Config.mumbleserver, Config.mumbleport, Config.mumbleport, Config.mumbleusername, Config.mumblepassword);
            event.respond("Connecting to Mumble Server: " + mumbleServer.getIp() + ":" + mumbleServer.getPort() + "...");

            switch (mumbleServer.getStatus()) {
                case FULL:
                    event.respond("Could not connect to mumble server!");
                    event.respond("The mumble server was full!");
                    break;

                case INTERNAL_ERROR:
                    event.respond("An Internal Error has occured!");
                    event.respond("Please contact psgs or Husky!");
                    break;

                case HOST_NOT_FOUND:
                    event.respond("Could not connect to mumble server!");
                    event.respond("The host for the mumble server wasn't found!");
                    break;

                case CONNECTION_REFUSED:
                    event.respond("Could not connect to mumble server!");
                    event.respond("The connection was refused.");
                    break;

                case CONNECTION_TIMEOUT:
                    event.respond("Could not connect to the mumble server!");
                    event.respond("The connection timed out.");
                    break;

                default:
                    event.respond("Mumble Server: " + mumbleServer.getIp() + " has:");
                    event.respond(mumbleServer.getCurrentUsers() + "/" + mumbleServer.getMaxUsers() + " users online now!");
                    break;

            }

            event.respond("The response time was: " + mumbleServer.getResponseTime() + "ms");

        }
    }
}

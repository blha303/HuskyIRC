package com.huskehhh.code.commands.chat;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class ChatManagement extends ListenerAdapter {

    public void onMessage(MessageEvent event) {
        if (event.getMessage().length() >= 1) {
            String[] line = event.getMessage().split(" ");

            if (line[0].equalsIgnoreCase("!c")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a cookie!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].equalsIgnoreCase("!pizza")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a pizza!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].equalsIgnoreCase("!slap")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "slaps " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].equalsIgnoreCase("!slay")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "slays " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].equalsIgnoreCase("!eat")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "eats " + line[1] + "!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].equalsIgnoreCase("!hf")) {
                if (line.length > 1) {
                    event.getBot().sendAction(event.getChannel(), "gives " + line[1] + " a hi-five!");
                } else {
                    event.respond("You need to actually have a parameter after the command! >.<");
                }
            } else if (line[0].startsWith("\\o")) {
                event.respond("o/");
            } else if (line[0].startsWith("o/")) {
                event.respond("\\o");
            } else if (line[0].equalsIgnoreCase("HuskBot: Is Smithey someone's bitch?")) {
                event.respond("Once upon a there was a person named Smithey, He went around saying he would finish stuff, but in actual fact he didn't.");
                event.respond("One day the almighty Zachoz learned that incentives would make him become his bitch.");
                event.respond("And to this day he is still the bitch of the almighty Zachoz!");
                event.respond("The End!");
            } else if (line[0].equalsIgnoreCase("HuskBot: Do you like OresomeBot?")) {
                event.respond("He's okay I guess...But it wouldn't bother me if it had a bug and was taken out of action.");
            } else if (line[0].equalsIgnoreCase("!roll")) {
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

    public static void end() {
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("end")) {
            System.out.println("Bot shutting down! Cya!");
            HuskyIRC.bot.disconnect();
            HuskyIRC.bot.shutdown();
            System.exit(0);
        }
    }

}

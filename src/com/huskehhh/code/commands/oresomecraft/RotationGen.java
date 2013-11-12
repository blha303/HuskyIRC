package com.huskehhh.code.commands.oresomecraft;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class RotationGen extends ListenerAdapter {

    List maps = new ArrayList<String>();
    List rot = new ArrayList<String>();

    private String getValueFromList(int entry) {
        return maps.get(entry).toString();
    }

    private static int generateRandom(int max) {
        return new Random().nextInt(max);
    }

    public void onMessage(MessageEvent event) {

        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!rotation")) {

            File f = new File("/home/husky/huskbot/maps");
            String[] fa = f.list();

            for (int i = 0; i < fa.length; i++) {
                maps.add(fa[i].replaceAll(".java", ""));
            }

            while (rot.size() <= 18) {

                String m = getValueFromList(generateRandom(maps.size()));

                if (!rot.contains(m)) {

                    rot.add(m);

                }

            }

            ListIterator<String> read = rot.listIterator();

            while (read.hasNext()) {

                event.respond(read.next());

            }

        }

    }


}

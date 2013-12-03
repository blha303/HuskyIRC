package com.huskehhh.code.util;

import com.huskehhh.code.HuskyIRC;
import org.pircbotx.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class Utility {

    private static Utility util = new Utility();

    public static boolean isUpdate() {

        String u = "https://raw.github.com/Huskehhh/HuskyIRC/master/VERSION";

        try {

            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            BufferedReader fileVERSION = null;

            fileVERSION = new BufferedReader(new FileReader("VERSION"));

            if (!in.readLine().equals(fileVERSION.readLine())) {
                return true;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public static User getUser(String name, String channel) {

        Iterator<User> li = HuskyIRC.bot.getChannel(channel).getUsers().iterator();

        while (li.hasNext()) {
            User user = li.next();

            if (user.getNick().equals(name)) {
                return user;
            }

        }

        return null;
    }

    public static String getVersion() {

        BufferedReader fileVERSION = null;

        try {
            fileVERSION = new BufferedReader(new FileReader("VERSION"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            String v = fileVERSION.readLine();

            if (v != null) {
                return v;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String newVersion() {

        String u = "https://raw.github.com/Huskehhh/HuskyIRC/master/VERSION";

        try {

            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String v = in.readLine();

            if (v != null) {
                return v;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String returnWebURL(String player, String server) {

        String url = "http://mc.oresomecraft.com/bans/index.php";

        if (player != null) url = url + "?player=" + player;

        int id = 0;

        if (server.equalsIgnoreCase("battle")) {
            id = 1;
        } else if (server.equalsIgnoreCase("arcade")) {
            id = 1;
        } else if (server.equalsIgnoreCase("smp")) {
            id = 0;
        } else if (server.equalsIgnoreCase("onslaught")) {
            id = 2;
        }

        if (server != null) url = url + "&server=" + id;

        return url;
    }

}

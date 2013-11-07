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

            InputStream inputStream = util.getClass().getResourceAsStream("/VERSION");

            fileVERSION = new BufferedReader(new InputStreamReader(inputStream));

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

        InputStream in = util.getClass().getResourceAsStream("/VERSION");

        fileVERSION = new BufferedReader(new InputStreamReader(in));

        try {

            while (fileVERSION.readLine() != null) {
                return fileVERSION.readLine();
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

            while (in.readLine() != null) {
                return in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

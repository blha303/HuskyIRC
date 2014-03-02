package com.huskehhh.code.util;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import org.pircbotx.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

public class Utility {

    private static Utility util = new Utility();
    public static Properties lastFile;

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
        // I 80% sure this checks through all connect channels for name
        // HuskyIRC.bot.userExists(name)

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

        if (player != null) url = url + "?action=viewplayer&player=" + player;

        int id = 0;

        if (server.equalsIgnoreCase("battles")) {
            id = 1;
        } else if (server.equalsIgnoreCase("arcade")) {
            id = 1;
        } else if (server.equalsIgnoreCase("smp")) {
            id = 0;
        } else if (server.equalsIgnoreCase("onslaught")) {
            id = 2;
        } else {
            id = 3; // Just so it doesn't error
        }

        if (server != null) url = url + "&server=" + id;

        return url;
    }

    public static boolean isAdmin(String user) {

        String[] admin = Config.admins;

        for (int i = 0; i <= admin.length; i++) {

            if (admin[i] == null) return false;

            if (admin[i].replaceAll(" ", "").equals(user)) {
                return true;
            }

        }

        return false;
    }

    public static boolean isAdminV2(String username) {
        for (String i : Config.admins) {
            if (i.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void downloadFile(String url, String output) {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(url).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fout = new FileOutputStream(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte data[] = new byte[1024];
        int count;
        try {
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (in != null)
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (fout != null)
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void saveLastFile() {
        try {
            lastFile.store(new PrintWriter("Last.txt"), "Last Post/Title");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadLastFile() {

        lastFile = new Properties();
        try {
            lastFile.load(new FileInputStream("Last.txt"));
            System.out.println("File loaded");
        } catch (IOException e) {
            System.out.println("File not found!");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("Last.txt");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.close();
            saveLastFile();
//			e.printStackTrace();
        }
    }
}

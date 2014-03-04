package com.huskehhh.code.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class KDRUtil {
    private static String getKD(String username) {
        try {
            URL url = new URL("http://" + Config.battlesSiteURL + "/battleapi.php?name=" + username);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Open URL connection
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb1 = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) sb1.append(inputLine);

            JsonObject jsonStats = new JsonParser().parse(sb1.toString()).getAsJsonObject().getAsJsonObject("stats");
            String KD = (roundDouble(Double.parseDouble(jsonStats.get("kills").toString().replace('"', '/').replaceAll("/", ""))
                    / roundDouble(Double.parseDouble(jsonStats.get("deaths").toString().replace('"', '/').replaceAll("/", "")))) + "");

            return KD;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "0.000";
        }
    }

    private static double roundDouble(double d) {
        DecimalFormat format = new DecimalFormat("#.###");
        try {
            return Double.valueOf(format.format(d));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String getLastKD(String user) {
        if (Utility.lastFile.get(user + "KD") == null) {
            return "0.000";
        } else {
            return Utility.lastFile.get(user + "KD").toString();
        }
    }

    private static void setLastKD(String KD, String user) {
        Utility.lastFile.put(user + "KD", KD);
        Utility.saveLastFile();
    }

    public static void sendKD(String username, String ircUsername) {
        for (String userSplit : username.split(",")) {
            String KD = KDRUtil.getKD(userSplit);
            if (!KD.equals("0.000")) {
                for (String ircUser : ircUsername.split(",")) {
                    if (!KD.equals(getLastKD(userSplit)) && (HuskyIRC.bot.userExists(ircUser) || HuskyIRC.bot.channelExists(ircUser)))  {
                        if (getLastKD(userSplit).equals("0.000")) {
                            HuskyIRC.bot.sendMessage(ircUser, userSplit + " has a new K/D: " + KD + "!");
                        } else {
                            HuskyIRC.bot.sendMessage(ircUser, userSplit + " has a new K/D: " + KD + ", Previous: " + getLastKD(userSplit));
                        }
                        setLastKD(KD,userSplit);
                    }
                }
            }
        }
    }
}

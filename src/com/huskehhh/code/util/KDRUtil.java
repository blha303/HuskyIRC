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
            return "Error!";
        }
    }

    private static double roundDouble(double d) {
        DecimalFormat format = new DecimalFormat("#.##");
        try {
            return Double.valueOf(format.format(d));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String getLastKD(String user) {
        if (Utility.lastFile.get(user + "KD") == null) {
            return "0.00";
        } else {
            return Utility.lastFile.get(user + "KD").toString();
        }
    }

    private static void setLastKD(String KD, String user) {

        Utility.lastFile.put(user + "KD", KD);
        Utility.saveLastFile();
    }

    public static void sendKD(String username, String IRCUsername) {
        String KD = KDRUtil.getKD(username);
        if (!KD.equals(getLastKD(username))) {
            HuskyIRC.bot.sendMessage(IRCUsername,"You have a new KDR: " + KD + ", Previous: " + getLastKD(username));
            setLastKD(KD,username);
        }
    }
}

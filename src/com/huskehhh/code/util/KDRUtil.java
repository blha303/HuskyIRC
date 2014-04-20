package com.huskehhh.code.util;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import com.huskehhh.database.mysql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class KDRUtil {

    private static MySQL mysql = new MySQL(Config.Ohostname,
            Config.Oport, Config.Odatabase,
            Config.Ouser, Config.Opassword);

    private static String getKD(String username) {
        String query = "SELECT * FROM `battle`.`stats` WHERE user LIKE '" + username + "';";
        ResultSet rs = mysql.querySQL(query);
        try {
            if (rs.next()) {
                int kills = rs.getInt("kills");
                int deaths = rs.getInt("deaths");
                double kd = kills / deaths;
                return Double.toString(roundDouble(kd));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0.00";
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
                    if (!KD.equals(getLastKD(userSplit)) && (HuskyIRC.bot.userExists(ircUser) || HuskyIRC.bot.channelExists(ircUser))) {
                        if (getLastKD(userSplit).equals("0.000")) {
                            HuskyIRC.bot.sendMessage(ircUser, userSplit + " has a new K/D: " + KD + "!");
                        } else {
                            HuskyIRC.bot.sendMessage(ircUser, userSplit + " has a new K/D: " + KD + ", Previous: " + getLastKD(userSplit));
                        }
                    }
                }
            }
        }
    }

    public static void updateUserKD(String usernames) {
        for (String userSplit : usernames.split(",")) {
            String KD = KDRUtil.getKD(userSplit);
            if (!KD.equals("0.000")) {
                if (!KD.equals(getLastKD(userSplit))) {
                    setLastKD(KD, userSplit);
                }
            }
        }
    }
}

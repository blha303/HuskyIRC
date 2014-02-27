package com.huskehhh.code.util;

public class TwitterUtil {

    public static String getLastTweet() {
        if (Utility.lastFile.get("lastTweet") == null) {
            return "";
        } else {
            return Utility.lastFile.get("lastTweet").toString();
        }
    }

    public static void setLastTweet(String tweet) {

        Utility.lastFile.put("lastTweet", tweet);
        Utility.saveLastFile();
    }

}

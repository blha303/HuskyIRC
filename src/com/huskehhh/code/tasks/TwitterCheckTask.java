package com.huskehhh.code.tasks;

import com.huskehhh.code.HuskyIRC;
import com.huskehhh.code.config.Config;
import com.huskehhh.code.util.TwitterUtil;
import com.huskehhh.code.util.Utility;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.*;
import java.util.ListIterator;
import java.util.TimerTask;

public class TwitterCheckTask extends TimerTask {

    @Override
    public void run() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(Config.consumerKey)
                .setOAuthConsumerSecret(Config.consumerSecret)
                .setOAuthAccessToken(Config.oAuthToken)
                .setOAuthAccessTokenSecret(Config.oAuthTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        int tweetCount = 1;
        long userId = 763736701; //OresomeCraft Twitter User ID

        ResponseList tweet = null;

        try {
            tweet = twitter.getUserTimeline(userId, new Paging(1, tweetCount));
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        ListIterator li = tweet.listIterator();

        while (li.hasNext()) {
            String next = li.next().toString();
            if (!TwitterUtil.lastPost.equals(next)) {
                HuskyIRC.bot.sendMessage("#oresomecraft", Color.GREEN + "OresomeCraft Twitter: " + next);
                TwitterUtil.lastPost = li.next().toString();
            } else {
                Utility.getUser("Husk", "Debug: " + li.next().toString() + " || " + TwitterUtil.lastPost);
            }
        }
        new TwitterCheck();
    }

}

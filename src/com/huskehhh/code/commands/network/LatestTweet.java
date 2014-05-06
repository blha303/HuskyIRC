package com.huskehhh.code.commands.network;

import com.huskehhh.code.config.Config;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class LatestTweet extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        String[] line = event.getMessage().split(" ");

        if (line[0].equalsIgnoreCase("!lasttweet")) {
            if (line.length > 1) {
                ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
                configurationBuilder.setDebugEnabled(true)
                    .setOAuthConsumerKey(Config.consumerKey)
                    .setOAuthConsumerSecret(Config.consumerSecret)
                    .setOAuthAccessToken(Config.oAuthToken)
                    .setOAuthAccessTokenSecret(Config.oAuthTokenSecret);
                TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
                Twitter twitter = twitterFactory.getInstance();
                try {
                    ResponseList<Status> timeLine = twitter.getUserTimeline(line[1]);
                    event.respond(timeLine.get(0).getUser().getName() + ": " + timeLine.get(0).getText());
                } catch (TwitterException ex) {
                    event.respond(ex.getCause().toString());
                }
            } else {
                event.respond("Usage: !lasttweet <twitter username>");
            }
        }
    }
}

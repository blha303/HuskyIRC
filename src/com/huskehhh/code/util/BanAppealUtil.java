package com.huskehhh.code.util;

import de.nava.informa.core.ChannelIF;
import de.nava.informa.core.ItemIF;
import de.nava.informa.impl.basic.ChannelBuilder;
import de.nava.informa.parsers.FeedParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

public class BanAppealUtil {

    public static String lastTitle = "";
    
    public static ItemIF getItem() {
        
        URL url = null;
        try {
            
            url = new URL("https://oresomecraft.com/forums/forums/ban-appeals.8/index.rss");
        } catch (MalformedURLException e) {
            
            e.printStackTrace();
        }
    
        ChannelIF channel = null;
        try {
            
            channel = FeedParser.parse(new ChannelBuilder(), url);
        } catch (Exception e) {

            e.printStackTrace();
        }
    
        Collection items = channel.getItems();
        Iterator i=items.iterator();

        return (ItemIF)i.next();
    }

    public static String getDate() {
        return getItem().getDate().toString();
    }

    public static String getTitle() {
        return getItem().getTitle();
    }

    public static String getLink() {
        return getItem().getLink().toString();
    }

    public static String getCreator() {
        return getItem().getCreator();
    }
}

package com.huskehhh.code.util;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.huskehhh.code.config.Config;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class BanAppealUtil {

    public static Element getElement() {
        SAXBuilder builder = new SAXBuilder();

        try {

            URL url = new URL("http://" + Config.siteURL + "/forums/forums/ban-appeals.8/index.rss");
            List channel = builder.build(url).getRootElement().getChildren("channel");
            Element item = (Element) channel.get(0);
            Element node = (Element) item.getChildren("item").get(0);

            return node;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDate() {
        return getElement().getChildText("pubDate");
    }

    public static String getTitle() {
        return getElement().getChildText("title");
    }

    public static String getLink() {
        return getElement().getChildText("link");
    }

    public static String getAuthor() {
        return getElement().getChildText("author");
    }

    public static String getLastTitle() {
        if (Utility.lastFile.get("lastTitle") == null) {
            return "";
        } else {
            return Utility.lastFile.get("lastTitle").toString();
        }
    }

    public static void setLastTitle(String title) {

        Utility.lastFile.put("lastTitle", title);
        Utility.saveLastFile();
    }
}

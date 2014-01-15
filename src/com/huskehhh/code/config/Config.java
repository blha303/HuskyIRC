package com.huskehhh.code.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String Ohostname;
    public static String Oport;
    public static String Ouser;
    public static String Opassword;
    public static String Odatabase;

    public static String[] channels;
    public static String[] admins;
    public static String network;
    public static String nickPass;
    public static String ircuser;
    public static String version;
    public static String siteURL;

    public static String mumbleserver;
    public static int mumbleport;
    public static String mumbleusername;
    public static String mumblepassword;


    public static void loadConfiguration() throws FileNotFoundException, IOException {

        Properties config = new Properties();
        config.load(new FileInputStream("HuskyIRC.properties"));

        network = config.getProperty("irc-network");
        nickPass = config.getProperty("nickserv-pass");
        channels = config.getProperty("channels").split(",");
        ircuser = config.getProperty("ircuser");
        admins = config.getProperty("admin").split(",");
        version = config.getProperty("version");
        siteURL = config.getProperty("siteURL");

        Ohostname = config.getProperty("OMySQL-host");
        Oport = config.getProperty("OMySQL-port");
        Ouser = config.getProperty("OMySQL-user");
        Opassword = config.getProperty("OMySQL-password");
        Odatabase = config.getProperty("OMySQL-database");

        mumbleserver = config.getProperty("mumble-server");
        mumbleport = Integer.parseInt(config.getProperty("mumble-port"));
        mumbleusername = config.getProperty("mumble-username");
        mumblepassword = config.getProperty("mumble-password");


    }

}

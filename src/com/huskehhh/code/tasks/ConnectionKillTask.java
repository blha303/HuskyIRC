package com.huskehhh.code.tasks;

import com.huskehhh.database.mysql.MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.TimerTask;

public class ConnectionKillTask extends TimerTask {

    @Override
    public void run() {

        ListIterator<Connection> li = MySQL.getConnections().listIterator();

        while (li.hasNext()) {

            Connection c = li.next();

            if (c != null) {

                try {
                    MySQL.getConnections().remove(c);
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}

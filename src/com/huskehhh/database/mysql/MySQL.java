package com.huskehhh.database.mysql;

import com.huskehhh.database.Database;

import java.sql.*;

/**
 * Connects to and uses a MySQL database
 *
 * @author -_Husky_-
 * @author tips48
 */
public class MySQL extends Database {

    private final String user;
    private final String database;
    private final String password;
    private final String port;
    private final String hostname;

    private Connection connection;

    /**
     * Creates a new MySQL instance
     *
     * @param hostname Name of the host
     * @param port     Port number
     * @param database Database name
     * @param username Username
     * @param password Password
     */
    public MySQL(String hostname, String port, String database, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.user = username;
        this.password = password;
        this.connection = null;
    }

    @Override
    public Connection openConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database, this.user, this.password);

        } catch (SQLException e) {
            System.out.println("Could not connect to MySQL server! because: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
        }

        return connection;
    }

    @Override
    public boolean checkConnection() {
        return connection != null;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing the MySQL Connection!");
                e.printStackTrace();
            }
        }
    }

    public ResultSet querySQL(String query) {

        Statement s = null;

        try {

            Connection c = getConnection();

            if (c.isClosed()) {
                c = openConnection();
            }

            s = c.createStatement();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        ResultSet ret = null;

        try {
            ret = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public void updateSQL(String update) {

        try {

            Connection c = getConnection();

            if (c.isClosed()) {
                c = openConnection();
            }

            Statement s = null;

            s = c.createStatement();
            s.executeUpdate(update);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

}

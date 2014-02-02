package com.huskehhh.code.util;

import com.huskehhh.code.config.Config;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

/**
 * Some of this code was sourced from:
 * VoiceConnect | https://github.com/hintss/voiceconnect
 * By @hintss
 */
public class MumbleQuery {

    private String ip = Config.mumbleserver;
    private int clientport = Config.mumbleport;
    private String username = Config.mumbleusername;
    private String password = Config.mumblepassword;

    private ServerStatus status = ServerStatus.INTERNAL_ERROR;
    private int currentusers = 0;
    private int maxusers = 0;
    private Long reponseTime = 0L;

    public MumbleQuery(String ip, int clientport, int queryport, String username, String password) {
        this.ip = ip;
        this.clientport = clientport;
        this.username = username;
        this.password = password;

        DatagramSocket clientsocket = null;
        try {
            clientsocket = new DatagramSocket();
            clientsocket.setSoTimeout(5000);

            InetAddress ipaddress = null;

            ipaddress = InetAddress.getByName(ip);

            byte[] sendData = "\000\000\000\000\000\000\000\000\000\000\000\000".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipaddress, clientport);
            clientsocket.send(sendPacket);
            Long start = System.currentTimeMillis();

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientsocket.receive(receivePacket);
            Long end = System.currentTimeMillis();
            clientsocket.close();

            ByteArrayInputStream packets = new ByteArrayInputStream(receivePacket.getData());
            DataInputStream data = new DataInputStream(packets);

            data.readInt();
            data.readLong();

            this.currentusers = data.readInt();
            this.maxusers = data.readInt();

            this.status = ServerStatus.OK;
            reponseTime = end - start;
            if (this.currentusers == 0) {
                this.status = ServerStatus.EMPTY;
            }
            if (this.currentusers >= this.maxusers) {
                this.status = ServerStatus.FULL;
            }
        } catch (SocketTimeoutException ex) {
            this.status = ServerStatus.CONNECTION_TIMEOUT;
        } catch (UnknownHostException ex) {
            this.status = ServerStatus.HOST_NOT_FOUND;
        } catch (SocketException ex) {
            this.status = ServerStatus.INTERNAL_ERROR;
        } catch (IOException ex) {
            this.status = ServerStatus.CONNECTION_REFUSED;
        }
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return clientport;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public int getCurrentUsers() {
        return currentusers;
    }

    public int getMaxUsers() {
        return maxusers;
    }

    public Long getResponseTime() {
        return reponseTime;
    }

    public enum ServerStatus {
        OK,
        FULL,
        EMPTY,
        INTERNAL_ERROR,
        HOST_NOT_FOUND,
        CONNECTION_REFUSED,
        CONNECTION_TIMEOUT;
    }
}
package com.intellio.telemetry.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkUtils {

    public static String getMacAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            NetworkInterface networkInt = NetworkInterface.getByInetAddress(inetAddress);

            byte[] mac = networkInt.getHardwareAddress();

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                builder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return builder.toString();
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}

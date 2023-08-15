package org.java.example.networing;

import java.net.InetAddress;
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.buyyourprojects.com");
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("Host Name: " + address.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

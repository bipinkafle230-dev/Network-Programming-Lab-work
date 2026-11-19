import java.net.*;
import java.util.*;

class NetworkInterfaceDemo {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni =
                        interfaces.nextElement();

                System.out.println("Interface Name: "
                        + ni.getName());

                System.out.println("Display Name: "
                        + ni.getDisplayName());

                System.out.println("Index: "
                        + ni.getIndex());

                System.out.println("Is Up: "
                        + ni.isUp());

                System.out.println("Is Loopback: "
                        + ni.isLoopback());

                System.out.println("MAC Address: "
                        + Arrays.toString(
                                ni.getHardwareAddress()));

                System.out.println("IP Addresses:");

                Enumeration<InetAddress> addresses =
                        ni.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();

                    System.out.println(
                            ip.getHostAddress());
                }

                System.out.println("--------------------");
            }

            NetworkInterface local =
                    NetworkInterface.getByName("lo");

            System.out.println("Factory Method Result: "
                    + (local != null
                    ? local.getDisplayName()
                    : "Interface not found"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
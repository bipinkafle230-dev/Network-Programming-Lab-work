
import java.net.*;
import java.util.*;

class IPandMAC {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni =
                        interfaces.nextElement();

                byte[] mac = ni.getHardwareAddress();

                System.out.println("Interface: "
                        + ni.getDisplayName());

                if (mac != null) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X",
                                mac[i] & 0xff));

                        if (i < mac.length - 1) {
                            sb.append("-");
                        }
                    }

                    System.out.println("MAC Address: "
                            + sb);
                }

                Enumeration<InetAddress> addresses =
                        ni.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();

                    System.out.println("IP Address: "
                            + ip.getHostAddress());
                }

                System.out.println("--------------------");
            }

        } catch (SocketException e) {
            System.out.println(e);
        }
    }
}

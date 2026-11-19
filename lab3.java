import java.net.*;

class IPCharacteristics {
    public static void main(String[] args) {
        try {
            InetAddress ip =
                    InetAddress.getByName("127.0.0.1");

            System.out.println("IP Address: "
                    + ip.getHostAddress());

            System.out.println("Any Local Address: "
                    + ip.isAnyLocalAddress());

            System.out.println("Loopback Address: "
                    + ip.isLoopbackAddress());

            System.out.println("Link Local Address: "
                    + ip.isLinkLocalAddress());

            System.out.println("Site Local Address: "
                    + ip.isSiteLocalAddress());

            System.out.println("Multicast Address: "
                    + ip.isMulticastAddress());

        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
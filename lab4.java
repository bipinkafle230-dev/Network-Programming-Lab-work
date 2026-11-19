import java.net.*;

class CheckIPVersion {
    public static void main(String[] args) {
        try {
            InetAddress ip =
                    InetAddress.getByName("192.168.1.5");

            System.out.println("IP Address: "
                    + ip.getHostAddress());

            if (ip instanceof Inet4Address) {
                System.out.println("It is an IPv4 Address.");
            }
            else if (ip instanceof Inet6Address) {
                System.out.println("It is an IPv6 Address.");
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
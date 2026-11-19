import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class lab2 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();

            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("Canonical Host Name: " + ip.getCanonicalHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
            System.out.println("Address in Byte Form: " + Arrays.toString(ip.getAddress()));
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
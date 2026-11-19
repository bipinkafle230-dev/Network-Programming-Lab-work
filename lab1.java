import java.net.InetAddress;
import java.net.UnknownHostException;

public class lab1 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("System IP Address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
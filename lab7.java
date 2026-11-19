
import java.net.*;
import java.util.*;

class RetrieveIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("1. Search by Interface Name");
            System.out.println("2. Search by MAC Address");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            NetworkInterface ni = null;

            if (choice == 1) {
                System.out.print("Enter Interface Name: ");
                String name = sc.nextLine();

                ni = NetworkInterface.getByName(name);
            }
            else if (choice == 2) {
                System.out.print("Enter MAC Address: ");
                String macInput = sc.nextLine();

                String[] parts = macInput.split("[:-]");

                byte[] mac = new byte[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    mac[i] = (byte) Integer.parseInt(parts[i], 16);
                }

                Enumeration<NetworkInterface> interfaces =
                        NetworkInterface.getNetworkInterfaces();

                while (interfaces.hasMoreElements()) {
                    NetworkInterface temp =
                            interfaces.nextElement();

                    if (Arrays.equals(
                            mac, temp.getHardwareAddress())) {
                        ni = temp;
                        break;
                    }
                }
            }
            else {
                System.out.println("Invalid Choice!");
                sc.close();
                return;
            }

            if (ni != null) {
                System.out.println("Interface: "
                        + ni.getDisplayName());

                Enumeration<InetAddress> addresses =
                        ni.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();

                    System.out.println("IP Address: "
                            + ip.getHostAddress());
                }
            }
            else {
                System.out.println("Interface not found!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}

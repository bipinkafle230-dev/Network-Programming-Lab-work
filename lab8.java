import java.net.*;

class RetrieveMAC {
    public static void main(String[] args) {
        try {
            String address = "127.0.0.1";

            InetAddress ip = InetAddress.getByName(address);
            NetworkInterface ni = NetworkInterface.getByInetAddress(ip);

            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();

                if (mac != null) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i] & 0xff));

                        if (i < mac.length - 1) {
                            sb.append("-");
                        }
                    }

                    System.out.println("IP Address: " + address);
                    System.out.println("MAC Address: " + sb);
                } else {
                    System.out.println("MAC Address not available.");
                }
            } else {
                System.out.println("Network Interface not found.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

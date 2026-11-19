import java.net.*;
import java.io.*;

class RetrieveURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");

            System.out.println("URL: " + url);

            System.out.println("Protocol: "
                    + url.getProtocol());

            System.out.println("Host: "
                    + url.getHost());

            URLConnection connection =
                    url.openConnection();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));

            String line;

            System.out.println("\nWeb Page Content:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

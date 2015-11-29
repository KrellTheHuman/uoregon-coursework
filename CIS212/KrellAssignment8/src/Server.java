import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * CIS212 - Assignment 8
 * Created by krell on 2015-11-28.
 */

public class Server {

    private static int _port = 12335;
    private static ServerSocket _serverSocket;
    private static boolean _running = true;

    public static void main(String[] args) {

        System.out.println("starting server...");
        if (args.length > 0) {
            _port = Integer.parseInt(args[0]);
        }
        try {
            openServerSocket();
            while (_running) {
                awaitConnections();
            }
            System.out.println("received shutdown request from client. shutting down...");
            _serverSocket.close();
            System.out.println("goodbye.");
        } catch (Exception e) {
            System.out.println("server encountered an exception. exiting...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void openServerSocket() throws IOException {

        _serverSocket = new ServerSocket(_port);
    }

    private static void awaitConnections() throws IOException {

        try {
            System.out.println("\nwaiting for connection...");
            Socket socket = _serverSocket.accept();

            System.out.println("connection established. creating streams...");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println("streams created. receiving input from client...");
            String input = ois.readUTF();
            System.out.println("server received: " + input);
            System.out.println("processing input...");
            String output = getPrimes(input);

            System.out.println("processing complete. sending output to client...");
            oos.writeUTF(output);
            oos.flush();
            System.out.println("server sent: " + output);

            System.out.println("operation complete. closing connection...");
            ois.close();
            oos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("\nserver encountered an exception: " + e);
            System.out.println("restarting...");
            awaitConnections();
        }
    }

    private static String getPrimes(String inputString) {

        String[] inputArrayOfString = inputString.replace("[", "").replace("]", "").split(", ");
        ArrayList<Integer> outputList = new ArrayList<>();
        for (String element : inputArrayOfString) {
            if (element.isEmpty()) {
                return "[]";
            } else if (element.equals("shutdown")) {
                _running = false;
                return "server shutting down";
            }
            int currentNumber = Integer.parseInt(element);
            if (isPrime(currentNumber)) {
                outputList.add(currentNumber);
            }
        }
        return outputList.toString();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

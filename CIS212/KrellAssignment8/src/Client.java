import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CIS212 - Assignment 8
 * Created by krell on 2015-11-28.
 */

public class Client {

    private static int _port = 12335;
    private static String _address = "127.0.0.1";
    private static boolean _running = true;

    public static void main(String[] args) {

        System.out.println("starting client...");
        if (args.length > 0) {
            _port = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            _address = args[1];
        }
        try {
            while (_running) {
                String userInput = getUserInput();
                connectToServer(userInput);
            }
            quit();
        } catch (IOException e) {
            System.out.println("client encountered an exception. exiting...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void connectToServer(String userInput) throws IOException {

        System.out.println("establishing connection...");
        InetAddress address = InetAddress.getByName(_address);
        Socket socket = new Socket(address, _port);

        System.out.println("connection established. creating streams...");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        System.out.println("streams created. sending output to server...");
        oos.writeUTF(userInput);
        oos.flush();
        System.out.println("client sent: " + userInput);

        String input = ois.readUTF();
        System.out.println("client received: " + input);

        System.out.println("operation complete. closing connection...");
        ois.close();
        oos.close();
        socket.close();
    }

    private static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userInputList = new ArrayList<>();
        String userInput = "";
        String command = "";

        System.out.println("\nenter integers to see which are prime.");
        while (!command.equals("send") && !command.equals("quit") && !command.equals("shutdown")) {
            System.out.println("enter an integer, 'send' numbers, 'quit' client, or 'shutdown' server.");
            if (scanner.hasNextInt()) {
                userInputList.add(scanner.nextInt());
            } else if (scanner.hasNext()) {
                command = scanner.next().toLowerCase();
                switch (command) {
                    case "send":
                        userInput = userInputList.toString();
                        break;
                    case "quit":
                        quit();
                    case "shutdown":
                        userInput = "shutdown";
                        _running = false;
                        break;
                    default:
                        System.out.println("invalid input. try again.");
                        break;
                }
            }
        }
        return userInput;
    }

    private static void quit() {
        System.out.println("goodbye.");
        System.exit(0);
    }
}

package de.scholzf.javapoly.Entity.GameObjects.Utils.Server;

import de.scholzf.javapoly.Manager.ConsoleManager;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnection implements Likes, AutoCloseable {

    static final int PORT = 9999;

    public static Socket socket;

    public ServerConnection(final String address)
    {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(address, PORT));
        }
        catch (final IOException e) {
            System.err.println(e.getMessage());
            socket = null;
        }
    }

    @Override
    public void close()
    {
        if (socket != null) {
            try {
                socket.close();
            }
            catch (final IOException e) {
            }
            socket = null;
        }
    }

    @Override
    public void add(final String topic, final String user)
    {
        if (topic == null || topic.indexOf(" ") != -1
                || user == null || user.indexOf(" ") != -1) {
            throw new IllegalArgumentException("LikesClient.add: Ungültige Parameter");
        }

        if (socket != null) {
            try {
                final PrintStream out = new PrintStream(socket.getOutputStream());
                out.println("add " + topic + " " + user);
                out.flush();
            }
            catch (final IOException e) {
                close(); // Schließen, da die Verbindung wohl nicht mehr besteht.
            }
        }
    }

    @Override
    public int get(final String topic)
    {
        if (topic == null || topic.indexOf(" ") != -1) {
            throw new IllegalArgumentException("LikesServer.get: Ungültige Parameter");
        }

        if (socket != null) {
            try  {
                final PrintStream out = new PrintStream(socket.getOutputStream());
                final Scanner in = new Scanner(socket.getInputStream());
                out.println("get " + topic);
                out.flush();
                return in.nextInt();
            }
            catch (final IOException e) {
                close(); // Schließen, da die Verbindung wohl nicht mehr besteht.
            }
        }
        return -1;
    }

}

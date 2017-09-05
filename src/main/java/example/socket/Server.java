package example.socket;

import example.controller.HelloworldController;
import example.service.UserService;
import example.view.HelloworldView;
import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by shell7 on 2017/8/16.
 */
public class Server extends Thread {

    private ApplicationContext context;
    private boolean exit;

    public Server(ApplicationContext context) {
        this.context = context;
        exit = false;
    }

    public void setExit(boolean b) {
        exit = b;
    }

    public void run() {

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket s;
        System.out.println("Waiting client");

        final HelloworldController controller = context.getBean(HelloworldController.class);
        final UserService userService = context.getBean(UserService.class);
        while (!exit) {
            try {
                ss.setSoTimeout(3000);
                s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.start();
                final InetAddress addr = s.getInetAddress();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(userService.queryUserName(2));
                        System.out.println(controller.toString());
                        controller.setHelloLable(addr.getHostAddress());
                    }
                });

            }
            catch (IOException e) {
            e.printStackTrace();
            }
        }
        try {
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

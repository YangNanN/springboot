package example.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by shell7 on 2017/8/16.
 */
public class ServerThread extends Thread {

    Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = s.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("Server got: " + info);
            }
            s.shutdownInput();

            os = s.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("Welcome");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) pw.close();
                if (os != null) os.close();
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

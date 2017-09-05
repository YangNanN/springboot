package example.controller;

import de.felixroske.jfxsupport.FXMLController;
import example.Main;
import example.service.UserService;
import example.socket.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@FXMLController
public class HelloworldController {
    @FXML
    private Label helloLable;
    @FXML
    private Button startButton;

    private UserService userService;
    private ApplicationContext context;

    private Thread t;
    private Server s;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setHelloText(ActionEvent event) {
        helloLable.setText("锟斤拷烫烫烫");
        Main.getStage().setTitle(helloLable.getText());
    }

    public void setHelloLable(String s) {
        helloLable.setText(s);
    }

    public void query(ActionEvent event) {
        helloLable.setText(userService.queryUserName(2));
        Main.getStage().setTitle(helloLable.getText());
    }

    public void serverStart(ActionEvent event) throws InterruptedException {
            s = new Server(context);
            t = new Thread(s);
            t.start();
    }

    public void serverStop(ActionEvent event) throws InterruptedException {
        s.setExit(true);
    }

    public void check(ActionEvent actionEvent) {
        helloLable.setText("test");
    }
}

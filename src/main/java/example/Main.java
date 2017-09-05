package example;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import example.view.HelloworldView;
import example.view.mySplashScreenView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) throws InterruptedException {
        launchApp(Main.class, HelloworldView.class, new mySplashScreenView(), args);
    }
}

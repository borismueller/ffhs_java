import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NameAngle extends Application {
  public void start(Stage primaryStage) {
    Text name = new Text(100, 100, "Boris Müller");

    name.setRotate(ThreadLocalRandom.current().nextInt(0, 361));

    Group group = new Group(name);

    Scene scene = new Scene(group, 200, 350, Color.LIGHTBLUE);

    primaryStage.setTitle("name");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

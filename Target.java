import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// PP 3.11
public class Target extends Application {
  public void start(Stage primaryStage) {
    int center = 250;
    Circle redCircle1 = new Circle(center, center, 150);
    redCircle1.setFill(Color.RED);
    Circle redCircle2 = new Circle(center, center, 120);
    redCircle2.setFill(Color.RED);
    redCircle2.setStroke(Color.BLACK);
    Circle redCircle3 = new Circle(center, center, 90);
    redCircle3.setFill(Color.RED);
    redCircle3.setStroke(Color.BLACK);

    Circle whiteCircle1 = new Circle(center, center, 50);
    whiteCircle1.setFill(Color.WHITE);
    whiteCircle1.setStroke(Color.BLACK);
    Circle whiteCircle2 = new Circle(center, center, 20);
    whiteCircle2.setFill(Color.WHITE);
    whiteCircle2.setStroke(Color.BLACK);

    Group target = new Group(redCircle1, redCircle2, redCircle3, whiteCircle1, whiteCircle2);
    Scene scene = new Scene(target, 500, 500, Color.ALICEBLUE);
    primaryStage.setTitle("target");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

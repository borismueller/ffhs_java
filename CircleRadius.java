import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleRadius extends Application {
  public void start(Stage primaryStage) {
    int initialRadius = 50;

    TextField radiusTextField = new TextField(String.valueOf(initialRadius));
    radiusTextField.setMaxWidth(40);
    Circle circle = new Circle();
    circle.setRadius(initialRadius);
    circle.setFill(Color.OLIVE);

    radiusTextField.setOnAction(event -> {
      int radius = Integer.parseInt(radiusTextField.getText());
      circle.setRadius(radius);
    });

    StackPane pane = new StackPane(circle, radiusTextField);
    pane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(pane, 500, 500);

    primaryStage.setTitle("CIRCLE");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

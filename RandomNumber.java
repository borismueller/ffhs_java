import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// PP 4.12

public class RandomNumber extends Application {
  private int randomNum;

  public void start(Stage primaryStage) {
    randomNum = 0;
    Text randomNumText = new Text();
    Button button = new Button("get random number");
    button.setOnAction((e) -> {
      randomNum = (int) (Math.random() * 100) + 1; // has to be min 1
      randomNumText.setText(String.valueOf(randomNum));
    });

    FlowPane pane = new FlowPane(button, randomNumText);

    Scene scene = new Scene(pane);

    primaryStage.setTitle("random num");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

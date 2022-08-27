import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// PP 4.11
public class FourImage extends Application {

  public void start(Stage primaryStage) {
    Image image = new Image(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Wikimedia-logo.svg/240px-Wikimedia-logo.svg.png");
    ImageView imageView1 = new ImageView(image);
    imageView1.setRotate(30);
    imageView1.setViewport(new Rectangle2D(10, 80, 200, 100));
    ImageView imageView2 = new ImageView(image);
    imageView2.setRotate(60);
    // imageView2.setViewport(new Rectangle2D(200, 80, 10, 20));
    ImageView imageView3 = new ImageView(image);
    imageView3.setRotate(90);
    imageView3.resize(100, 50); // does nothing
    ImageView imageView4 = new ImageView(image);
    imageView4.setRotate(120);
    // imageView4.setRotate(30);

    // StackPane pane = new StackPane(imageView);
    GridPane pane = new GridPane();
    pane.addColumn(1, imageView1, imageView2);
    pane.addColumn(2, imageView3, imageView4);

    Scene scene = new Scene(pane);

    primaryStage.setTitle("4 images");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}

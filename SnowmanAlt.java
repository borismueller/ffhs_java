import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class SnowmanAlt extends Application {
  public void start(Stage primaryStage) {
    Ellipse base = new Ellipse(80, 210, 80, 60);
    base.setFill(Color.WHITE);

    Ellipse middle = new Ellipse(80, 130, 50, 40);
    middle.setFill(Color.WHITE);

    Circle head = new Circle(80, 70, 30);
    head.setFill(Color.WHITE);

    Circle rightEye = new Circle(70, 60, 4);
    Circle leftEye = new Circle(90, 60, 4);
    Line mouth = new Line(70, 80, 90, 80);

    Circle topButton = new Circle(80, 120, 6);
    topButton.setFill(Color.RED);
    Circle bottomButton = new Circle(80, 140, 6);
    bottomButton.setFill(Color.RED);
    Circle thirdButton = new Circle(80, 160, 6);
    thirdButton.setFill(Color.PINK);

    Line leftArm = new Line(110, 130, 160, 130);
    leftArm.setStrokeWidth(3);
    Line rightArm = new Line(50, 130, 0, 100);
    rightArm.setStrokeWidth(3);

    Rectangle stovepipe = new Rectangle(60, 0, 40, 50);
    Rectangle brim = new Rectangle(50, 45, 60, 5);

    Group hat = new Group(stovepipe, brim);
    hat.setTranslateX(10);
    hat.setRotate(15);

    Group snowman = new Group(base, middle, head, leftEye, rightEye, mouth, topButton, bottomButton, thirdButton,
        leftArm, rightArm,
        hat);
    snowman.setTranslateX(170);
    snowman.setTranslateY(50);

    Circle sun = new Circle(400, 50, 30);
    sun.setFill(Color.GOLD);

    Rectangle ground = new Rectangle(0, 250, 500, 100);
    ground.setFill(Color.STEELBLUE);

    Text name = new Text(50, 50, "Boris Müller");

    Group root = new Group(ground, sun, snowman, name);
    Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);

    primaryStage.setTitle("Snowman");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
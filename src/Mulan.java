

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Mulan extends Application {
    private Stage mainStage;
    private GridPane pane;
    private Canvas canvas;
    private Text hint;
    private Button done;
    private Scene scene;

    private int location;
    @Override
    public void start(Stage firststage) throws Exception {
        createMainGame();
        CreateStartGame(firststage);
        firststage.show();
    }

    private void CreateStartGame(Stage firststage) {
        firststage.setTitle("Mulan Story");

        Group startGroup = new Group();
        Image startPhoto = new Image("pic/start.gif");
        ImageView view = new ImageView(startPhoto);
        Button startButton = new Button("Start Game");

        startButton.setLayoutX(290);
        startButton.setLayoutY(200);

        startButton.setOnAction((actionEvent) -> {
            ShowMainGame(actionEvent, firststage);
        });

        startGroup.getChildren().add(view);
        startGroup.getChildren().add(startButton);
        firststage.setScene(new Scene(startGroup));
    }


    private void ShowMainGame(ActionEvent event, Stage firststage) {
        firststage.close();

        scene = new Scene(pane, 800, 600);
        mainStage.setScene(scene);
        mainStage.show();
    }


    private void createMainGame() {
        mainStage = new Stage();
        pane = new GridPane();
        canvas = new Canvas(500, 300);
        hint = createText("Hint");
        done = new Button("done");


        pane.add(canvas, 0, 0);
        pane.add(hint, 0, 1);
        pane.add(done, 1, 1);
//        pane.setGridLinesVisible(true);

        location = 0;
        addPhotoToCanvas("pic/main.png");
        done.setOnAction(this::changePhoto);

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setMaxWidth(60);
    }


    private Text createText(String str) {
        Text t = new Text(str);
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        return t;
    }



    private void addPhotoToCanvas(String str) {
        Image pic = new Image(str);
        if(pic==null){
            throw new Error("addPhotoToCanvas:Cannot find pic");
        }
        GraphicsContext g = canvas.getGraphicsContext2D();
//        g.setFill(Color.BLUE);
        g.drawImage(pic, 0, 0, 500, 300);
        location++;
    }


    private void changePhoto(ActionEvent event) {
        addPhotoToCanvas("pic/P"+location+".jpg");
    }


    public static void main(String[] args) {
        launch(args);
    }
}



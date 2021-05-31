package Application;

import Application.Methods.Reading;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane root = FXMLLoader.load(getClass().getResource("application.fxml"));
        primaryStage.setTitle("Medical Helper");
        Scene scene = new Scene(root, 900, 560);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        Reading.readFile("src/disease.txt");
        Reading.readFile("src/medicine.txt");
        launch(args);
    }
}

package Application.Methods;

import Application.Entities.Disease;
import Application.Entities.Medicine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button mainButton;
    @FXML
    private Button SortByNamebtn;

    @FXML
    private Button SortByPricebtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField queryField;

    @FXML
    private Pane start;

    @FXML
    private Label HelloText, BigText;

    @FXML
    private Pane end;

    @FXML
    private GridPane file;

    @FXML
    private final Text Diagnose = new Text();

    @FXML
    private final Text Pills = new Text();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file.getChildren().removeAll(end);
    }
    @FXML
    private void goBack(){
        file.getChildren().removeAll(end);
        start.getChildren().removeAll(Diagnose, Pills);
        start.getChildren().addAll(queryField, HelloText, mainButton);
        queryField.clear();
        queryField.setPromptText("Болить попа");
        BigText.setText("Вітаю! Я Ваш медичний помічник!");
        BigText.setPrefWidth(470);
    }

    @FXML
    private void buttonClicked(){
        if(!queryField.getText().equals("") && queryField.getText() != null){
            start.getChildren().removeAll(queryField, HelloText, mainButton);
            file.getChildren().add(end);

            String[] queryDisease = queryField.getText().split(", ");

            Diagnose.setText("Схоже, що у Вас " + getDiagnose(queryDisease));
            Diagnose.setLayoutX(150);
            Diagnose.setLayoutY(170);
            Diagnose.setFont(new Font("Microsoft YaHei Light", 25));

            BigText.setText("Радимо звернутися до " + getDoctor(queryDisease));
            BigText.setPrefWidth(600);
            BigText.setLayoutX(100);

            Pills.setText("Можете прийняти це: " + getPillsByPrice(queryDisease));
            Pills.setLayoutX(150);
            Pills.setLayoutY(220);
            Pills.setFont(new Font("Microsoft YaHei Light", 25));

            start.getChildren().addAll(Diagnose, Pills);
            SortByNamebtn.setOnAction(e -> {
                Pills.setText("Можете прийняти це: " + getPillsByName(queryDisease));
            });
            SortByPricebtn.setOnAction(e -> {
                Pills.setText("Можете прийняти це: " + getPillsByPrice(queryDisease));
            });

        }
    }

    public static String getDiagnose(String[] string){
        Disease curDis = new WhichDisease().whichDisease(string);
        return curDis.getName();
    }
    public static String getDoctor(String[] string){
        Disease curDis = new WhichDisease().whichDisease(string);
        return curDis.getDoctor();
    }
    public static String getPillsByPrice(String[] string){
        Disease curDis = new WhichDisease().whichDisease(string);
        StringBuilder result = new StringBuilder();
        for(Medicine med : new QuickSort().sort(curDis)){
            result.append("\n").append(med.toString());
        }
        return result.toString();

    }
    public static String getPillsByName(String[] string){
        Disease curDis = new WhichDisease().whichDisease(string);
        StringBuilder result = new StringBuilder();
        Arrays.sort(curDis.getMedicine(), new Medicine.MedicineNumberOfDosesComparator());
        for(Medicine med : curDis.getMedicine()){
            result.append("\n").append(med.toString());
        }
        return result.toString();
    }

}

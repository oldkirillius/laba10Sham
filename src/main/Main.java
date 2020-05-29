package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label nameLbl = new Label("Enter number:");
        TextField number = new TextField();
        Label msg = new Label();

        msg.setStyle("fx-text-fill: red;");
        msg.setTextAlignment(TextAlignment.RIGHT);
        Button drawBtn = new Button("Draw");
        Button exitBtn = new Button("Exit");
        Button plusBtn = new Button("+");
        Button minusBtn = new Button("-");
        drawBtn.setOnAction(e -> {

            int n = Integer.parseInt(number.getText());
            String str = "";
            for(int i = 0; i < n; i++){
                for(int j=0;j < i+1;j++){
                    str+=j+1;
                }
                str+="\n";
            }
            if (n>= 1 && n<=9) {
                msg.setText(str);
            } else {
                Platform.exit();
            }
        });
        exitBtn.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.setSpacing(15);
        root.getChildren().addAll(nameLbl, number,
                msg, drawBtn, exitBtn);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Shamonin 10");
        stage.show();
    }
}
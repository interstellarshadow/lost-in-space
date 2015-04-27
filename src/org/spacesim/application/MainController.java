package org.spacesim.application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.spacesim.data.world.World;


public class MainController implements Initializable {
    @FXML
    private Label playerName;
    @FXML
    private Label shipName;
    @FXML
    private MenuItem playerNameChange;
    @FXML
    private MenuItem shipNameChange;

    private World gameworld;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerName != null : "fx:id=\"playerName\" not injected.";
        assert shipName != null : "fx:id=\"shipName\" not injected.";
        assert playerNameChange != null : "fx:id=\"playerNameChange\" not injected.";

        gameworld = new World();

        // Initialization logic
        playerName.setText("Right Click to Set Name");
        shipName.setText("Name not set");

        playerNameChange.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(((MenuItem) (event.getSource())).getParentPopup().getOwnerWindow());

                VBox diagBox = new VBox();
                Label label = new Label("Please enter your character's name.");
                // HBox childBox = new HBox();
                TextField field = new TextField();
                field.setPromptText("Character's Name");
                Button OK = new Button("OK");
                OK.setDefaultButton(true);
                OK.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        playerName.setText(field.getText());
                        dialog.close();
                    }
                });
                // childBox.getChildren().addAll(field, OK);
                diagBox.getChildren().addAll(label, field, OK);
                dialog.setScene(new Scene(diagBox));
                dialog.show();

            }
        });
        shipNameChange.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(((MenuItem) (event.getSource())).getParentPopup().getOwnerWindow());

                VBox diagBox = new VBox(8);
                Label label = new Label("Please enter your ship's name.");
                // HBox childBox = new HBox();
                TextField field = new TextField();
                field.setPromptText("Ship's Name");
                Button OK = new Button("OK");
                OK.setDefaultButton(true);
                OK.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        shipName.setText(field.getText());
                        dialog.close();
                    }
                });
                // childBox.getChildren().addAll(field, OK);
                diagBox.getChildren().addAll(label, field, OK);
                dialog.setScene(new Scene(diagBox));
                dialog.show();

            }
        });
    }
}

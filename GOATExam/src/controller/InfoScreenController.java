/*
The GOAT Exam is a very niche concept. Although a lot of people have
played Fallout 3, the large majority of people who may use this application
have probably never heard of the game. This file is the controller for the
"Info Screen" which provides information based on the GOAT Exam, which
includes what the exam is, where it came from, and how it works.
 */


package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class InfoScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button infoBackButton;

    @FXML
    private Line backBorderTop;

    @FXML
    private Line backBorderBottom;

    @FXML
    private Line backBorderRight;

    @FXML
    private Line backBorderLeft;

    @FXML
    void initialize()
    {
        // Takes the user back to the "Start Screen," so the exam can be taken again.
        infoBackButton.setOnAction(event ->
        {
            infoBackButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/startscreen.fxml"));

            try
            {
                loader.load();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        // Borders appear when the "Back" button is hovered over.
        infoBackButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
        {
            backBorderTop.setVisible(true);
            backBorderBottom.setVisible(true);
            backBorderRight.setVisible(true);
            backBorderLeft.setVisible(true);
        });

        // Borders disappear when the user's mouse exits the "Back" button's border.
        infoBackButton.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
        {
            backBorderTop.setVisible(false);
            backBorderBottom.setVisible(false);
            backBorderRight.setVisible(false);
            backBorderLeft.setVisible(false);
        });
    }
}
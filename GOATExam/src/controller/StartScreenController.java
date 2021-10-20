/*
This is the controller for the "Start Screen". This file
includes the controls that exist inside the startscreen.fxml
and also the events that trigger from those controls.
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

public class StartScreenController 
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startScreenButton;

	@FXML
	private Line startTopBorder;

	@FXML
	private Line startBottomBorder;

	@FXML
	private Line startLeftBorder;

	@FXML
	private Line startRightBorder;

	@FXML
	private Button startScreenInfoButton;

	@FXML
	private Line startInfoBorderTop;

	@FXML
	private Line startInfoBorderBottom;

	@FXML
	private Line startInfoBorderLeft;

	@FXML
	private Line startInfoBorderRight;

    @FXML
    void initialize() 
    {
    	
    	startScreenButton.setOnAction(event ->
    	{
    		startScreenButton.getScene().getWindow().hide();
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/view/questionscreen.fxml"));
    		
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

		startScreenInfoButton.setOnAction(event ->
		{
			startScreenButton.getScene().getWindow().hide();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/infoscreen.fxml"));

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

		startScreenButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			startTopBorder.setVisible(true);
			startBottomBorder.setVisible(true);
			startLeftBorder.setVisible(true);
			startRightBorder.setVisible(true);
		});

		startScreenButton.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			startTopBorder.setVisible(false);
			startBottomBorder.setVisible(false);
			startLeftBorder.setVisible(false);
			startRightBorder.setVisible(false);
		});

		startScreenInfoButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			startInfoBorderTop.setVisible(true);
			startInfoBorderBottom.setVisible(true);
			startInfoBorderRight.setVisible(true);
			startInfoBorderLeft.setVisible(true);
		});

		startScreenInfoButton.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			startInfoBorderTop.setVisible(false);
			startInfoBorderBottom.setVisible(false);
			startInfoBorderRight.setVisible(false);
			startInfoBorderLeft.setVisible(false);
		});

    }
}

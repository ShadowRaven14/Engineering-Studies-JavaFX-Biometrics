package com.example.biometriajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;

import static java.lang.Integer.parseInt;

public class HelloController
{

    //Buffered images
    private BufferedImage originalImage;
    private BufferedImage niBlackImage;

    //Image views
    @FXML private ImageView originalImageView;
    @FXML private ImageView niBlackImageView;
    @FXML private ImageView sauvolaImageView;
    @FXML private ImageView phansalkarImageView;
    @FXML private ImageView bernsenImageView;

    @FXML private Label welcomeText;
    @FXML private TextField windowParameterTextField;
    @FXML private TextField thresholdParameterTextField;

    @FXML private Button loadImageBtn;
    @FXML private Button niBlackBtn;
    @FXML private Button sauvolaBtn;
    @FXML private Button phansalkarBtn;
    @FXML private Button bernsenBtn;

    @FXML protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML protected void onLoadImageBtnClick()
    {
        Stage thisStage = (Stage) loadImageBtn.getScene().getWindow();
        originalImage = FileHandler.LoadImage(thisStage);
        originalImageView.setImage(FileHandler.convertToFxImage(originalImage));
        welcomeText.setText("Load image!");
    }

    @FXML protected void onNiBlackBtnClick()
    {
        if( windowParameterTextField.getText() != "" && thresholdParameterTextField.getText() != "")
        {
            welcomeText.setText("NiBlack Loading...");

            int window = Integer.parseInt(windowParameterTextField.getText());
            double k = Double.parseDouble(thresholdParameterTextField.getText());
            if(k > 0) k *= -1;

            niBlackImage = AlgorytmNiBlack.binarize(originalImage, window, k);
            niBlackImageView.setImage(FileHandler.convertToFxImage(niBlackImage));

            welcomeText.setText("NiBlack Image Loaded!");
        }
    }

    @FXML protected void onSauvolaBtnClick()
    {

    }

    @FXML protected void onPhansalkarClick()
    {

    }

    @FXML protected void onBernsenBtnClick()
    {

    }

}
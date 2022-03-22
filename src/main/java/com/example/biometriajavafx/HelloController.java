package com.example.biometriajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
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
    @FXML private TextField windowTextField;

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
        niBlackImage = AlgorytmNiBlack.binarize(originalImage, Integer.parseInt(windowTextField.getText()));
        niBlackImageView.setImage(FileHandler.convertToFxImage(niBlackImage));
        welcomeText.setText("NiBlack image!");
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
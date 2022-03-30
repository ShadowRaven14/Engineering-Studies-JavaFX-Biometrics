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
    private BufferedImage sauvolaImage;
    private BufferedImage phansalkarImage;
    private BufferedImage bernsenImage;

    //Image views



    // PS3
    @FXML private ImageView originalImageView;
    @FXML private ImageView niBlackImageView;
    @FXML private ImageView sauvolaImageView;
    @FXML private ImageView phansalkarImageView;
    @FXML private ImageView bernsenImageView;

    //PS4
    @FXML private ImageView originalImageViewPS4;
    @FXML private ImageView pixelationImageView;

    @FXML private Label welcomeText;
    @FXML private TextField windowParameterTextField;
    @FXML private TextField thresholdParameterTextField;
    @FXML private TextField pixelSizeParameterTextField;

    @FXML private Button loadImageBtn;

    // PS3
    @FXML private Button niBlackBtn;
    @FXML private Button sauvolaBtn;
    @FXML private Button phansalkarBtn;
    @FXML private Button bernsenBtn;

    // PS4
    @FXML private Button pixelationBtn;


    @FXML protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML protected void onLoadImageBtnClick()
    {
        Stage thisStage = (Stage) loadImageBtn.getScene().getWindow();
        originalImage = FileHandler.LoadImage(thisStage);
        originalImageView.setImage(FileHandler.convertToFxImage(originalImage));
        originalImageViewPS4.setImage(FileHandler.convertToFxImage(originalImage));
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

            niBlackImage = AlgorithmNiBlack.binarize(originalImage, window, k);
            niBlackImageView.setImage(FileHandler.convertToFxImage(niBlackImage));

            welcomeText.setText("NiBlack Image Loaded!");
        }
    }

    @FXML protected void onSauvolaBtnClick()
    {
        if( windowParameterTextField.getText() != "" && thresholdParameterTextField.getText() != "")
        {
            welcomeText.setText("Sauvola Loading...");

            int window = Integer.parseInt(windowParameterTextField.getText());
            double k = Double.parseDouble(thresholdParameterTextField.getText());
            //if(k > 0) k *= -1;

            sauvolaImage = AlgotithmSauvola.binarize(originalImage, window, k);
            sauvolaImageView.setImage(FileHandler.convertToFxImage(sauvolaImage));

            welcomeText.setText("Sauvola Image Loaded!");
        }
    }

    @FXML protected void onPhansalkarClick()
    {
        if( windowParameterTextField.getText() != "" && thresholdParameterTextField.getText() != "")
        {
            welcomeText.setText("Phansalkar Loading...");

            int window = Integer.parseInt(windowParameterTextField.getText());
            double k = Double.parseDouble(thresholdParameterTextField.getText());
            //if(k > 0) k *= -1;

            phansalkarImage = AlgotithmPhansalkar.binarize(originalImage, window, k);
            phansalkarImageView.setImage(FileHandler.convertToFxImage(phansalkarImage));

            welcomeText.setText("Phansalkar Image Loaded!");
        }
    }

    @FXML protected void onBernsenBtnClick()
    {
        if( windowParameterTextField.getText() != "" && thresholdParameterTextField.getText() != "")
        {
            welcomeText.setText("Bernsen Loading...");

            int window = Integer.parseInt(windowParameterTextField.getText());
            double k = Double.parseDouble(thresholdParameterTextField.getText());
            //if(k > 0) k *= -1;

            bernsenImage = AlgorithmBernsen.binarize(originalImage, window, k);
            bernsenImageView.setImage(FileHandler.convertToFxImage(bernsenImage));

            welcomeText.setText("Bernsen Image Loaded!");
        }

    }

    @FXML protected void onPixelationBtnClick() {

        if(pixelSizeParameterTextField.getText() != "") {

            int PIX_SIZE = Integer.parseInt(pixelSizeParameterTextField.getText());
            BufferedImage pixelatedImage = AlgorithmPixelation.pixelate(originalImage, PIX_SIZE);
            pixelationImageView.setImage(FileHandler.convertToFxImage(pixelatedImage));

        }

    }

}
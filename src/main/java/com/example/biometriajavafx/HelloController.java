package com.example.biometriajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javafx.event.ActionEvent;

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
    @FXML private ImageView medianImageView;

    //PS5
    @FXML private ImageView originalImageViewPS5;

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
    @FXML private Button medianBtn;

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
        originalImageViewPS5.setImage(FileHandler.convertToFxImage(originalImage));
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

    @FXML protected void onMedianBtnClick() {

        if(pixelSizeParameterTextField.getText() != "") {

            int PIX_SIZE = Integer.parseInt(pixelSizeParameterTextField.getText());
            BufferedImage medianedImage = AlgorithmMedian.median(originalImage, PIX_SIZE);
            medianImageView.setImage(FileHandler.convertToFxImage(medianedImage));

        }

    }

    @FXML protected void onImageToSegmentClick() {

        int tolerance = 60;
        Color color = Color.black ;

        originalImageViewPS5.setOnMouseClicked(e -> {
            int  x0 = (int) e.getX();
            int  y0 = (int) e.getY();

            System.out.printf("X: %f Y: %f",x0, y0);

            BufferedImage segmentedImage = AlgorithmSegmentation.segment(originalImage, x0, y0, tolerance, color);



            originalImageViewPS5.setImage(FileHandler.convertToFxImage(segmentedImage));
        } );

    }



}
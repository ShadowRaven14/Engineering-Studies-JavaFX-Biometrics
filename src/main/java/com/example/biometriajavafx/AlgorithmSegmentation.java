package com.example.biometriajavafx;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class AlgorithmSegmentation {

    public static BufferedImage segment(BufferedImage imageToSegment, int x0, int y0, int tolerance, Color color) {

        BufferedImage img = new BufferedImage(
                imageToSegment.getWidth(),
                imageToSegment.getHeight(),
                imageToSegment.getType());





        return img;
    }

}

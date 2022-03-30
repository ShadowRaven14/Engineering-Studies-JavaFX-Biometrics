package com.example.biometriajavafx;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class AlgorithmMedian {

    public static BufferedImage median(BufferedImage img, int window) {

        BufferedImage medianImage = new BufferedImage(
                img.getWidth(),
                img.getHeight(),
                img.getType());

        int width = medianImage.getWidth();
        int height = medianImage.getHeight();

        window = 3;
        Color[] pixel = new Color[window * window];
        int[] R= new int[window * window];
        int[] G= new int[window * window];
        int[] B= new int[window * window];


        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
                pixel[0]=new Color(img.getRGB(i-1,j-1));
                pixel[1]=new Color(img.getRGB(i-1,j));
                pixel[2]=new Color(img.getRGB(i-1,j+1));
                pixel[3]=new Color(img.getRGB(i,j+1));
                pixel[4]=new Color(img.getRGB(i+1,j+1));
                pixel[5]=new Color(img.getRGB(i+1,j));
                pixel[6]=new Color(img.getRGB(i+1,j-1));
                pixel[7]=new Color(img.getRGB(i,j-1));
                pixel[8]=new Color(img.getRGB(i,j));
                for(int k=0;k<9;k++){
                    R[k]=pixel[k].getRed();
                    G[k]=pixel[k].getGreen();
                    B[k]=pixel[k].getBlue();

                }
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                medianImage.setRGB(i,j,new Color(R[4],G[4],B[4]).getRGB());
            }




//        //Scanning the entire image
//        for (int column = 0; column < width; column++) {
//            for (int row = 0; row < height; row++) {
//
//                //Sweeping the window to get the average
//                for (int ji = -window; ji < window; ji++) {
//                    for (int jj = -window; jj < window; jj++) {
//                        //Accumulating the values and then taking the average - do if serves to protect the window from not walking out of the image
//                        if (column + ji >= 0 && column + ji < width)
//                            if (row + jj >= 0 && row + jj < height) {
//
//                                pixel[row + jj >= 0]
//                                iRed += imgBuff.getRGB(column + ji, row + jj) & 0xff0000 >> 16;
//                                iGreen += imgBuff.getRGB(column + ji, row + jj) & 0x00ff00 >> 8;
//                                iBlue += imgBuff.getRGB(column + ji, row + jj) & 0xff;
//                                //iAverage += imgBuff.getRGB(column+ji, row+jj) & 0x00ff0000 >> 16;
//                            }
//                    }
//                }
//            }
//        }
//
        return medianImage;
    }

}
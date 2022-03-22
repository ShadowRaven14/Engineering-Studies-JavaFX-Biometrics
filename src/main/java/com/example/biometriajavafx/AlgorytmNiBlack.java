package com.example.biometriajavafx;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class AlgorytmNiBlack
{

    //Declarative variables
    private static int width;
    private static int height;
    public final int pixel_ob = 0xffffffff; //object pixel
    public final int pixel_bg = 0xff000000; //background pixel

    //Binarization by NiBlack
    public static BufferedImage binarize(BufferedImage imgBuff)
    {

        width = imgBuff.getWidth();
        height = imgBuff.getHeight();

        BufferedImage img = deepCopy(imgBuff);

        //Window size (for each side)
        int window = 3;

        //Scanning the entire image
        for (int c = 0; c < width; c++)
        {
            for (int r = 0; r < height; r++)
            {
                int acc = 0;

                //Sweeping the window to get the average
                for(int ji = -window ; ji < window ; ji++)
                {
                    for(int jj = -window ; jj < window ; jj++)
                    {
                        //Accumulating the values and then taking the average - do if serves to protect the window from not walking out of the image
                        if(c+ji >= 0 && c+ji < width)
                            if(r+jj >= 0 && r+jj < height)
                                acc += imgBuff.getRGB(c+ji, r+jj) & 0x00ff0000 >> 16;
                    }
                }

                //is higher than average
                int pixel = img.getRGB(c, r) & 0x00ff0000 >> 16;
                if (pixel > acc / ((window*2) * (window*2)) ) img.setRGB(c, r, 0x00FFFFFF );
                else img.setRGB(c, r, 0x00000000 );
            }
        }

        return img;
    }

    static BufferedImage deepCopy(BufferedImage bi)
    {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}

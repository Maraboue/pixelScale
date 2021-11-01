import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;


/** Welcome to pixelScale!
 *  This program can re-size a dir of images.
 *  Requirements: All images in the dir needs to be labeled numeric in order: (1 up to N).
 *
 *  This program is a work in progress.
 *
 *  Author: Gustaf Sjölinder @ Dynamic Network & Pixel Cowboys
 */


public class main {

    static private BufferedImage[] images;

    private static JLabel l;
    private static String route;
    private static String target;
    private static Frame frame;

    private static boolean run = true;

    public static void main(String args[]) throws Exception {

        frame = new Frame();
        frame.initFrame();

        while(run) {

            route = frame.getRoute();
            target = frame.getTarget();
            System.out.println(route + "in main");
            if(route!="No dir selected") {
                {
                    run = false;
                    resizeImages(36, 64, route);
                    saveImages(route);
                }
            }
        }

    }

    static void saveImages(String path) throws IOException {
        System.out.println("Saving new images...");

        for(int i=1; i< images.length;i++){
            try {
                File outputfile = new File(path+ "\\" + i + ".png ");
                ImageIO.write(images[i], "png", outputfile);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Saving Complete!");
    }

    static void resizeImages(int nrOfImages, int targetSize, String path) throws IOException {
        System.out.println("Re-sizing images..");
        images = new BufferedImage[nrOfImages];
        for(int i=1; i < images.length;i++) {
            try {
                BufferedImage img = ImageIO.read(new File(path+ "\\" + i + ".png "));
                BufferedImage scaledImg = Scalr.resize(img, Scalr.Method.ULTRA_QUALITY, targetSize);
                images[i] = scaledImg;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Re-sizing Complete!");
    }

}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TransformacaoRGB {

    public static void main(String[] args) throws IOException {
            BufferedImage imgOriginal = ImageIO.read(new File("1.jpg"));

            for (int y = 0; y < imgOriginal.getHeight(); y++) {

                for (int x = 0; x < imgOriginal.getWidth(); x++) {

                    Color CorPixel = new Color(imgOriginal.getRGB(x, y));

                    int R = 255 - CorPixel.getRed();
                    int G = 255 - CorPixel.getGreen();
                    int B = 255 - CorPixel.getBlue();

                    int c = (int) (0.299 * R + 0.587 * G + 0.114 * B);

                    Color CorNova = new Color (c, c, c);

                    imgOriginal.setRGB(x, y, CorNova.getRGB());

                }
            }
            ImageIO.write(imgOriginal, "jpg", new File("2.jpg"));

            System.out.println("Transformação bem sucedida.");
    }
}

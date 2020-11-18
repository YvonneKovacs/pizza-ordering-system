package de.hhn.mib.gpi2.ubungsblatt4.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * * The class that creates the images for the selected toppings
 * @author Yvonne Kovacs
 */
public class ImagePanel extends JPanel {

    private JLabel imageLabel;
    private BufferedImage resized;
    private List<BufferedImage> imgs;

    /**
     * the constructor creates a list with all the buffered images of the toppings and draws the pizza base
     */
    public ImagePanel() {
        try {

            this.setBackground(new Color(255,255, 204));

            BufferedImage pizzaboden = ImageIO.read(new File("bildresourcen/pizzaboden.png"));
            BufferedImage tomatoImage = ImageIO.read(new File("bildresourcen/tomaten.png"));
            BufferedImage cheeseImage = ImageIO.read(new File("bildresourcen/kaese.png"));
            BufferedImage salamiImage = ImageIO.read(new File("bildresourcen/salami.png"));
            BufferedImage hamImage = ImageIO.read(new File("bildresourcen/schinken.png"));
            BufferedImage ananasImage = ImageIO.read(new File("bildresourcen/ananas.png"));
            BufferedImage vegetablesImage = ImageIO.read(new File("bildresourcen/gemuese.png"));
            BufferedImage seafoodImage = ImageIO.read(new File("bildresourcen/meeresfruechte.png"));
            BufferedImage nutellaImage = ImageIO.read(new File("bildresourcen/nutella.png"));
            BufferedImage sourcreamImage = ImageIO.read(new File("bildresourcen/sourcream.png"));
            imgs = new ArrayList<>();
            imgs.add(pizzaboden);
            imgs.add(tomatoImage);
            imgs.add(cheeseImage);
            imgs.add(salamiImage);
            imgs.add(hamImage);
            imgs.add(ananasImage);
            imgs.add(vegetablesImage);
            imgs.add(seafoodImage);
            imgs.add(nutellaImage);
            imgs.add(sourcreamImage);

            resized = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resized.createGraphics();
            g.drawImage(pizzaboden, 0, 0, 200, 200, null);
            g.dispose();
            imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon(resized));
            this.add(imageLabel);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * draws all the buffered images for the selected toppings
     * @param selectedToppings the list of toppings which are selected
     * @throws IOException
     */
    public void updateImages(List<Integer> selectedToppings) throws IOException {
        resized = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < selectedToppings.size(); i++) {
            Graphics g = resized.createGraphics();
            g.drawImage(imgs.get(selectedToppings.get(i)), 0, 0, 200, 200, null);
            g.dispose();

        }

        imageLabel.setIcon(new ImageIcon(resized));

        this.repaint();
    }
}
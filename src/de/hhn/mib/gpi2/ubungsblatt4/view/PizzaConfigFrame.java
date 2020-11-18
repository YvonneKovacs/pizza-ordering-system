package de.hhn.mib.gpi2.ubungsblatt4.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 *  The class that contains the InputPanel, the Menu and the BufferedImage
 * @author Yvonne Kovacs
 */
public class PizzaConfigFrame extends JFrame {

    /**
     * adds the Menubar, the InputPanel and an image placeholder to the Frame
     */
    public PizzaConfigFrame() throws IOException {

        super("Pizzakonfigurator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.getContentPane().setBackground(new Color(255,255, 204));
        MyMenuBar myMenuBar=new MyMenuBar(this);
        this.setJMenuBar(getJMenuBar());
        ImagePanel imagePanel=new ImagePanel();
        InputPanel inputPanel=new InputPanel(imagePanel);

        this.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints cst = new GridBagConstraints();

        cst.fill = GridBagConstraints.HORIZONTAL;


        cst.anchor=GridBagConstraints.NORTHWEST;
        cst.weightx=0.5;
        cst.weighty=0.5;
        cst.gridx = 0;
        cst.gridy = 0;
        this.add(myMenuBar,cst);

        cst.gridx = 0;
        cst.gridy = 1;
        this.add(inputPanel,cst);


        cst.gridx = 1;
        cst.gridy = 1;

        this.getContentPane().add(imagePanel,cst);

        this.setVisible(true);

    }



}

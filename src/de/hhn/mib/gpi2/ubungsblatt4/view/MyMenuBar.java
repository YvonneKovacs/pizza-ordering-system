package de.hhn.mib.gpi2.ubungsblatt4.view;

import de.hhn.mib.gpi2.ubungsblatt4.i18n.I18N;
import de.hhn.mib.gpi2.ubungsblatt4.model.Order;
import de.hhn.mib.gpi2.ubungsblatt4.model.Pizza;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *  * The class that contains the menubar
 * @author Yvonne Kovacs
 */



public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu, orderMenu, helpMenu, languageMenu;
    private JMenuItem quit, saveOrder, importOrder, german, english;
    private I18N i18n;

    private static final String COMMA_DELIMITER = ",";

    private static final String NEW_LINE_SEPARATOR = "\n";

    /**
     * adds menu and menu items to the menubar and actionlisteners to the items
     */
    public MyMenuBar(PizzaConfigFrame pizzaConfigFrame) {

        this.setBackground(new Color(223,212, 201));
        fileMenu = new JMenu(i18n.getMessage("file"));
        fileMenu.setMnemonic('D');

        quit = new JMenuItem(i18n.getMessage("close"));
        quit.setMnemonic('B');
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        quit.addActionListener(e -> System.exit(0));

        fileMenu.add(quit);

        this.add(fileMenu);

        orderMenu = new JMenu(i18n.getMessage("order"));
        orderMenu.setMnemonic('B');

        saveOrder = new JMenuItem(i18n.getMessage("saveOrder"));
        saveOrder.setMnemonic('B');
        saveOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                writeOrder(callOpenFileDialog());
            }
        });


        orderMenu.add(saveOrder);

        importOrder = new JMenuItem(i18n.getMessage("importOrder"));
        importOrder.setMnemonic('B');
        importOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        importOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                readOrder(callOpenFileDialog());
            }
        });

        orderMenu.add(importOrder);

        this.add(orderMenu);

        helpMenu = new JMenu(i18n.getMessage("help"));
        helpMenu.setMnemonic('H');

        this.add(helpMenu);

        languageMenu=new JMenu(i18n.getMessage("languange"));
        languageMenu.setMnemonic('L');

        german= new JMenuItem(i18n.getMessage("german"));
        german.setMnemonic('D');

        english=new JMenuItem(i18n.getMessage("english"));
        english.setMnemonic('E');

        languageMenu.add(german);
        languageMenu.add(english);

        I18N i18n=new I18N();
        german.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                pizzaConfigFrame.dispose();
                Locale localeDE=new Locale("de", "DE");
                i18n.setLocale(localeDE);
                try {
                    PizzaConfigFrame pizzaConfigFrame1 =new PizzaConfigFrame();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //InputPanel inputPanel=new InputPanel(new ImagePanel());

            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                pizzaConfigFrame.dispose();
                Locale localeEN=new Locale("en", "US");
                i18n.setLocale(localeEN);
                try {
                    PizzaConfigFrame pizzaConfigFrame1 =new PizzaConfigFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        this.add(languageMenu);

    }

    /**
     * writes the order in a cvs file
     * @param filePath the path of the cvs file
     */
    void writeOrder(String filePath){

        FileWriter fileWriter = null;

        List<Pizza> pizzas= InputPanel.getPizzas();
        Order order=new Order(1, LocalDateTime.now(), pizzas);

            try {

            fileWriter = new FileWriter(filePath);

            for(Pizza pizza: pizzas) {

                fileWriter.append(String.valueOf(order.getOrderId()));
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(pizza.getPrice()));
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(pizza.getSize()));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(pizza.getPizzaToppings()));

                fileWriter.append(NEW_LINE_SEPARATOR);

            }


            JOptionPane.showMessageDialog(this,"Die Bestellung ist gespeichert! \n");


        } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Error in CsvFileWriter ",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);

        } finally {

            try {

                fileWriter.flush();

                fileWriter.close();

            } catch (IOException e) {

                JOptionPane.showMessageDialog(this,
                        "Error while flushing/closing fileWriter ",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);

            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(this,
                        "No file was selected. ",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    /**
     * reads all the orders from a cvs file
     * @param filePath the path of the cvs file
     */
    void readOrder(String filePath) {
        BufferedReader fileReader = null;

        try {
            String line;
            List<String> order=new ArrayList<>();
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(filePath));

            while ((line = fileReader.readLine()) != null) {

                order.add(line);
                order.add("\n");

            }
            JOptionPane.showMessageDialog(this,"Your orders: \n"+order+"\n");

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Error in CsvFileReader ",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);

        } finally {

            try {

                fileReader.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Error while closing fileReader ",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(this,
                        "No file was selected. ",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }


        }


}


    /**
     * method which opens a dialog for a file chooser
     */
    public String callOpenFileDialog() {
        JFileChooser chooser=new JFileChooser();
        chooser.setDialogTitle("Waehlen Sie einen txt- oder csv-file aus:");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return (f.isDirectory()
                        || f.getName().toLowerCase().endsWith(".txt") || f
                        .getName().toLowerCase().endsWith(".csv"));
            }

            @Override
            public String getDescription() {
                return "txt; csv";
            }
        });

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file=chooser.getSelectedFile();
            String filePath=file.getPath();
            /*
            path without dcument name
            File file=chooser.getCurrentDirectory();
            String filePath=file.getPath();*/

            /*
            path with the name of the file

            File file1=chooser.getSelectedFile();
            String filePath1=file1.getPath();
            System.out.println(filePath1);
            */
            return filePath;

        }
        else {
            //System.out.println("No Selection ");
            return null;
        }


    }
}

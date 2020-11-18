package de.hhn.mib.gpi2.ubungsblatt4.view;


import de.hhn.mib.gpi2.ubungsblatt4.exceptions.NoToppingSelectedException;
import de.hhn.mib.gpi2.ubungsblatt4.i18n.I18N;
import de.hhn.mib.gpi2.ubungsblatt4.model.Pizza;
import de.hhn.mib.gpi2.ubungsblatt4.model.PizzaSize;
import de.hhn.mib.gpi2.ubungsblatt4.model.PizzaTopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * The class that contains the Labels, Combobox, Radio Buttons, Buttons
 * @author Yvonne Kovacs
 */
public class InputPanel extends JPanel{


    private int nrTopping=0;
    private int pizzaSizePrice;
    private int totalPizzaPrice;
    private PizzaSize pizzaSize;
    private Pizza pizza;
    private static List<Pizza> pizzas;
    private  JRadioButton tomatoButton,cheeseButton,salamiButton,hamButton,ananasButton, vegetablesButton, seafoodButton, nutellaButton, sourCreamButton;
    private  JTextField txtDate, txtHour, txtIngredient;
    private ImagePanel imagePanel;
    private I18N i18n;

    /**
     * adds a GridbagLayout to the panel which is filled
     * with a combobox for the size, radio buttons for the toppings and buttons
     */

    public InputPanel(ImagePanel imagePanel) {


        pizzas=new ArrayList<>();
        this.imagePanel=imagePanel;
        GridBagLayout gridBagLayout=new GridBagLayout();
        this.setLayout(gridBagLayout);
        GridBagConstraints cst = new GridBagConstraints();
        this.setBackground(new Color(255,255, 204));

        cst.fill = GridBagConstraints.HORIZONTAL;

        cst.gridx = 0;
        cst.gridy = 0;
        JLabel dateLabel= new JLabel(i18n.getMessage("date"));
        this.add(dateLabel,cst);

        cst.gridx = 1;
        cst.gridy = 0;
        DateFormat df = new SimpleDateFormat("dd.mm.yy");
        txtDate = new JFormattedTextField(df);
        this.add(txtDate,cst);

        cst.gridx = 0;
        cst.gridy = 1;
        JLabel hourLabel= new JLabel(i18n.getMessage("time"));
        this.add(hourLabel,cst);

        cst.gridx = 1;
        cst.gridy = 1;
        DateFormat zf = new SimpleDateFormat("hh:mm");
        txtHour = new JFormattedTextField(zf);
        this.add(txtHour,cst);

        cst.gridx = 0;
        cst.gridy = 2;
        JLabel sizeLabel= new JLabel(i18n.getMessage("size"));
        this.add(sizeLabel,cst);

        cst.gridx = 1;
        cst.gridy = 2;
        JComboBox<PizzaSize> sizeList = new JComboBox<>();
        sizeList.addItem(PizzaSize.SMALL);
        sizeList.addItem(PizzaSize.MEDIUM);
        sizeList.addItem(PizzaSize.LARGE);
        sizeList.addItem(PizzaSize.EXTRA_LARGE);

        /*JComboBox<String> sizeList = new JComboBox<>();
        sizeList.addItem(i18n.getMessage("small"));
        sizeList.addItem(i18n.getMessage("medium"));
        sizeList.addItem(i18n.getMessage("large"));
        sizeList.addItem(i18n.getMessage("extraLarge"));*/

        this.add(sizeList,cst);

        sizeList.setSelectedItem(PizzaSize.SMALL);
        pizzaSize=(PizzaSize) sizeList.getSelectedItem();
        pizzaSizePrice=pizzaSize.getPizzaPrice();

        sizeList.addActionListener(new ActionListener() {//add actionlistener to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                pizzaSize = (PizzaSize) sizeList.getSelectedItem();
                pizzaSizePrice = pizzaSize.getPizzaPrice();
            }
        });


        cst.gridx = 0;
        cst.gridy = 3;
        JLabel toppingLabel= new JLabel(i18n.getMessage("topping"));
        this.add(toppingLabel,cst);

        cst.gridx = 1;
        cst.gridy = 3;
        tomatoButton = new JRadioButton(i18n.getMessage("tomato"));
        this.add(tomatoButton,cst);


        cst.gridx = 1;
        cst.gridy = 4;
        cheeseButton = new JRadioButton(i18n.getMessage("cheese"));
        this.add(cheeseButton,cst);

        cst.gridx = 1;
        cst.gridy = 5;
        salamiButton = new JRadioButton(i18n.getMessage("salami"));
        this.add(salamiButton,cst);

        cst.gridx = 1;
        cst.gridy = 6;
        hamButton = new JRadioButton(i18n.getMessage("ham"));
        this.add(hamButton,cst);
        cst.gridx = 1;
        cst.gridy = 7;
        ananasButton = new JRadioButton(i18n.getMessage("ananas"));
        this.add(ananasButton,cst);


        cst.gridx = 1;
        cst.gridy = 8;
        vegetablesButton = new JRadioButton(i18n.getMessage("vegetables"));
        this.add(vegetablesButton,cst);

        cst.gridx = 1;
        cst.gridy = 9;
        seafoodButton = new JRadioButton(i18n.getMessage("seafood"));
        this.add(seafoodButton,cst);

        cst.gridx = 1;
        cst.gridy = 10;
        nutellaButton = new JRadioButton(i18n.getMessage("nutella"));
        this.add(nutellaButton,cst);


        cst.gridx = 1;
        cst.gridy = 11;
        sourCreamButton = new JRadioButton(i18n.getMessage("sourCream"));
        this.add(sourCreamButton,cst);

        cst.gridx = 0;
        cst.gridy = 12;
        JLabel ingredientLabel= new JLabel(i18n.getMessage("ingredient"));
        this.add(ingredientLabel,cst);

        cst.gridx = 1;
        cst.gridy = 12;
        txtIngredient = new JFormattedTextField();
        this.add(txtIngredient,cst);


        tomatoButton.setBackground(new Color(255,255, 204));
        cheeseButton.setBackground(new Color(255,255, 204));
        salamiButton.setBackground(new Color(255,255, 204));
        hamButton.setBackground(new Color(255,255, 204));
        ananasButton.setBackground(new Color(255,255, 204));
        vegetablesButton.setBackground(new Color(255,255, 204));
        seafoodButton.setBackground(new Color(255,255, 204));
        nutellaButton.setBackground(new Color(255,255, 204));
        sourCreamButton.setBackground(new Color(255,255, 204));

        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                AbstractButton aButton = (AbstractButton)itemEvent.getSource();
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    nrTopping++;  //selected

                }
                else nrTopping--;   //deselected
            }
        };


        ActionListener actionListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List <Integer> selectedToppings=new ArrayList<>();
                selectedToppings.add(0);
                if(tomatoButton.isSelected()){
                    selectedToppings.add(1);

                } else {
                    selectedToppings.removeAll(Arrays.asList(1));

                }
                if(cheeseButton.isSelected()){
                    selectedToppings.add(2);

                } else {
                    selectedToppings.remove(new Integer(2));

                }
                if(salamiButton.isSelected()){
                    selectedToppings.add(3);

                } else {
                    selectedToppings.removeAll(Arrays.asList(3));

                }
                if(hamButton.isSelected()){
                    selectedToppings.add(4);

                } else {
                    selectedToppings.remove(Integer.valueOf(4));

                }
                if(ananasButton.isSelected()){
                    selectedToppings.add(5);

                } else {
                    selectedToppings.remove(Integer.valueOf(5));

                }

                if(vegetablesButton.isSelected()){
                    selectedToppings.add(6);

                } else {
                    selectedToppings.remove(Integer.valueOf(6));

                }

                if(seafoodButton.isSelected()){
                    selectedToppings.add(7);

                } else {
                    selectedToppings.remove(Integer.valueOf(7));

                }

                if(nutellaButton.isSelected()){
                    selectedToppings.add(8);

                } else {
                    selectedToppings.remove(Integer.valueOf(8));

                }

                if(sourCreamButton.isSelected()){
                    selectedToppings.add(9);

                } else {
                    selectedToppings.remove(Integer.valueOf(9));

                }

                try {
                    imagePanel.updateImages(selectedToppings);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
        tomatoButton.addItemListener(itemListener);
        tomatoButton.addActionListener(actionListener);
        cheeseButton.addItemListener(itemListener);
        cheeseButton.addActionListener(actionListener);
        salamiButton.addItemListener(itemListener);
        salamiButton.addActionListener(actionListener);
        hamButton.addItemListener(itemListener);
        hamButton.addActionListener(actionListener);
        ananasButton.addItemListener(itemListener);
        ananasButton.addActionListener(actionListener);
        vegetablesButton.addItemListener(itemListener);
        vegetablesButton.addActionListener(actionListener);
        seafoodButton.addItemListener(itemListener);
        seafoodButton.addActionListener(actionListener);
        nutellaButton.addItemListener(itemListener);
        nutellaButton.addActionListener(actionListener);
        sourCreamButton.addItemListener(itemListener);
        sourCreamButton.addActionListener(actionListener);


        JButton fertigButton = new JButton(i18n.getMessage("done"));
        JButton abbrechenButton = new JButton(i18n.getMessage("quit"));

        abbrechenButton.addActionListener(e->System.exit(0));

        fertigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                    if(checkDate()){
                    noTooping();
                    callModalDialog();}
                }catch(NoToppingSelectedException e){
                    callNoToppingDialog();
                }
            }
            });

        cst.gridx = 2;
        cst.gridy = 16;

        this.add(fertigButton,cst);

        cst.gridx = 3;
        cst.gridy = 16;
        this.add(abbrechenButton,cst);


    }

    /**
     * the method checks which toppings are selected
     * @return a list with the selected PizzaToppings
     */
    public List<PizzaTopping> getSelectedPizzaToppings(){
        List<PizzaTopping> pizzaToppings=new ArrayList<>();

        if(tomatoButton.isSelected())
            pizzaToppings.add(PizzaTopping.TOMATOMATO);
        if(cheeseButton.isSelected())
            pizzaToppings.add(PizzaTopping.CHEESE);
        if(salamiButton.isSelected())
            pizzaToppings.add(PizzaTopping.SALAMI);
        if(hamButton.isSelected())
            pizzaToppings.add(PizzaTopping.HAM);
        if(ananasButton.isSelected())
            pizzaToppings.add(PizzaTopping.ANANAS);
        if(vegetablesButton.isSelected())
            pizzaToppings.add(PizzaTopping.VEGETABLES);
        if(seafoodButton.isSelected())
            pizzaToppings.add(PizzaTopping.SEAFOOD);
        if(nutellaButton.isSelected())
            pizzaToppings.add(PizzaTopping.NUTELLA);
        if(sourCreamButton.isSelected())
            pizzaToppings.add(PizzaTopping.SOUR_CREAM);

        return pizzaToppings;
    }

    /**
     * the method checks if the introduced date is null or in the future or in the past
     * @return true if the date is a current date until 4 weeks in the future
     */
    public boolean checkDate(){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
            String dateString = txtDate.getText();
            LocalDate dateValue = LocalDate.parse(dateString, formatter);       //convert String to LocalDate
            LocalDate currentDate = LocalDate.now();
            LocalDate next4Week = currentDate.plus(4, ChronoUnit.WEEKS);
            //System.out.println(currentDate);
            //System.out.println(next4Week);
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("H:mm");
            String hourString=txtHour.getText();
            LocalTime timeValue=LocalTime.parse(hourString,formatter2);
            //LocalTime now=LocalTime.now();
            //String currentTimeString=now.format(formatter2);
            //LocalTime currentTime=LocalTime.parse(currentTimeString);

            if(dateValue.isBefore(currentDate))
                { JOptionPane.showMessageDialog(this,"The date is older than current day");
                return false;}
            /*if(timeValue.isBefore(currentTime))
                { JOptionPane.showMessageDialog(this,"The introduce time is older than current one");
                return false;}*/
            if(dateValue.isAfter(next4Week))
                { JOptionPane.showMessageDialog(this,"The date is more than 4 weeks in the future.");
                return false;}
            /*if(timeValue.isAfter(currentTime))
                { JOptionPane.showMessageDialog(this,"The introduce time is in the future");
                return false;}*/

        }catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
             return false;
        }
    return true;
    }


    /**
     * checks if there are topping selected
     * @throws NoToppingSelectedException if there are no toppings selected
     */
    private void noTooping() throws NoToppingSelectedException{
        if(nrTopping==0)
         throw new NoToppingSelectedException("No topping selected.");
    }

    /**
     * opens a new dialog if no toppings were selected
     */
    private void callNoToppingDialog() {
       JOptionPane.showMessageDialog(this,
       "No topping was selected.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
    }

    /**
     * calculates the price of an ordered pizza
     * @return the price of a pizza with toppings
     */
    public int priceCalculator(){
        totalPizzaPrice=pizzaSizePrice*100 + nrTopping*50;
        return totalPizzaPrice;
    }

    /**
     * the method opens a new dialog when the pizza is done
     */
    private void callModalDialog() {

        Object[] options = {"Die Pizza der Bestellung hinzufügen",
                "Zurück zu Pizzakonfiguration"};
        totalPizzaPrice=priceCalculator();
        int result= JOptionPane.showOptionDialog(
                this,
                "Preis: "+totalPizzaPrice+" Cent \n",
                "Pizza",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        switch(result){
            case 0:
                savePizza();
        }

    }
    /*
    public static Order getOrder(){
        return order;
    }
    */

    /**
     * returns the rdered pizzas
     * @return the pizzas of the order
     */
    public static List<Pizza> getPizzas(){
        return pizzas;
    }

    /**
     * the method saves a newly ordered pizza
     */
    private void savePizza(){

        pizza=new Pizza(totalPizzaPrice, pizzaSize, getSelectedPizzaToppings());
        pizzas.add(pizza);

    }


}

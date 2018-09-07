import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//This program allows the user to store a comic conventions event details in a text file, organized by event type

public class EventPlanner {

    /**
     * This method builds the event using the choice for the type of event, the name, date, time, location, cost, and filename
     * @param choice The choice for the event type (Autograph, PhotoOp, Panel, Exclusive, or Other)
     * @param name The name of the person, or place (Artists, Writers, Panel Name, Location name)
     * @param date The date of the event
     * @param time The time of the event
     * @param booth The booth or location of the event
     * @param cost The cost of the event
     * @param fileName The file name that the event will be stored in (Example: nycc.txt for New York Comic Con)
     */
    public static void buildEvent(String choice, String name, String date, String time, String booth, String cost, String fileName){

        //Get the number choice for the type of event
        int typeChoice = Integer.parseInt(choice);

        //String to store the event type
        String eventType;

        //Get the event type based on the choice
        if(typeChoice == 1){
            eventType = "Autograph";
        }
        else if(typeChoice == 2){
            eventType = "PhotoOp";
        }
        else if(typeChoice == 3){
            eventType = "Panel";
        }
        else if(typeChoice == 4){
            eventType = "Exclusive";
        }
        else
            eventType = "Other";

        //Create a new event
        Event newEvent = new Event.Builder(name).date(date).time(time).booth(booth).cost(cost).type(eventType).build();

        //Store the event details into a new or existing file
        try(FileWriter fw = new FileWriter(fileName, true);

            BufferedWriter bw = new BufferedWriter(fw);

            PrintWriter out = new PrintWriter(bw))
        {
            out.println(newEvent.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        //Create the fields for the user input
        JTextField choiceField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JTextField timeField = new JTextField(10);
        JTextField boothField = new JTextField(10);
        JTextField costField = new JTextField(10);
        JTextField fileNameField = new JTextField(10);

        //Create the panel
        JPanel mainPanel = new JPanel();

        //Set the panel layout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        //Display the user instructions
        mainPanel.add(new JLabel("Enter (1)Autograph (2)PhotoOp (3)Panel (4)Exclusive (5)Other:* "));
        mainPanel.add(choiceField);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Enter name:* "));
        mainPanel.add(nameField);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Enter date: "));
        mainPanel.add(dateField);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Enter time: "));
        mainPanel.add(timeField);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Enter location: "));
        mainPanel.add(boothField);
        mainPanel.add(Box.createHorizontalStrut(15));
        mainPanel.add(new JLabel("Enter cost: "));
        mainPanel.add(costField);
        mainPanel.add(new JLabel("Enter new or existing file name: (ex: nycc.txt):* "));
        mainPanel.add(fileNameField);

        //Build the event if the user presses OK
        int result = JOptionPane.showConfirmDialog(null, mainPanel,
                "Please Enter all required information( * indicates required fields): ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            buildEvent(choiceField.getText(), nameField.getText(), dateField.getText(), timeField.getText(), boothField.getText(), costField.getText(), fileNameField.getText());
        }

    }
}

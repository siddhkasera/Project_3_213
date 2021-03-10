package PayrollProcessingApp;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.time.LocalDate;

//<BorderPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/15.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="PayrollProcessingApp.Controller">

public class Controller {

    //bringing in company and employee array
    Company companyDB = new Company();
    DatePicker datePick = new DatePicker();
    LocalDate dateHired = datePick.getValue();
    public static String name;
    public static String deptName;
    public static String dateHiredStr;
    public static double annualSalary;
    public static int role = 0;
   // Employee employee = new Employee();
    Date date = new Date();




    @FXML
    private GridPane gridPaneTab1;

    @FXML
    private TextField nameFieldID;

    @FXML
    private DatePicker DateHiredID;

    @FXML
    private RadioButton fullTimeRadioID;

    @FXML
    private RadioButton managementRadioID;

    @FXML
    private RadioButton partTimeRadioID;

    @FXML
    private TextField salaryFieldID;

    @FXML
    private RadioButton CSRadioID;

    @FXML
    private RadioButton ECERadioID;

    @FXML
    private RadioButton ITRadioID;

    @FXML
    private Button clearButtonID;

    @FXML
    private Button addButtonID;

    @FXML
    private Button removeButtonID;

    @FXML
    private Button setHoursButton;

    @FXML
    private TextField hrsWorkedID;

    @FXML
    private TextField rateFieldID;

    @FXML
    private RadioButton managerRadioID;

    @FXML
    private RadioButton deptHeadRadioID;

    @FXML
    private RadioButton directorRadioID;

    @FXML
    private Button printDeptID;

    @FXML
    private Button printDateID;

    @FXML
    private Button printAllID;

    @FXML
    private MenuBar menuBarDBID;

    @FXML
    private MenuItem closeButtonID;

    @FXML
    private MenuItem importButtonID;

    @FXML
    private MenuItem exportButtonID;




    @FXML
    void add(ActionEvent event) {

        //handle for if the user doesn't input something for all text fields
        //check if date is not in the future
        //QUESTION: can we use isValid() method to check date?
        //QUESTION: does the invalid date error message have to come before or after you press add employee?


        name = nameFieldID.getText();
        dateHiredStr = dateHired.toString(); //formatted in yyyy-mm-dd



        if (fullTimeRadioID.isSelected()) {

            annualSalary = Double.parseDouble(salaryFieldID.getText());

            if (CSRadioID.isSelected()) {
                deptName = CSRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile AFProfile = new Profile(name, deptName, dateHiredStr);
                Fulltime fulltimeEmp = new Fulltime(AFProfile, annualSalary);
                if (AFProfile.getDateHired().isValid()) {
                    companyDB.add(fulltimeEmp);
                }
            } else if (ITRadioID.isSelected()) {
                deptName = CSRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile AFProfile = new Profile(name, deptName, dateHiredStr);
                Fulltime fulltimeEmp = new Fulltime(AFProfile, annualSalary);
                if (AFProfile.getDateHired().isValid()) {
                    companyDB.add(fulltimeEmp);
                }
            } else if (ECERadioID.isSelected()) {
                deptName = CSRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile AFProfile = new Profile(name, deptName, dateHiredStr);
                Fulltime fulltimeEmp = new Fulltime(AFProfile, annualSalary);
                if (AFProfile.getDateHired().isValid()) {
                    companyDB.add(fulltimeEmp);
                }
                else{

                }

            }
        }

        if (partTimeRadioID.isSelected()) {

            double hourlyPay = Double.parseDouble(rateFieldID.getText());

            if (CSRadioID.isSelected()) {
                deptName = CSRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile APProfile = new Profile(name, deptName, dateHiredStr);
                Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
                if (hourlyPay < 0) {
                } else if (APProfile.getDateHired().isValid()) {
                    if (companyDB.add(parttimeEmp)) {
                        //print that the employee is added in textarea

                    } else {
                        //print employee is already in the list
                    }
                } else {
                    //print what is below but in text area
                    //System.out.println(parttimeEmp.getProfile().getDateHired().getMonth() + "/" + parttimeEmp.getProfile().getDateHired().getDay() + "/" +
                    // parttimeEmp.getProfile().getDateHired().getYear() + " is not a valid date!");
                }
            } else if (ITRadioID.isSelected()) {
                deptName = ITRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile APProfile = new Profile(name, deptName, dateHiredStr);
                Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
                if (hourlyPay < 0) {
                } else if (APProfile.getDateHired().isValid()) {
                    if (companyDB.add(parttimeEmp)) {
                        //print that the employee is added in textarea

                    } else {
                        //print employee is already in the list
                    }
                } else {
                    //print what is below but in text area
                    //System.out.println(parttimeEmp.getProfile().getDateHired().getMonth() + "/" + parttimeEmp.getProfile().getDateHired().getDay() + "/" +
                    // parttimeEmp.getProfile().getDateHired().getYear() + " is not a valid date!");
                }

            } else if (ECERadioID.isSelected()) {
                deptName = ECERadioID.getText(); //finding CSRadioButton label name and set that to deptname
                Profile APProfile = new Profile(name, deptName, dateHiredStr);
                Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);

                if (hourlyPay < 0) {
                } else if (APProfile.getDateHired().isValid()) {
                    if (companyDB.add(parttimeEmp)) {
                        //print that the employee is added in textarea

                    } else {
                        //print employee is already in the list
                    }
                } else {
                    //print what is below but in text area
                    //System.out.println(parttimeEmp.getProfile().getDateHired().getMonth() + "/" + parttimeEmp.getProfile().getDateHired().getDay() + "/" +
                    // parttimeEmp.getProfile().getDateHired().getYear() + " is not a valid date!");
                }
            }

        }

        else if(managementRadioID.isSelected()) {

            annualSalary = Double.parseDouble(salaryFieldID.getText());

            if (CSRadioID.isSelected()){
                deptName = CSRadioID.getText(); //finding CSRadioButton label name and set that to deptname
                //you can also change role to String in constructor and getText for which role it is.. compare it in constructor
                Profile AMProfile = new Profile(name, deptName, dateHiredStr);
                Management mngmntEmp = new Management(AMProfile, annualSalary, role);

            }

        }

    }

    @FXML
    void clear(ActionEvent event) {
        managementRadioID.setDisable(false);

    }

    @FXML
    void printAll(ActionEvent event) {

    }

    @FXML
    void printByDate(ActionEvent event) {

    }

    @FXML
    void printByDept(ActionEvent event) {

    }

    @FXML
    void remove(ActionEvent event) {

    }
/*
    @FXML
    void (ActionEvent event){


    }
*/
    @FXML
    void setHours(ActionEvent event) {

    }

    @FXML
    void setCS(MouseEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void importDB(ActionEvent event){
        FileChooser chooser = new FileChooser();
        Label newLabel = new Label();
        chooser.setTitle("Open Source File for the import");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files","*.txt"),
        new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File sourceFile =  chooser.showOpenDialog(stage);
        String fileName = sourceFile.getAbsolutePath();
        String command = "";
        //System.out.println("the file path  is "+ fileName);

        try {
            File dbName = new File(fileName);
            Scanner readFile = new Scanner(dbName);
            while(readFile.hasNextLine()){
                String data = readFile.nextLine();
                String [] arrOfStr = data.split(",");
                command = arrOfStr[0];
               // System.out.println("Command is:"+ command);
                switch(command) {
                    case "P": //handling command add for parttime
                        name = arrOfStr[1];
                        deptName = arrOfStr[2];
                        dateHiredStr = arrOfStr[3];
                        Double hourlyPay = Double.parseDouble(arrOfStr[4]);
                        Profile APProfile = new Profile(name, deptName, dateHiredStr);
                        Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
                        companyDB.add(parttimeEmp);
                    case "F": //handling command add for full time
                        name = arrOfStr[1];
                        deptName = arrOfStr[2];
                        dateHiredStr = arrOfStr[3];
                        annualSalary = Double.parseDouble(arrOfStr[4]);
                        Profile AFProfile = new Profile(name, deptName, dateHiredStr);
                        Fulltime fulltimeEmp = new Fulltime(AFProfile, annualSalary);
                        companyDB.add(fulltimeEmp);
                    case "M": //handling command add for management
                        name = arrOfStr[1];
                        deptName = arrOfStr[2];
                        dateHiredStr = arrOfStr[3];
                        if (arrOfStr.length > 5){
                            annualSalary = Double.parseDouble(arrOfStr[4]);
                            role = Integer.parseInt(arrOfStr[5]);
                         }
                        Profile AMProfile = new Profile(name, deptName, dateHiredStr);
                        Management mngmntEmp = new Management(AMProfile, annualSalary, role);
                        companyDB.add(mngmntEmp);
                }
                //System.out.println("The company db is");

                //System.out.println("the line in the file is:"+data);
            }
            //companyDB.print();
            readFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("The error message is" + e.getMessage());
            e.printStackTrace();
        }


    }

    @FXML
    void exportDB(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        FileChooser chooser = new FileChooser();
        Label newLabel = new Label();
        chooser.setTitle("Open Source File for the import");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files","*.txt"),
                new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile =  chooser.showSaveDialog(stage);
        String targetName = targetFile.getAbsolutePath();
        System.out.println(targetName);
        System.out.println(targetFile.getName());
        PrintWriter writer = new PrintWriter(targetFile.getName(), "UTF-8");
        writer.println("the first line");



    }


    @FXML
    void setDate(MouseEvent event) {

    }

    @FXML
    void setManager(MouseEvent event) {

        role = 1;

    }

    @FXML
    void setDepartmentHead(MouseEvent event) {


        role = 2;
    }

    @FXML
    void setDirector(MouseEvent event) {

        role = 3;
    }

    @FXML
    void setECE(MouseEvent event) {

    }


    @FXML
    void setFullTime(MouseEvent event) {

        hrsWorkedID.setDisable(true);
        rateFieldID.setDisable(true);
        setHoursButton.setDisable(true);
        managementRadioID.setDisable(false);

        directorRadioID.setDisable(true);
        deptHeadRadioID.setDisable(true);
        managerRadioID.setDisable(true);
        salaryFieldID.setDisable(false);

    }

    @FXML
    void setIT(MouseEvent event) {

    }

    @FXML
    void setManagement(MouseEvent event) {


        rateFieldID.setDisable(true);
        hrsWorkedID.setDisable(true);
        setHoursButton.setDisable(true);
        managementRadioID.setDisable(false);
        managerRadioID.setDisable(false);
        directorRadioID.setDisable(false);
        deptHeadRadioID.setDisable(false);
        salaryFieldID.setDisable(false);

    }



    @FXML
    void setPartTime(MouseEvent event) {

        rateFieldID.setDisable(false);
        hrsWorkedID.setDisable(false);
        setHoursButton.setDisable(false);
        managementRadioID.setDisable(false);
        managerRadioID.setDisable(true);
        directorRadioID.setDisable(true);
        deptHeadRadioID.setDisable(true);
        salaryFieldID.setDisable(true);

    }


    //idk how to use this yet but I think it is how appending the strings will work
    StringBuilder str = new StringBuilder();


}

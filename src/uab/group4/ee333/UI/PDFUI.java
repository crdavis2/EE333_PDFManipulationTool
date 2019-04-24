/*
 * File: PDFToImage.java
 * Author: Caleb Crocker   caleb98@uab.edu
 * Author: Collin Davis    crdavis2@uab.edu
 * Author: Anthony Lee     atlee974@uab.edu
 * Author: Yasmin Sakalla  sakalyas@uab.edu
 * Assignment:  EE333GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 04/17/2019 CLC - initial coding
 *
 */

package uab.group4.ee333.UI;

// jfx imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import uab.group4.ee333.Merge;
import uab.group4.ee333.Split;

/**
 *
 * @author Caleb Crocker   caleb98@uab.edu
 * @author Collin Davis    crdavis2@uab.ed
 * @author Anthony Lee     atlee974@uab.edu
 * @author Yasmin Sakalla  sakalyas@uab.edu
 */
public class PDFUI extends Application {
    // GUI Elements
    private ComboBox<String> functionBox;
    private ComboBox<String> splitOption;
    private TextField        fileField;
    private TextField        splitStartField;
    private TextField        splitEndField;
    private TextField        firstFileField;
    private TextField        secondFileField;
    private TextField        mergedFileNameField;
    private Label            fileLabel;
    private Label            splitLabel;
    private Label            startPageLabel;
    private Label            endPageLabel;
    private Label            firstFileLabel;
    private Label            secondFileLabel;
    private Label            mergeOption;
    private Label            mergedFileNameLabel;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("PDF Editor");

        VBox mainVBox = new VBox(20);

        // Function Selector //
        HBox functionHBox = new HBox(10);
        
        Label functionLabel = new Label("Function");
        functionBox         = new ComboBox<>();
        functionBox.getItems().addAll("Split", "Merge", "PDF to Image", "Text t"
            + "o PDF", "Print");
        functionBox.setOnAction(event -> functionSelect());
        
        functionHBox.getChildren().addAll(functionLabel, functionBox);
        
        // File Input Field //
        HBox fileInputHBox = new HBox(10);
        
        fileLabel = new Label("File");
        fileLabel.setVisible(false);
        fileField       = new TextField();
        fileField.setVisible(false);
        
        fileInputHBox.getChildren().addAll(fileLabel, fileField);
/////////////////////////////////////////////////////////////////////////////////        
        // Split Option //
        HBox splitHBox        = new HBox(10);
        VBox splitOptionVBox  = new VBox(10);
        VBox startPageVBox    = new VBox(10);
        VBox endPageVBox      = new VBox(10);
        VBox pagesPerSplitBox = new VBox(10);
        
        splitLabel  = new Label("Split");
        splitLabel.setVisible(false);
        splitOption = new ComboBox<>();
        splitOption.setVisible(false);
        splitOption.getItems().addAll("Start/End", "Pages per Split");
        splitOption.setOnAction(event -> splitSelected());
        splitOptionVBox.getChildren().addAll(splitLabel, splitOption);
        
        startPageLabel = new Label("Start Page");
        startPageLabel.setVisible(false);
        splitStartField = new TextField();
        splitStartField.setVisible(false);
        startPageVBox.getChildren().addAll(startPageLabel, splitStartField);
        
        endPageLabel   = new Label("End Page");
        endPageLabel.setVisible(false);
        splitEndField = new TextField();
        splitEndField.setVisible(false);
        endPageVBox.getChildren().addAll(endPageLabel, splitEndField);
        
        splitHBox.getChildren().addAll(splitOptionVBox, startPageVBox, 
                                       endPageVBox, pagesPerSplitBox);
/////////////////////////////////////////////////////////////////////////////////
        // Merge Option //
        VBox mergeVBox     = new VBox(10);
        HBox firstFileBox  = new HBox(10);
        HBox secondFileBox = new HBox(10);
        HBox mergedDocBox  = new HBox(10);
        
        mergeOption  = new Label("Merge");
        mergeOption.setVisible(false);
        
        firstFileLabel = new Label("First File");
        firstFileLabel.setVisible(false);
        firstFileField = new TextField();
        firstFileField.setVisible(false);
        firstFileBox.getChildren().addAll(firstFileLabel, firstFileField);
        
        secondFileLabel = new Label("Second File");
        secondFileLabel.setVisible(false);
        secondFileField = new TextField();
        secondFileField.setVisible(false);
        secondFileBox.getChildren().setAll(secondFileLabel, secondFileField);
        
        mergedFileNameLabel = new Label("Merged File Name");
        mergedFileNameLabel.setVisible(false);
        mergedFileNameField = new TextField();
        mergedFileNameField.setVisible(false);
        mergedDocBox.getChildren().addAll(mergedFileNameLabel, 
                                          mergedFileNameField);
        
        mergeVBox.getChildren().addAll(mergeOption, firstFileBox, secondFileBox,
                                       mergedDocBox);
        
/////////////////////////////////////////////////////////////////////////////////        
        // GO Button //
        HBox footerHBox = new HBox(250);
        Button goButton = new Button("GO");
        goButton.setOnAction(event -> goButtonClicked());
        Label groupNameLabel = new Label("Created by Group 4: Caleb Crocker, "
                + "Collin Davis, Anthony Lee, Yasmin Sakalla");
        footerHBox.getChildren().addAll(goButton, groupNameLabel);
        
        mainVBox.getChildren().addAll(functionHBox, fileInputHBox, splitHBox, 
                                      mergeVBox, footerHBox);
        
        Scene scene = new Scene(mainVBox);
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void functionSelect() {
        String function = functionBox.getValue();
        if (function.equals("Split")) {
            // Setting other options to invisible
            mergeOption.setVisible(false);
            firstFileLabel.setVisible(false);
            firstFileField.setVisible(false);
            secondFileLabel.setVisible(false);
            secondFileField.setVisible(false);
            mergedFileNameLabel.setVisible(false);
            mergedFileNameField.setVisible(false);
            // Setting Split to visible
            fileLabel.setVisible(true);
            fileField.setVisible(true);
            splitLabel.setVisible(true);
            splitOption.setVisible(true);       
        } else if (function.equals("Merge")) {
            // Resetting other options to invisible
            fileLabel.setVisible(false);
            fileField.setVisible(false);
            splitLabel.setVisible(false);
            splitOption.setVisible(false);
            startPageLabel.setVisible(false);
            endPageLabel.setVisible(false);
            splitStartField.setVisible(false);
            splitEndField.setVisible(false);
            // Setting Merge to visible
            mergeOption.setVisible(true);
            firstFileLabel.setVisible(true);
            firstFileField.setVisible(true);
            secondFileLabel.setVisible(true);
            secondFileField.setVisible(true);
            mergedFileNameLabel.setVisible(true);
            mergedFileNameField.setVisible(true);
        }
    }
    
    private void splitSelected() {
        String option = splitOption.getValue();
        splitLabel.setVisible(true);
        if (option.equals("Start/End")) {
            // Show Label and Boxes for start/end page
            startPageLabel.setText("Start Page");
            startPageLabel.setVisible(true);
            endPageLabel.setVisible(true);
            splitStartField.setVisible(true);
            splitEndField.setVisible(true);
        } else {
            // Pages per Split selected
            startPageLabel.setText("Pages per Split");
            startPageLabel.setVisible(true);
            endPageLabel.setVisible(false);
            splitStartField.setVisible(true);
            splitEndField.setVisible(false);
            
        }
    }
    
    private void goButtonClicked() {
        String[] args;
        String function = functionBox.getValue();
        String filePath = fileField.getText();
        
        if (function.equals("Split")) {
            String splitOptionString = splitOption.getValue();
            if (splitOptionString.equals("Start/End")) {
                String startPage = splitStartField.getText();
                String endPage   = splitEndField.getText();
                args = new String [] {filePath, splitOptionString, startPage, 
                                      endPage};        
                } else {
                // Pages per Split
                String pagesPerSplit = splitStartField.getText();
                args = new String [] {filePath, splitOptionString, pagesPerSplit};
            }
            Split.main(args);
        } else if (function.equals("Merge")) {
            String firstFile  = firstFileField.getText();
            String secondFile = secondFileField.getText();
            String mergedFileName = mergedFileNameField.getText();
            args = new String [] {firstFile, secondFile, mergedFileName};
            Merge.main(args);
        }        
        
    }
}

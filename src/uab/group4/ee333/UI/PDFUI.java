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

// main function for the tool
// import uab.group4.ee333.PDFManipulator;

// jfx imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Caleb Crocker   caleb98@uab.edu
 * @author Collin Davis    crdavis2@uab.ed
 * @author Anthony Lee     atlee974@uab.edu
 * @author Yasmin Sakalla  sakalyas@uab.edu
 */
public class PDFUI extends Application {
    private ComboBox functionBox;
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("PDF Editor");
        
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Scene scene=new Scene(grid);
        
        grid.add(new Label("Function"), 0, 0);
        functionBox=new ComboBox();
        functionBox.getItems().addAll("Split", "Merge", "PDF to Image", "Text t"
            + "o PDF", "Print");
        
        grid.add(functionBox, 1, 0);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
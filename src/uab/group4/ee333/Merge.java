/*
 * File: Merge.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  EE333GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 03/25/2019 CRD - initial coding
 *
 */

package uab.group4.ee333;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;

/**
 *
 * @author Caleb Crocker   caleb98@uab.edu
 * @author Collin Davis    crdavis2@uab.ed
 * @author Anthony Lee     atlee974@uab.edu
 * @author Yasmin Sakalla  sakalyas@uab.edu
 * 
 * Merge class appends one PDF to the end of another
 */
public class Merge {
    public static void main(String[] args) {
    File file1 = new File(args[0]);
    File file2 = new File(args[1]);
    
    PDFMergerUtility PDFMerger = new PDFMergerUtility(); 
    PDFMerger.setDestinationFileName("/Users/crdavis2/CoolBeansProjects/"
            + "EE333GroupProject/" + args[2] +".pdf");
    
    try {
        PDDocument document1 = PDDocument.load(file1);
        PDDocument document2 = PDDocument.load(file2);
        PDFMerger.addSource(file1);
        PDFMerger.addSource(file2);
        PDFMerger.mergeDocuments(null);
        document1.close();
        document2.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    }
}

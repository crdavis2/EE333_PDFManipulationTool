/*
 * File: PDFToImage.java
 * Author: Caleb Crocker   caleb98@uab.edu
 * Author: Collin Davis    crdavis2@uab.edu
 * Author: Anthony Lee     atlee974@uab.edu
 * Author: Yasmin Sakalla  sakalyas@uab.edu
 * Assignment:  EE333GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 03/24/2019 CRD - initial coding
 *
 */

package uab.group4.ee333;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.util.List;
import java.io.File;
import java.util.Iterator;

/**
 *
 * @author Caleb Crocker   caleb98@uab.edu
 * @author Collin Davis    crdavis2@uab.ed
 * @author Anthony Lee     atlee974@uab.edu
 * @author Yasmin Sakalla  sakalyas@uab.edu
 */
public class Split {
    public static void main(String[] args) {
        
        String filePath = args[0];
        File pdf = new File(filePath);
        Splitter splitter = new Splitter();
        
        
        if (args[1].equals("Start/End")) {
            int startPage = Integer.parseInt(args[2]);
            int endPage   = Integer.parseInt(args[3]);
            splitter.setStartPage(startPage);
            splitter.setEndPage(endPage);
            splitter.setSplitAtPage(endPage);
            
            try {
                PDDocument document = PDDocument.load(pdf);
                List<PDDocument> newDocs = splitter.split(document);
                Iterator<PDDocument> iterator = newDocs.listIterator();
                int i = 1;
                while(iterator.hasNext()) {
                   PDDocument pd = iterator.next();
                   pd.save("/Users/crdavis2/CoolBeansProjects/EE333GroupProject/"
                           + "sample"
                           + i++ +".pdf");
                   document.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[1].equals("Pages per Split")) {
            int numPagesPerSplit = Integer.parseInt(args[2]);
            splitter.setSplitAtPage(numPagesPerSplit);
            PDDocument document = new PDDocument();
            try {
                document = PDDocument.load(pdf);
                List<PDDocument> newDocs = splitter.split(document);
                Iterator<PDDocument> iterator = newDocs.listIterator();
                int i = 1;
                while(iterator.hasNext()) {
                   PDDocument pd = iterator.next();
                   pd.save("/Users/crdavis2/CoolBeansProjects/EE333GroupProject/"
                           + "sample"
                           + i++ +".pdf");
                   
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try {
            document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
            
    }
}


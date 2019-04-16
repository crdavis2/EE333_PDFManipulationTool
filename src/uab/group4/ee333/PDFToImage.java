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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Caleb Crocker   caleb98@uab.edu
 * @author Collin Davis    crdavis2@uab.ed
 * @author Anthony Lee     atlee974@uab.edu
 * @author Yasmin Sakalla  sakalyas@uab.edu
 */
public class PDFToImage {

    private static final String OUTPUT_DIR = "/tmp/";

    public static void main(String[] args) throws Exception{

        try (final PDDocument document = PDDocument.load(new File("/tmp/bookmark.pdf"))){
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                String fileName = OUTPUT_DIR + "image-" + page + ".png";
                ImageIOUtil.writeImage(bim, fileName, 300);
            }
            document.close();
        } catch (IOException e){
            System.err.println("Exception while trying to create pdf document - " + e);
        }
    }

}
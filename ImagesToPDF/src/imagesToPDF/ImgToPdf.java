package imagesToPDF;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

class PdfImages{
	/***
	 * 
	 * @param folderPath(String) -- from which directory you want to read all images ? 
	 * @param destFileName(String) -- what should be your filename ? eg:- mynewpdf
	 * @param shufflingImages(boolean) -- if true,your images from the folder will be in any order in final pdf file
	 * if false, then make sure your folder have all the images in the order eg:- 1.jpeg , 2.jpeg , 3.jpeg and so on.
	 * @param imageExtension(String) -- specify the extension of your files eg:- ".jpeg"
	 * @throws IOException
	 */
	
	public void convertImgToPDF(String folderPath,String destFileName,boolean shufflingImages,String imageExtension) throws IOException {
		final int FOLDER_LENGTH=new File(folderPath).list().length;
		List<String> fileNames= Arrays.asList(new File(folderPath).list());
        PDDocument document = new PDDocument();
        int curPage=1;
        String imagePath="";
        if(shufflingImages) {
        	for(String filename:fileNames) {
        		imagePath=folderPath+"\\"+filename; // change the extension as per requirements
                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                PDImageXObject img = PDImageXObject.createFromFile(imagePath, document);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
               // float scale = 1f; // no need to scale
                contentStream.drawImage(img, 0,0,595,842); // 595-width,842-height its a typical a4 size format
                contentStream.close();
                curPage+=1;
        	}
        }
        else {
            while(curPage<=FOLDER_LENGTH) {
            	imagePath=folderPath+"\\"+curPage+imageExtension; // change the extension as per requirements
                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                PDImageXObject img = PDImageXObject.createFromFile(imagePath, document);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
               // float scale = 1f; // no need to scale
                contentStream.drawImage(img, 0,0,595,842); // 595-width,842-height its a typical a4 size format
                contentStream.close();
                curPage+=1;
            }
        }
        document.save(""+destFileName+".pdf");
        document.close();
        System.out.println("File succesfully created in the below directory");
        System.out.println(System.getProperty("user.dir")+"\\"+destFileName+".pdf");
    }
}
public class ImgToPdf {
	public static void main(String args[]) throws IOException {
		new PdfImages().convertImgToPDF("E:\\Oracle\\Java SE 11 Programming Complete Ed 2 (Student Guide)","oraclePdf",false,".jpeg");
	}
}

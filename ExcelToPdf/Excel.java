package excelsheet;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
public class Excel{
	public static void main(String[] args) {
		ExcelRead r=new ExcelRead();
		r.readExcel();
	}
}
class ExcelRead{
	void readExcel() {
		//C:\\Users\\vc\\eclipse-workspace\\DemoDay1\\final.xls
			
//		Workbook w;
		try {
			File obj=new File("final.xls");
//			System.out.println(obj.getName());
		if (!obj.exists()) {
				throw new RuntimeException("Unable to find the file : " +obj);
			}
			Workbook wrk1 = Workbook.getWorkbook(obj);
			
			Sheet sheet =wrk1.getSheet(0);
			
			
			
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream("One.pdf"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(2);
			
			Paragraph preface = new Paragraph();
	        // We add one empty line
	      
	        // Lets write a big header
	       //preface.add("               ");
	       preface.add("Invoice of The Purchase");
	       document.add( Chunk.NEWLINE );
	       preface.setAlignment(Element.ALIGN_CENTER);
	       
	        document.add(preface);
	        
	        
	        
	        Paragraph p3=new Paragraph();
	        p3.add("Shipping Address\nSarath\nvijayamangalam");
	        p3.setAlignment(Element.ALIGN_RIGHT);

	        
	        Paragraph preface1 = new Paragraph();
	        preface1.add("Billing Address\nSarath\nvijayamangalam");

		    document.add(preface1);
		    document.add( Chunk.NEWLINE );
		       
		    document.add(p3);
		    document.add( Chunk.NEWLINE );   
		       
		       
		       
			int columns = sheet.getColumns();
			int rows = sheet.getRows();
			int total=0;
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {	
					Cell c=sheet.getCell(j,i);
					String values = c.getContents().trim();
						System.out.println(values+":"+i+"="+j);
						if(j==1) {
							total=total+Integer.parseInt(values);
						}
						
						PdfPCell header = new PdfPCell();
						Phrase phr = new Phrase();
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setBorderWidth(1);
						phr.add(values);
						header.setPhrase(phr);
						table.addCell(header);
					
				}
			}
			Paragraph s=new Paragraph();
			s.add("Total:"+total);
			s.setAlignment(Element.ALIGN_RIGHT);
			System.out.println(total);
			System.out.println(table);
			document.add(table);
			document.add(s);
			document.addAuthor("sartah");
			document.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}

}

//C:\Users\vc\Desktop\TestProject.xlsx
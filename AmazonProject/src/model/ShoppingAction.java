package model;

import java.io.FileOutputStream;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BillPackage.BillDAO;
import BillPackage.BillDAOImpl;
import BillingItem.BillItemDAO;
import BillingItem.BillItemDAOImpl;
import ItemPackage.ItemBusinessImpl;
import ItemPackage.ItemDTO;
///Users/sarath/eclipse/jee-2020-12/Eclipse.app/Contents/MacOS
public class ShoppingAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ItemDTO Idto=(ItemDTO)session.getAttribute("Items");
		int id[]=Idto.getItemId();
		String itemsq[]=Idto.getItemDescription();
		int price[]=Idto.getPrice();
		BillItemDAO BDAO=new BillItemDAOImpl();
		
		BillDAO DAO=new BillDAOImpl();
		int BillNo=DAO.BillNo()+1;
		System.out.println(DAO.BillNo());
		System.out.println("Billno"+BillNo);
		
		System.out.println(session.getAttribute("CustomerMobile"));
		String Mobile=session.getAttribute("CustomerMobile").toString();
		System.out.println(DAO.CreateBill(BillNo, Mobile));
		session.removeAttribute("Items");
		int amounttopaid=0;
		
		
		try{
			   String executionPath = System.getProperty("user.dir");
			   System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
			  }
		catch (Exception e){
			   System.out.println("Exception caught ="+e.getMessage());
			  }

		Document document = new Document();
		
		try {
		
			PdfWriter.getInstance(document, new FileOutputStream(BillNo+".pdf"));
			document.open();
			System.out.println("pdf started");
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(3);
			
			Paragraph preface = new Paragraph();
			preface.add("Invoice of The Purchase");
		    document.add( Chunk.NEWLINE );
		    preface.setAlignment(Element.ALIGN_CENTER); 
		    document.add(preface);
			
		    Paragraph preface1 = new Paragraph();
	        preface1.add("Billno:");
	        preface1.add(BillNo+"");
		    document.add(preface1);
		    document.add( Chunk.NEWLINE );
		    
		    Paragraph preface2 = new Paragraph();
	        preface2.add("CustomerName:");
	        preface2.add(session.getAttribute("CustomerName").toString());
		    document.add(preface2);
		    document.add( Chunk.NEWLINE );
		    
		    Paragraph preface3 = new Paragraph();
	        preface3.add("CustomerMobile:");
	        preface3.add(session.getAttribute("CustomerMobile").toString());
		    document.add(preface3);
		    document.add( Chunk.NEWLINE );

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Enumeration<String> en=request.getParameterNames();
		int i=0;
			while(en.hasMoreElements()) {
				String name=en.nextElement();
				System.out.println(name);
				for(int is=0;is<id.length;is++) {
					if(request.getParameter(id[is]+"")!=null && name.equals(id[is]+"") ) {
						PdfPTable table = new PdfPTable(3);
						PdfPCell header = new PdfPCell();
						
						String item=request.getParameter(id[is]+"");
						int quantity=Integer.parseInt(request.getParameter(itemsq[is]));
						System.out.println(item+":"+(quantity*price[is]));
						int total=quantity*price[is];
						amounttopaid+=total;
						BDAO.insertBillItem(BillNo, id[is], quantity);
						
						Phrase phr = new Phrase();
						phr.add(id[is]+"");
						header.setPhrase(phr);
						table.addCell(header);
						
						Phrase phr1 = new Phrase();
						phr1.add(item);
						header.setPhrase(phr1);
						table.addCell(header);
						
						Phrase phr2 = new Phrase();
						phr2.add(total+"");
						header.setPhrase(phr2);
						table.addCell(header);
						
						try {
							document.add(table);
							
						} catch (DocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session.setAttribute(item+":",total+"");
						session.removeAttribute(id[is]+"");
						session.removeAttribute(itemsq[is]);
					}	
				}
				
			}
			   Paragraph preface1 = new Paragraph();
		        preface1.add("TotalAmount:");
		        preface1.add(amounttopaid+"");
			    try {
					document.add(preface1);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			session.setAttribute("TotalAmount",amounttopaid);
		    System.out.println("pdf closed");
		    document.close();
		return "invoice";
	}
}

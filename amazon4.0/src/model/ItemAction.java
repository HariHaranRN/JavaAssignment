package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ItemPackage.ArraytemDTO;
import ItemPackage.ItemBusinessImpl;
import ItemPackage.ItemDTO;

public class ItemAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Item actions");
		HttpSession session=request.getSession();
		ItemBusinessImpl ss=new ItemBusinessImpl();
		ArraytemDTO v=ss.getItems();

		session.setAttribute("Items",v);
		
		return "item.success";
	}
}

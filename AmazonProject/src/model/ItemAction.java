package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ItemPackage.ItemBusinessImpl;
import ItemPackage.ItemDTO;

public class ItemAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Item actions");
		HttpSession session=request.getSession();
		ItemBusinessImpl ss=new ItemBusinessImpl();
		ItemDTO v=ss.getItems();
		String a[]=v.getItemImage();
		System.out.println("ItemImage"+a[0]);
		session.setAttribute("Items",v);
		
		return "item.success";
	}
}

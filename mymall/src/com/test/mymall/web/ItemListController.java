package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;

@WebServlet("/itemList")
public class ItemListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController.doGet()");
		ItemService itemService = new ItemService();
		System.out.println(itemService + " <- 컨트롤러 서비스 itemList");
		ArrayList<Item> itemList = itemService.selectItemService();
		System.out.println(itemList + " <- 어레이리스트 itemList");
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}
}

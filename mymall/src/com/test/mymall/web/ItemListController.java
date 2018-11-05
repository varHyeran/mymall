package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;

@WebServlet("/itemList")
public class ItemListController extends HttpServlet {
	// 상품리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController.doGet()");

		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		ItemService itemService = new ItemService();
		HashMap<String, Object> map = itemService.itemPage(currentPage);
		ArrayList<Item> itemList = itemService.selectItemService(map);
		int lastPage = (int)map.get("lastPage");
		request.setAttribute("itemList", itemList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}
}
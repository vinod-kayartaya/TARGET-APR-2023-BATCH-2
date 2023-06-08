package com.targetindia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.targetindia.dao.ProductDao;

@Controller
public class ProductController {

	@Autowired
	ProductDao dao;
	
	@RequestMapping("/product-list")
	public ModelAndView handleProductListRequest() {
		return new ModelAndView("/WEB-INF/show-products.jsp", "products", dao.getAllProducts());
	}
}

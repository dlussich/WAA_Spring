package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.service.ProductService;

@Controller	
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
}

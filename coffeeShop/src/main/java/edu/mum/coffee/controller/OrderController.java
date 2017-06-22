package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping(value="/user")
public class OrderController {

	@Autowired
	public OrderService orderService;
	@Autowired
	public ProductService productService;
	
	
	@GetMapping("/order/{productId}/{quantity}")
	public String add(HttpServletRequest request,Model model,@PathVariable int productId,@PathVariable int quantity){
		List<Orderline> list;
		Product product=productService.getProduct(productId);
		Orderline ol=new Orderline();
		ol.setProduct(product);
		ol.setQuantity(quantity);
		if(request.getSession().getAttribute("list")==null){
			
		}
		return "";
	}
	
	
}

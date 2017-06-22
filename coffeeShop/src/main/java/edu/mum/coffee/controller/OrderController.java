package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	public OrderService orderService;
	@Autowired
	public ProductService productService;
	@Autowired
	public PersonService personService;
	
	@GetMapping("/user/order")
	public String order(Model model, HttpServletRequest request){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		List<Person> person=personService.getPersonByEmail(email);
		request.getSession().setAttribute("user",person.get(0));
		request.getSession().setAttribute("orderlines",null);
		model.addAttribute("products",productService.getAllProduct());
		return "order";
	}
	
	@PostMapping("/user/orderline")
	public String add(Person user,HttpServletRequest request,Model model,@RequestParam("productId") int productId,@RequestParam("quantity") int quantity){
		List<Orderline> orderlines;
		Product product=productService.getProduct(productId);
		Orderline ol=new Orderline();
		ol.setProduct(product);
		ol.setQuantity(quantity);
		if(request.getSession().getAttribute("orderlines")==null){
			orderlines=new ArrayList<>();
			orderlines.add(ol);
		}else{
			orderlines=(List)request.getSession().getAttribute("orderlines");
			orderlines.add(ol);
			
		}
		request.getSession().setAttribute("orderlines", orderlines);
		model.addAttribute("products",productService.getAllProduct());
		return "order";
	}
	
	@PostMapping("/user/order")
	public String add(HttpServletRequest request,Model model){
		List<Orderline> orderlines;
		if(request.getSession().getAttribute("orderlines")!=null){
			orderlines=(List)request.getSession().getAttribute("orderlines");	
		}else{
			orderlines=new ArrayList<>();
		}
		Order order=new Order();
		order.setOrderDate(new Date());
		order.setPerson((Person)request.getSession().getAttribute("user"));
		for(Orderline ol: orderlines){
			ol.setOrder(order);
			order.addOrderLine(ol);
		}
		request.getSession().setAttribute("orderlines", orderlines);
		model.addAttribute("order",order);
		orderService.save(order);
		return "orderDetail";
	}	
}

package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;

@Controller
@RequestMapping("/admin")
public class ManagerController {
	
	@Autowired
	public OrderService orderService; 
	
	@GetMapping()
	public String adminPage(Model model) {
		return "admin";
	}
	
	@GetMapping(value="/orders")
	public String getOrders(Model model){
		 model.addAttribute("orders",orderService.findAll());
		 return "orders";
	}
	
	@GetMapping(value="/orders/product/{id}")
	public List<Order> getOrdersByProduct(Product product) {
		return orderService.findByProduct(product);
	}
	
	public List<Order> getOrdersByPerson(Person person) {
		return orderService.findByPerson(person);
	}

	public List<Order> getOrdersByDate(Date minDate, Date maxDate) {
		return orderService.findByDate(minDate, maxDate);
	}

}

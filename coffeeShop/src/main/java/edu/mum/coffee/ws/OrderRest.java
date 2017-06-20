package edu.mum.coffee.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping("/orders")
public class OrderRest {

	@Autowired
	public OrderService orderService;
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public PersonService personService;
	
	@GetMapping()
	public List<Order> getAll(){
		return orderService.findAll();
	}
	
	@PostMapping()
	public Order createOrder(@RequestBody Order order){
		return orderService.save(order);
	}

	@GetMapping(value="/{id}")
	public Order getOrder(@PathVariable int id){
		return orderService.findById(id);
	}

}

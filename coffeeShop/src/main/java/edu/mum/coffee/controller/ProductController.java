package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller	
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@GetMapping("/products")
	public String getProducts(Model model){
		model.addAttribute("products",productService.getAllProduct());
		return "productList";
	}
	
	@GetMapping("/addProduct")
	public String addProduct(Model model){
		return "addProduct";
	}
	
	@PostMapping(value="/products/delete/{id}")
	public String deleteProduct(@PathVariable int id){
		Product product=productService.getProduct(id);
		productService.delete(product);
		return "redirect:/admin/products";
	}
	
	@GetMapping(value="/products/{id}")
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.getProduct(id));
		return "productDetail";
	}
	
	@PostMapping(value="/products/{id}")
	public String update(Product product, @PathVariable int id) {
		Product objProduct = productService.getProduct(id);
		objProduct.setDescription(product.getDescription());
		objProduct.setProductName(product.getProductName());
		objProduct.setPrice(product.getPrice());
		objProduct.setProductType(product.getProductType());
		productService.save(objProduct);
		return "redirect:/admin/products";
	}
	
	@PostMapping(value="/products")
	public String addProduct(Product product){
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	
}

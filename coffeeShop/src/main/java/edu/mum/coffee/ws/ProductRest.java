package edu.mum.coffee.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRest {
	
	@Autowired
	public ProductService productService;
	
	@GetMapping()
	public @ResponseBody List<Product> getProducts() {
		return  productService.getAllProduct() ;
	}
	
	@PostMapping()
	public Product createProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@PostMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		Product product=productService.getProduct(id);
		productService.delete(product);
		return "redirect:/products";
	}

	@PutMapping(value="/update/{id}")
	public String updateProductPost(@PathVariable int id,@RequestBody Product product){
		Product objProduct = productService.getProduct(id);
		objProduct.setDescription(product.getDescription());
		objProduct.setProductName(product.getProductName());
		objProduct.setPrice(product.getPrice());
		objProduct.setProductType(product.getProductType());
		productService.save(objProduct);
		return "redirect:/products";
	}

}

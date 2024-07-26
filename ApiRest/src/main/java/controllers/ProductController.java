package controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Product;
import domain.ProductRepository;
import domain.RequestProduct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity  getAllProduct() {
		var products = productRepository.findAll();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity postProduct(@RequestBody @Valid  RequestProduct product) {
		Product prod = new Product(product);
		var saveProduct = productRepository.save(prod);
		return ResponseEntity.ok(saveProduct);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity putProduct(@RequestBody @Valid  RequestProduct product) {
		Optional<Product> optionsProduct = productRepository.findById(product.id());
		
		if(optionsProduct.isPresent()){
			Product prod = optionsProduct.get();
			prod.setName(product.name());
			prod.setPrice_in_cents(product.price_in_cents());
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

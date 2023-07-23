package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.exception.StoreException;
import com.store.model.Product;
import com.store.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;
	

	@PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
		
		System.out.println("Received product: " + product);
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PutMapping("{productId}")
	public ResponseEntity<String> updateProductHandler(@Valid @RequestBody Product product , @PathVariable Integer productId)
	{
		return new ResponseEntity<>(productService.updateProduct(product , productId),HttpStatus.OK);
	}
 
	@GetMapping
	public ResponseEntity<List<Product>> getAllProductHandler()
	{
		return new ResponseEntity<>(productService.getProductList(),HttpStatus.OK);
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProductHandler(@PathVariable Integer productId)
	{
		return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProductByIdHandler(@PathVariable Integer productId) throws StoreException
	{
		return new ResponseEntity<>(productService.getProductWithProductId(productId),HttpStatus.OK);
	}

}

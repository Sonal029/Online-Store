package com.store.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.store.exception.StoreException;
import com.store.model.Product;

@Service
public class ProductService {

	private Map<Integer , Product> hm = new HashMap<>();
   
//	adding a product to the hashmap
	
	public String addProduct(Product product)
	{
		Integer productId = generateProductId();
		hm.put(productId, product);
		return("Product added sucessfully");
	}
	
//	updating a product present in the hashmap
	
	public String updateProduct(Product product, Integer productId)
	{
		if(hm.containsKey(productId))
		{
			hm.put(productId, product);
			return("Product updated sucessfully");
		}
		else
		{
			return ("Incorrect productId");
		}
	}
	
//	delete a product
	public String deleteProduct(Integer productId)
	{
		if(hm.containsKey(productId))
		{
			hm.remove(productId);
			return("Product deleted sucessfully");
		}
		else
		{
			return ("Incorrect productId");
		}
	}
	
//	get list of all products
	public List<Product> getProductList()
	{
		return new ArrayList(hm.values());
	}
	
//	get product using product id
	public Product getProductWithProductId(Integer productId) throws StoreException
	{
		if(hm.containsKey(productId))
		{
			return hm.get(productId);
		}
		else
		{
			throw new StoreException("Incorrect productId");
		}
	}
	
	 private static Integer productIdCounter = 1;

	    // Method to generate a unique product ID
	    private Integer generateProductId() {
	        // Use the static counter to generate the next unique product ID
	    	Integer uniqueId = productIdCounter;
	        
	        // Increment the counter for the next product
	        productIdCounter++;

	        return uniqueId;
	    }
	
	
}

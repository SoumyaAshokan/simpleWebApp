package com.example.simpleWebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleWebApp.model.Product;
import com.example.simpleWebApp.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
//	List<Product> products=new ArrayList<>(Arrays.asList(new Product(101,"IPhone",50000),
//										new Product(102,"Sumsung",70000),
//										new Product(103,"Canon camera",4000)));
	
	public List<Product> getProducts() {
		//return products;
		return repo.findAll();
	}
	
	public Product getProductById(int prodId) {
//		return products.stream()
//					   .filter(n->n.getProdId()==prodId)
//					   //.findFirst().get();
//					   .findFirst().orElse(new Product(100,"No Item",0));
		return repo.findById(prodId).orElse(new Product());
	}
	
	public void addProduct(Product prod) {
		//products.add(prod);
		repo.save(prod);
	}
	
	public void updateProduct(Product prod) {
//		int index=0;
//		for(int i=0;i<products.size();i++) {
//			if(products.get(i).getProdId()==prod.getProdId())
//				index=i;
//		}
//		products.set(index, prod);
		
		repo.save(prod);
		
	}
	
	public void deleteProduct(int prodId) {
//		int index=0;
//		for(int i=0;i<products.size();i++) 
//			if(products.get(i).getProdId()==prodId)
//				index=i;
//		products.remove(index);
		
		repo.deleteById(prodId);
	}
}
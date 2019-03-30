package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void updateAllStock() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.getAllProducts();
		for (Product product : products) {
			productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filter) {
		return productRepository.getProductsByFilter(filter);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}

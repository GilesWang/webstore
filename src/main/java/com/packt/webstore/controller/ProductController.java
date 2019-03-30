package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/market")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "product/products";
	}

	@RequestMapping("update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}

	@RequestMapping("/products/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String category) {
		model.addAttribute("products", productService.getProductsByCategory(category));
		return "product/products";
	}

	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> params,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(params));
		return "product/products";
	}

	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product/product";
	}

	@RequestMapping(value = "product/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct", product);
		return "product/addProduct";
	}

	@RequestMapping(value = "product/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product product) {
		productService.addProduct(product);
		return "redirect:/market/products";
	}
}

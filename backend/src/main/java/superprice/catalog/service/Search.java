
package superprice.catalog.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.service.ProductService;
import superprice.catalog.controller.ProductController;
import superprice.catalog.model.Product;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/search")
public class Search {
	private ProductController controller;
	/*
	 * 
	 * public ArrayList<String> getResults() { //import properly ProductController
	 * pc = new ProductController(null); List<Product> lst = pc.getProduct();
	 * Product[] a = (Product[]) lst.toArray(); ArrayList<String> res = new
	 * ArrayList<String>(); HashMap<String, Double> results = new HashMap<String,
	 * Double>();
	 * 
	 * for (int i = 0; a.length > 0; i++) { //change to user input if
	 * (a[i].getTitle().equals("ajax")) { results.put(a[i].getTitle(),
	 * a[i].getPrice()); System.out.println("-"); } } //output to frontend return
	 * res; }
	 */

}
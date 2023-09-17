package superprice.catalog.to_impl.service;
/* 
package superprice.catalog.service;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import superprice.catalog.service.ProductService;
import superprice.catalog.controller.ProductController;
import superprice.catalog.model.Product;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/sprice")
public class SearchByPrice 
{
	public List<Product> getResults()
	{
		ProductServiceImpl psi = new ProductServiceImpl(null);
		//import properly
		ProductController pc = new ProductController(psi);
		List<Product> lst = pc.getProduct();
		Product[] a = (Product[]) lst.toArray();
		List<Product> res = new ArrayList<Product>();
    
	    for (int i = 0; a.length > 0; i++)
	    {
	    	//change to user input 
	    	if (a[i].getTitle().equals("Ajax spray and wipe"))
	    			{
	    				res.add(a[i]);
	    				System.out.println("-");
	    			}    	
	    }
	    Collections.sort(res, new Comparator<Product>()
	    {
	    	public int compare(Product o1, Product o2)
	    	{
	    		return o1.getPrice().compareTo(o2.getPrice());
	    	}
	    });

	    //output to frontend																
	    return res;   
	}

}
*/
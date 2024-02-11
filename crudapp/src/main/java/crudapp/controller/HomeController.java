package crudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudapp.dao.ProductDao;
import crudapp.model.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/home")
    public String home(Model m) {
		m.addAttribute("title","Home Page");
		List<Product> products = productDao.getAllProducts();
		m.addAttribute("products",products);
    	return "home";
    }
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product Form");
		return "add_product_form";
	}
	@RequestMapping(path = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.createProduct(product);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath() + "/home");
		return r;
	}
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath() + "/home");
		return r;
	}
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDao.getProduct(productId);
		m.addAttribute("product",product);
		return "update_product_form";
	}
	@RequestMapping(path = "/update-product", method = RequestMethod.POST)
	public RedirectView showAfterUpdate(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product.toString());
		productDao.updateProduct(product);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath() + "/home");
		return r;
	}
}

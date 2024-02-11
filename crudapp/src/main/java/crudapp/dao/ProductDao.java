package crudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import crudapp.model.Product;

@Component
public class ProductDao {
    @Autowired
	private HibernateTemplate hibernateTemplate;
    @Transactional
    public void createProduct(Product product) {
    	hibernateTemplate.save(product);
    }
    public List<Product> getAllProducts(){
    	List<Product> products = hibernateTemplate.loadAll(Product.class);
    	return products;
    }
    public Product getProduct(int productId) {
    	Product product = hibernateTemplate.get(Product.class, productId);
    	return product;
    }
    @Transactional
    public void deleteProduct(int productId) {
    	Product product = hibernateTemplate.load(Product.class, productId);
    	hibernateTemplate.delete(product);
    }
    @Transactional
    public void updateProduct(Product product) {
    	hibernateTemplate.update(product);
    }
}
